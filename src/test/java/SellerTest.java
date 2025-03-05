import org.junit.Test;
import static org.junit.Assert.*;


public class SellerTest {
    @Test
    public void testSellerConstructor() {
        // Test seller constructor and getter methods
        Seller seller = new Seller(1, "johnsmith", "Hello@123", "johnsmith@gmail.com", "Montreal,QC,Canada","438000000");
        assertEquals(1, seller.getUserId());
        assertEquals("johnsmith", seller.getUsername());
        assertEquals("Hello@123", seller.getPassword());
        assertEquals("johnsmith@gmail.com", seller.getEmail());
        assertEquals("Montreal,QC,Canada", seller.getAddress());
        assertEquals("438000000", seller.getPhone());
    }
}
