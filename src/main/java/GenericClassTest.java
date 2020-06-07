import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * Verify Class for generic is only one
 */
@Slf4j
public class GenericClassTest {
    void sameRuntimeClass() {
        CustomClass<String> boy = new CustomClass<>();
        CustomClass<Integer> girl = new CustomClass<>();
        Class<? extends CustomClass> clazz = boy.getClass();
        log.info("{} runtime class is {}, {} runtime class is {} ", boy, boy.getClass(), girl, girl.getClass());
    }

    public static void main(String[] args) throws Exception {
        new GenericClassTest().sameRuntimeClass();
    }
}
