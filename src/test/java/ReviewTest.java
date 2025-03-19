import org.junit.Test;
import static org.junit.Assert.*;


public class ReviewTest {
    @Test
    public void testReviewConstructor() {
        // Test seller constructor and getter methods
        Review review = new Review("01","Loved it","Good Product","02","03",null);
        assertEquals("01", review.getReviewID());
        assertEquals("Loved it", review.getTitle());
        assertEquals("Good Product", review.getContent());
        assertEquals("02", review.getCustomerID());
        assertEquals("03", review.getProductID());


    }
}
