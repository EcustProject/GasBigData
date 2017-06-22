package ecust.shgas.dao.hive;

import ecust.shgas.task.HiveTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huchao on 2017/6/21.
 */
@Repository
public class HolidayDao {
    @Autowired
    private HiveTask hiveTask;

    public List getHotxx(String condition) {
        String table_name = "hotxx_" + condition;
        String begin_time = condition + "-10-01";
        String end_time = condition + "-10-07";
        String sql1 = "SELECT day(create_time) as day,count(*) as huawu_count FROM " + table_name + " where create_time BETWEEN " + "'" + begin_time + "'" + " and " + "'" + end_time + "'" + " group by day(create_time) ORDER BY day asc";
        String sql2 = "SELECT hour(create_time) as hour,count(*) as huawu_count FROM " + table_name + " where create_time BETWEEN " + "'" + begin_time + "'" + " and " + "'" + end_time + "'" + " group by hour(create_time) ORDER BY hour asc";
        List<String> sqls = new ArrayList<String>();
        sqls.add(sql1);
        sqls.add(sql2);
        hiveTask.setSqls(sqls);
        List results = hiveTask.execute();
        return results;
    }
}
