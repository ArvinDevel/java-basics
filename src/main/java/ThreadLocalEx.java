import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalEx {
    ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    void method() {
        integerThreadLocal.set(88);
        try {

        } catch (Exception e) {
            log.info("error info, append with stack trace:", e);
        } finally {
            integerThreadLocal.remove();
        }
    }
}
