import org.junit.Test;
import static org.junit.Assert.*;


public class NotificationTest {
    @Test
    public void testNotificationConstructor() {
        // Test seller constructor and getter methods
        Notification notif = new Notification("01","Alert");
        assertEquals("01", notif.getUserID());
        assertEquals("Alert", notif.getContent());


    }
}
