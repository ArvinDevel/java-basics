import java.lang.reflect.Method;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassTest {
    @Override
    public ClassTest clone() {
        return null;
    }

    void classClass() throws Exception {
        String className = "java.lang.String";
        // forName
        Class clazz = Class.forName(className);
        log.info("{} instanceof Class {} ", clazz, (Object) clazz instanceof String);
        log.info("{} klass is {} ", className, clazz);
        log.info("{} klassklass is {} ", className, clazz.getClass().getClass());
        log.info("{} klassklass's klass is {} ", className, clazz.getClass().getClass().getClass());

        // new instance
        clazz.getModifiers();
        String string = (String) clazz.newInstance();
    }

    public int returnInt() {
        return 0;
    }

    void primitiveClass() throws Exception {
        // only can use .class
        Class intClazz = int.class;
        log.info("int.class is {}, which is instanceof Class {} ", intClazz, intClazz instanceof Class);
        log.info("{} instanceof Object {} , ", intClazz, intClazz instanceof Object, intClazz.isInstance(10));
        Class clazz = Integer.class;
        log.info("Integer.class is {} ", clazz);
        Integer integer = new Integer(100);
        log.info("integer.getClass() is equal to Integer.class {} ", integer.getClass(), Integer.class == integer.getClass());
        log.info("10  isInstance  int.class {} ", intClazz.isInstance(10)/*, 10 instanceof Class*/);
        log.info("10  isInstance  Integer.class {} ", clazz.isInstance(10));
        Class<? extends Class> c = clazz.getClass();

        // primitive class usage
        log.info("Integer.TYPE: {} == int {}, isPrimitive {} isAnnotation {}",
            Integer.TYPE, intClazz == Integer.TYPE, intClazz.isPrimitive(), intClazz.isAnnotation());
        Method returnIntMethod = getClass().getMethod("returnInt");
        // used for reflection
        if (returnIntMethod.getReturnType() == int.class) {
            log.info("{} return type is {}", returnIntMethod, int.class);
        }
        if (returnIntMethod.getReturnType() == Integer.class) {
            log.info("{} return type is {}", returnIntMethod, Integer.class);
        }
        // wrapper used for generic
        Future<Void> voidFuture = new CompletableFuture<>();
    }

    void mainOps() throws Exception {
        primitiveClass();
        classClass();
    }

    long sleepTime = TimeUnit.MINUTES.toMillis(10);

    void genericScene() {
        Object boy = new CustomClass();
        CustomClass<Integer> girl = (CustomClass)(new  Object());
        log.info("{} runtime class is {}, {} runtime class is {} ", boy, boy.getClass(), girl, girl.getClass());
    }


    void syncClass() throws Exception {
        synchronized (Class.class) {
            // theorically, we can't allocate new type obj out of this thread;
            Thread.sleep(sleepTime);
        }
        log.info("exit");
    }

    void getCustomInstance() throws Exception {
        String className = "CustomClass";
        Class clazz = Class.forName(className);
        log.info("{}'s classloader is {} super loader is {} ", className, clazz, clazz.getClassLoader());
    }

    public static void main(String[] args) throws Exception {
        new ClassTest().genericScene();
    }
}
