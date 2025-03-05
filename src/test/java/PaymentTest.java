import org.junit.Test;
import static org.junit.Assert.*;


public class PaymentTest {
    @Test
    public void testPaymentConstructor() {
        // Test payment constructor and getter methods
        Payment pay = new Payment("O1", "E1", 100, true, "Payment success");
        assertEquals("O1", pay.getPaymentID());
        assertEquals("E1", pay.getOrderId());
        assertEquals(100, pay.getTotalAmount(),0.001);
        assertEquals(true, pay.isPaymentStatus());
        assertEquals("Payment success", pay.getPaymentDetails());
    }
}
