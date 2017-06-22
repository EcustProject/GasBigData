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
public class ExecutorTask {
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List sqlCollection;

    public void setSqlCollection(List sqlCollection) {
        this.sqlCollection = sqlCollection;
    }

    public List executeTask(){
        int taskNums = this.sqlCollection.size();
        List<Future<List>> futures = new ArrayList<Future<List>>();
        for (int i=0;i < taskNums; i++){
            String sql = this.sqlCollection.get(i).toString();
            Task task = new Task(sql);
            futures.add(this.taskExecutor.submit(task));
        }
        List results = new LinkedList();
        for (Future<List> future : futures) {
            while (!future.isDone());// Future返回如果没有完成，则一直循环等待，直到Future返回完成
            {
                try {
                    System.out.println("task运行结果" + future.get());
                    results.add(future.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(results);
        return results;
    }

    private class Task implements Callable{
        private  String sql;
        public Task(String sql){
            this.sql = sql;
        }
        public List call() throws Exception{
            System.out.println("listCall");
            List<Map<String, Object>> temp = jdbcTemplate.queryForList(this.sql);
            System.out.println(temp);
            return temp;
        }
    }
}
