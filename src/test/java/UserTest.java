import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void testUserConstructor() {
        // Test user constructor and getter methods
        User user = new User(1, "username", "password", "email");
        assertEquals(1, user.getUserId());
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("email", user.getEmail());
    }
}
