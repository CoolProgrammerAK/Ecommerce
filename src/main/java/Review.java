public class Review {
    private String reviewID;
    private String title;
    private String content;
    private String customerID;
    private String productID;

    // Constructor
    public Review(String reviewID, String title, String content, String customerID, String productID) {
        this.reviewID = reviewID;
        this.title = title;
        this.content = content;
        this.customerID = customerID;
        this.productID = productID;
    }

    // Method to edit the review content
    public void editContent(String newContent) {
        this.content = newContent;
    }

    // Method to edit the review title
    public void editTitle(String newTitle) {
        this.title = newTitle;
    }

    // Method to delete the review (this would set the review's content to indicate it's been deleted)
    public void delete() {
        this.content = "This review has been deleted.";
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
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
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
