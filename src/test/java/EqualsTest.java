import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Objects;
import org.junit.Test;

public class EqualsTest {
    @Test
    public void testNPE() {
        Object obj = null;
        assertTrue(obj.equals("test"));
    }

    @Test
    public void testValideNPE() {
        Object obj = null;
        assertFalse(Objects.equals(obj, "test"));
    }

    @Test
    public void testEquals() {
        Object obj = null;
        assertEquals(obj, "test");
    }

    @Test
    public void testSmallIntegerEquals() {
        Integer a = 1;
        Integer b = 1;

        assertTrue(a == b);
    }

    @Test
    public void testLargeIntegerEquals() {
        Integer a = 300;
        Integer b = 300;
        assertTrue(a == b);
    }
}
