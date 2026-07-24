import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    // --- EXERCISE 1: Mocking and Stubbing ---
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    // --- EXERCISE 2: Verifying Interactions ---
    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Call the method via the service.
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 3. Verify the interaction.
        // This checks: "Did service.fetchData() actually trigger mockApi.getData() behind the scenes?"
        verify(mockApi).getData();
    }
}