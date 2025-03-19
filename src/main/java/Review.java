import java.util.List;

public class Review {
    private String reviewID;
    private String title;
    private String content;
    private String customerID;
    private String productID;

    // Constraint 26. A Review Must Have a Title and Content of Sufficient Length
    // Constraint 28. A Review Cannot Be Edited to an Empty Title or Content
    // Constraint 32. A Customer Must Have Purchased a Product Before Reviewing It
    // Constructor
    public Review(String reviewID, String title, String content, String customerID, String productID, List<Order> orders) {
        if (title.length() < 5 || content.length() < 20) {
            throw new IllegalArgumentException("Title must be at least 5 characters and content at least 20 characters.");
        }
        if (!hasPurchasedProduct(customerID, productID, orders)) {
            throw new IllegalArgumentException("Customer must have purchased the product before reviewing.");
        }

        this.reviewID = reviewID;
        this.title = title;
        this.content = content;
        this.customerID = customerID;
        this.productID = productID;
    }

    // Method to edit the review content
    public void editContent(String newContent) {
        if (newContent == null || newContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Review content cannot be empty.");
        }
        this.content = newContent;
    }

    // Method to edit the review title
    public void editTitle(String newTitle) {
        if (newTitle == null || newTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Review title cannot be empty.");
        }
        this.title = newTitle;
    }

    // Check if the customer has purchased the product before reviewing
    private boolean hasPurchasedProduct(String customerID, String productID, List<Order> orders) {
        return orders.stream()
                .anyMatch(order -> String.valueOf(order.getUserId()).equals(customerID) && order.getProductId().equals(productID));
    }

    // Getters and Setters
    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() < 5) {
            throw new IllegalArgumentException("Title must be at least 5 characters.");
        }
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content.length() < 20) {
            throw new IllegalArgumentException("Content must be at least 20 characters.");
        }
        this.content = content;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
}
