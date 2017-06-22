package ecust.shgas.task;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by wenqing on 2017/6/22.
 */
@Component
public class TestCallable implements Callable<List<String>> {
    public List<String> call() throws Exception {
        System.out.println("TestCallable.call()");
        List<String> list = new LinkedList<String>();
        for(int i = 0; i < 10; i++) {
            list.add("call " + i);
            Thread.currentThread().sleep(100);
        }
        return list;
    }
}
