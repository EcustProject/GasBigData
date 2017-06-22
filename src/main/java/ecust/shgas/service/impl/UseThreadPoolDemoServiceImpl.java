package ecust.shgas.service.impl;

import ecust.shgas.service.UseThreadPoolDemoService;
import ecust.shgas.task.TestCallable;
import ecust.shgas.task.TestRunable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by wenqing on 2017/6/22.
 */
@Service
public class UseThreadPoolDemoServiceImpl implements UseThreadPoolDemoService {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private TestCallable testCallable;
    @Autowired
    private TestRunable testRunable;

    public void threadTest() {
        threadPoolTaskExecutor.submit(testRunable);
        Future<List<String>> f = threadPoolTaskExecutor.submit(testCallable);
        try {
            List<String> results = f.get();
            for(String s : results)
                System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
