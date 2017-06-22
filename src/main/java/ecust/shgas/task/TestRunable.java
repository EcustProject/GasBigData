package ecust.shgas.task;

import org.springframework.stereotype.Component;

/**
 * Created by wenqing on 2017/6/22.
 */
@Component
public class TestRunable implements Runnable {
    public void run() {
        System.out.println("TestRunable.run()");
        for(int i = 0; i < 10; i++) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test : " + i);
        }
    }
}
