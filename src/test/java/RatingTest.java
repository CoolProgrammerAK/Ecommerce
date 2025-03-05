import org.junit.Test;
import static org.junit.Assert.*;


public class RatingTest {
    @Test
    public void testRatingConstructor() {
        // Test seller constructor and getter methods
        Rating rating = new Rating("01",4,"02","03");
        assertEquals("01", rating.getRatingId());
        assertEquals(4, rating.getStars());
        assertEquals("02", rating.getUserId());
        assertEquals("03", rating.getProductID());


    }
}
