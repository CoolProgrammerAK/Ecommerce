import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void testProductConstructor() {
        // Test product constructor and getter methods
        Product product = new Product("P1", "Test Product", 10.0f, "Description",2);
        assertEquals("P1", product.getProductId());
        assertEquals("Test Product", product.getProductName());
        assertEquals(10.0f, product.getProductPrice(), 0.001);
        assertEquals("Description", product.getProductionDescription());
        assertEquals(2, product.getStock());
    }

}
