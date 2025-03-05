import java.util.Date;

public class Payment {
    private String paymentID;
    private String orderId;
    private double totalAmount;
    private boolean paymentStatus;
    private String paymentDetails;
    private String status;

    // Constructor
    public Payment(String id, String orderId, double totalAmount, boolean paymentStatus, String paymentDetails) {
        this.paymentID = id;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.paymentDetails = paymentDetails;
    }

    // Method to process the payment
    public boolean confirmTransaction() {
        this.paymentStatus = true;
        this.status = "completed";
        return this.paymentStatus;
    }

    // Method to get the payment date
    public Date getPaymentDate() {


        return new Date();
    }

    // Method to make the transaction
    public boolean makeTransaction() {

        this.paymentStatus = true;
        return this.paymentStatus;
    }

    // Getters and Setters
    public String getPaymentID() {
        return paymentID;
    }

    // Constraint 19: NonEmptyPayemntID
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


    //Constraint 18: paymentStatusWhenCompleted
    public void setStatus(String status) {
        this.status = status;
        if ("completed".equals(status)) {
            this.paymentStatus = true;
        }
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    //Constraint 20: DetailRequiredIfNotpaymentStatus
    public void setPaymentDetails(String paymentDetails) {
        if (!this.paymentStatus && (paymentDetails == null || paymentDetails.trim().isEmpty())) {
            throw new IllegalArgumentException("paymentDetails cannot be empty if the payment is not completed.");
        }
        this.paymentDetails = paymentDetails;
    }

    //Constraints 21: SingleInvoice

}
