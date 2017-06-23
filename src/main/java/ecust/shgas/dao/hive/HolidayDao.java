package ecust.shgas.dao.hive;

import ecust.shgas.task.HiveTask;
import ecust.shgas.util.SqlTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by huchao on 2017/6/21.
 */
@Repository
public class HolidayDao {
    @Autowired
    private HiveTask hiveTask;
    @Autowired
    private SqlTool sqlTool;

    public List getHotxx(String condition) {
        Map<String,List> maps = new LinkedHashMap<String, List>();
        List limits = new ArrayList();
        String table_name = "hotxx_" + condition;
        String begin_time = condition + "-10-01";
        String end_time = condition + "-10-07";
        String sql1 = "SELECT day(create_time) as day,count(*) as huawu_count FROM ? where create_time BETWEEN ?  and ? group by day(create_time) ORDER BY day asc";
        String sql2 = "SELECT hour(create_time) as hour,count(*) as huawu_count FROM ? where create_time BETWEEN ?  and ? group by hour(create_time) ORDER BY hour asc";
        limits.add(table_name);
        limits.add(begin_time);
        limits.add(end_time);
        maps.put(sql1, limits);
        maps.put(sql2, limits);
        sqlTool.setMap(maps);
        List<String> res= sqlTool.sqlset();
        hiveTask.setSqls(res);
        List results = hiveTask.execute();
        return results;
    }
}
