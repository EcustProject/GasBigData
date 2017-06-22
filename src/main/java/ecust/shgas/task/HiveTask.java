package ecust.shgas.task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Component
public class HiveTask {
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<String> sqls;

    public List<String> getSqls() {
        return sqls;
    }

    public void setSqls(List<String> sqls) {
        this.sqls = sqls;
    }

    public List execute(){
        List<Future<List>> futures = new ArrayList<Future<List>>();
        for(String sql : sqls) {
            Task task = new Task(sql);
            Future f = taskExecutor.submit(task);
            futures.add(f);
        }

        List results = new LinkedList();
        for (Future<List> future : futures) {
            // Future返回如果没有完成，则一直循环等待，直到Future返回完成
            while (!future.isDone())
            {
                try {
                    results.add(future.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return results;
    }

    private class Task implements Callable{
        private  String sql;

        public Task(String sql){
            this.sql = sql;
        }

        public List call() throws Exception{
            List<Map<String, Object>> result = jdbcTemplate.queryForList(this.sql);
            return result;
        }
    }
}
