import org.junit.Test;
import static org.junit.Assert.*;


public class CustomerSupportTest {
    @Test
    public void testCustomerSupportConstructor() {
        // Test seller constructor and getter methods
        CustomerSupport customersupport = new CustomerSupport(1, "johnsmith", "Hello@123", "johnsmith@gmail.com", "Orders");
        assertEquals(1, customersupport.getUserId());
        assertEquals("johnsmith", customersupport.getUsername());
        assertEquals("Hello@123", customersupport.getPassword());
        assertEquals("johnsmith@gmail.com",customersupport.getEmail());
        assertEquals("Orders",customersupport.getDepartment());
    }
}
