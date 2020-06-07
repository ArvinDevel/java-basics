import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Double check Locking single instance  impl:
 * volatile guarantee visibility(preventing from reorder's uninitialized object)
 */
public class VolatileSI {
    private static /*volatile */ VolatileSI INSTANCE;

    private VolatileSI() {
    }

    static VolatileSI getInstance() {
        if (INSTANCE == null) {// if second thread see the INSTANCE, it must be fully initialized
            synchronized (VolatileSI.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VolatileSI();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        VolatileSI.getInstance();
    }
}
