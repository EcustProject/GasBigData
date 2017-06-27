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

    public List getHotxx(Map<String, String> condition) {
        Map<String,List> maps = new LinkedHashMap<String, List>();
        List limits1 = new ArrayList();
        List limits2 = new ArrayList();
        String table_name = "hotxx" +"_orc";
        String begin_time = condition.get("year") + "-10-01";
        String end_time = condition.get("year") + "-10-07";
        String newYear_begin = condition.get("begin");
        String newYear_end = condition.get("end");
        String sql1 = "SELECT day(create_time) as day,count(*) as huawu_count FROM ? where to_date(create_time) BETWEEN ?  and ? group by day(create_time) ORDER BY day asc";
        String sql2 = "SELECT hour(create_time) as hour,count(*) as huawu_count FROM ? where to_date(create_time) BETWEEN ?  and ? group by hour(create_time) ORDER BY hour asc";
        String sql3 = "SELECT day(create_time) as day1,count(*) as huawu_count FROM ? where to_date(create_time) BETWEEN ?  and ? group by day(create_time) ORDER BY day1 asc";
        String sql4 = "SELECT hour(create_time) as hour1,count(*) as huawu_count FROM ? where to_date(create_time) BETWEEN ?  and ? group by hour(create_time) ORDER BY hour1 asc";
        limits1.add(table_name);
        limits1.add(begin_time);
        limits1.add(end_time);

        limits2.add(table_name);
        limits2.add(newYear_begin);
        limits2.add(newYear_end);

        maps.put(sql1, limits1);
        maps.put(sql2, limits1);
        maps.put(sql3, limits2);
        maps.put(sql4, limits2);
        sqlTool.setMap(maps);
        List<String> res= sqlTool.sqlset();
        hiveTask.setSqls(res);
        List results = hiveTask.execute();
        return results;
    }
}
