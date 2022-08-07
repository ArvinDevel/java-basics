import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class InitializationTest {
    @Test
    public void initializedValue4Ref() {
        Initialization initialization = new Initialization();
        assertTrue(Objects.equals(initialization.getInteger(), null));
        assertEquals(null, initialization.getString());
    }
    @Test
    public void initializedValue4Basic() {
        Initialization initialization = new Initialization();
        assertEquals(0, initialization.getAnInt());
    }

}