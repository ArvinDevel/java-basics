import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

/**
 * Volatile necessary illusation： use it to keep visibility , otherwise the variable will be
 * eventual sync
 */
@Slf4j
public class VolatileTest {
    private static /*volatile */ boolean flg = true;

    private static int[] array = new int[10000];
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private VolatileTest() {
    }

    static void out() throws Exception {
        log.info("enter{}", array[0]);
        while (flg) {
            //    write read can't trigger  non-volatile data reload
            for (int i = 0; i < array.length; i++) {
                array[i]++;
            }
//            atomicInteger.incrementAndGet();
//            below these could cause reload non-volatile data, reason is not found
//            new ClassTest();
//            new Scanner(System.in);
//            log.info("still alive");
//            Thread.sleep(1);
            // has synchronized keyword to guarantee visibility
            //            System.out.println();

        }
        log.info("exit {},{}", array[0], atomicInteger.get());
    }

    /**
     * parent class and child class use different class level lock
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            try {
                VolatileTest.out();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(100);
        VolatileTest.flg = false;
        log.info("set flg to false succeed");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + 1;
        }
        atomicInteger.incrementAndGet();
        log.info("main out {},{}", array[0], atomicInteger.get());
    }
}
