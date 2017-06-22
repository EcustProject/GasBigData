package ecust.shgas.task;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
public class ExecutorTask {
    private  ExecutorService executor;
    private List sqlCollection;
    private List resultSet;
    private List<Future<List>> resultList;
    private JdbcTemplate jdbcTemplate;
    public  ExecutorTask(List sqls, JdbcTemplate jdbcTemplate){
        this.executor = Executors.newCachedThreadPool();
       this.resultList = new ArrayList<Future<List>>();
        this.sqlCollection = sqls;
        this.resultSet = null;
        this.jdbcTemplate = jdbcTemplate;
    }
    public List executeTask(){
        int len = this.sqlCollection.size();
        for (int i=0;i<len;i++){
            String sql = this.sqlCollection.get(i).toString();
            Task task = new Task(sql);
            Future<List> future = this.executor.submit(task);
            this.resultList.add(future);
        }
        for (Future<List> future : resultList) {
            while (!future.isDone());// Future返回如果没有完成，则一直循环等待，直到Future返回完成
            {
                try {
                    System.out.println("task运行结果"+future.get());
                    this.resultSet.add(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.resultList;
    }
    class Task implements Callable{
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
