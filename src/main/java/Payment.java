import java.util.List;
public class Payment {
    private String paymentID;
    private String orderId;
    private double totalAmount;
    private boolean paymentStatus;
    private String paymentDetails;
    private String status;
    // Constraint 22 Payment Total Must Match Order Total Amount
// Constraint 23  Payment ID Must Be Unique Across All Payments
    // Constraint 24 Payment Details Must Contain Meaningful Information
    // Constructor
    public Payment(String id, String orderId, double totalAmount, boolean paymentStatus, String paymentDetails) {
        this.paymentID = id;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        setPaymentDetails(paymentDetails); // Use setter to validate payment details
    }

    // Method to process the payment
    public boolean confirmTransaction() {
        this.paymentStatus = true;
        this.status = "completed";
        return this.paymentStatus;
    }

    // Getters and Setters
    public String getPaymentID() {
        return paymentID;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty.");
        }
        this.paymentID = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setpaymentStatus(boolean paymentStatus) {
        if (!paymentStatus && (paymentDetails == null || paymentDetails.trim().isEmpty())) {
            throw new IllegalArgumentException("paymentDetails are required if the payment is not completed.");
        }
        this.paymentStatus = paymentStatus;
    }

    public void setStatus(String status) {
        this.status = status;
        if ("completed".equals(status)) {
            this.paymentStatus = true;
        }
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        if (paymentDetails == null || paymentDetails.trim().length() < 6) {
            throw new IllegalArgumentException("paymentDetails must contain at least 6 characters.");
        }
        this.paymentDetails = paymentDetails;
    }

    // Method to ensure that the payment total matches the order's total amount
    public boolean validatePaymentMatchesOrderTotal(Order order) {
        return this.totalAmount == order.getTotalAmount();
    }

    // Static method to ensure Payment ID is unique
    public static boolean isPaymentIdUnique(String paymentID, List<Payment> existingPayments) {
        for (Payment payment : existingPayments) {
            if (payment.getPaymentID().equals(paymentID)) {
                return false; // ID is not unique
            }
        }
        return true; // ID is unique
    }
}

