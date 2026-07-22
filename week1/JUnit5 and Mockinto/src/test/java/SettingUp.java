import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SettingUp {

    @Test
    public void testBasicMath() {
        // A simple test to verify JUnit is functioning correctly
        int expected = 4;
        int actual = 2 + 2;

        assertEquals("2 + 2 should equal 4", expected, actual);
        System.out.println("JUnit is successfully set up in the week1 folder!");
    }
}