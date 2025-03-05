import org.junit.Test;
import static org.junit.Assert.*;


public class CustomerTest {
    @Test
    public void testCustomerConstructor() {
        // Test seller constructor and getter methods
        Customer customer = new Customer(1, "johnsmith", "Hello@123", "johnsmith@gmail.com", "Montreal,QC,Canada","438000000");
        assertEquals(1, customer.getUserId());
        assertEquals("johnsmith", customer.getUsername());
        assertEquals("Hello@123", customer.getPassword());
        assertEquals("johnsmith@gmail.com", customer.getEmail());
        assertEquals("Montreal,QC,Canada",customer.getAddress());
        assertEquals("438000000",customer.getPhone());
    }
}
