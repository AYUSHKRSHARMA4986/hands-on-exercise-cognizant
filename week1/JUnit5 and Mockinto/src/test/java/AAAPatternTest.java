import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AAAPatternTest {

    // This is our test fixture (the shared state we are testing against)
    private List<String> shoppingCart;

    // The @Before method runs automatically BEFORE every single @Test method.
    // It is used to initialize variables and set up a fresh environment.
    @Before
    public void setUp() {
        shoppingCart = new ArrayList<>();
        System.out.println("@Before: Initialized an empty shopping cart.");
    }

    // The @After method runs automatically AFTER every single @Test method.
    // It is used to clean up resources, close connections, or reset data.
    @After
    public void tearDown() {
        shoppingCart.clear();
        shoppingCart = null;
        System.out.println("@After: Cleaned up the shopping cart.\n");
    }

    @Test
    public void testAddItemToCart() {
        // ----------------------------------------------------
        // 1. ARRANGE: Set up the specific data for this test
        // ----------------------------------------------------
        String item = "Mechanical Keyboard";

        // ----------------------------------------------------
        // 2. ACT: Execute the specific action you are testing
        // ----------------------------------------------------
        shoppingCart.add(item);

        // ----------------------------------------------------
        // 3. ASSERT: Verify the expected outcomes
        // ----------------------------------------------------
        assertEquals("Cart should have exactly 1 item", 1, shoppingCart.size());
        assertTrue("Cart should contain the exact item added", shoppingCart.contains(item));

        System.out.println("Test: Successfully executed testAddItemToCart.");
    }

    @Test
    public void testClearCart() {
        // 1. ARRANGE (Note: shoppingCart is already initialized by @Before)
        shoppingCart.add("Wireless Mouse");
        shoppingCart.add("USB-C Hub");

        // 2. ACT
        shoppingCart.clear();

        // 3. ASSERT
        assertEquals("Cart should be empty after clearing", 0, shoppingCart.size());

        System.out.println("Test: Successfully executed testClearCart.");
    }
}