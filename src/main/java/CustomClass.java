import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomClass<T> {
    T placeholder;
    static long sleepTime = TimeUnit.SECONDS.toMillis(3);

    static synchronized void syncParent() throws Exception {
        while (true) {
            Thread.sleep(sleepTime);
            log.info("syncParent, runtime class is {}", CustomClass.class);
        }
    }

    static class Child extends CustomClass {
        static synchronized void syncChild() throws Exception {
            while (true) {
                Thread.sleep(sleepTime);
                log.info("syncChild, runtime class is {}", Child.class);
            }
        }
    }


    /**
     * parent class and child class use different class level lock
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            try {
                Child.syncChild();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                CustomClass.syncParent();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

