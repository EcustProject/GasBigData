package ecust.shgas.dao.hive;

import ecust.shgas.domain.Hot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.hadoop.hive.HiveRunner;
import org.springframework.data.hadoop.hive.HiveScript;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by wenqing on 2017/6/20.
 */
@Repository
public class HiveTestDao {
    // 执行普通的sql查询
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // 执行hive脚本
    @Autowired
    private HiveRunner hiveRunner;
    public List<Hot> getHots() {
        RowMapper<Hot> rowMapper=new BeanPropertyRowMapper<Hot>(Hot.class);
        List<Hot> hots = jdbcTemplate.query("select serial_number,create_time,fy_xingshi,fy_neirong from hotxx_2012 " +
                "where create_time >= '2012-08-01' and create_time <= '2012-12-01'", rowMapper);
        return hots;
    }

    public void executeHiveScript() {
        Map<String, String> args = new HashMap<String, String>();
        args.put("TABLE", "hotxx_2016");
        args.put("START_DATE", "2016-06-30");
        args.put("END_DATE", "2016-11-01");
        try {
            Collection<HiveScript> scripts = new ArrayList<HiveScript>();
            HiveScript script = new HiveScript(new ClassPathResource(
                    "hive/test_group_by.q"),args);
            scripts.add(script);
            hiveRunner.setScripts(scripts);
            hiveRunner.call();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "Failed to setup search_clicks table in hive!", e);
        }
    }
}
