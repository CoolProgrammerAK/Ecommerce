import org.junit.Test;
import static org.junit.Assert.*;


public class CartItemTest {
    @Test
    public void testCartItemConstructor() {
        // Test seller constructor and getter methods
        Product product=new Product("P1", "Test Product", 10.0f, "Description",1);
        CartItem item = new CartItem(product,4);
        assertEquals(product, item.getProduct());
        assertEquals(4, item.getQuantity());


    }
}
