public class Rating {
    private String ratingId;
    private int stars;
    private String userId;
    private String productID;
    // Constructor
    public Rating(String ratingId, int stars, String userId, String productId) {
        this.ratingId = ratingId;
        this.stars = stars;
        this.userId = userId;
        this.productID = productId;
    }
    // Getters
    public String getRatingId() {
        return ratingId;
    }
    public int getStars() {
        return stars;
    }
    public String getUserId() {
        return userId;
    }
    public String getProductID() {
        return productID;
    }
    // Setters
    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }
    public void setStars(int stars) {
        if (stars >= 1 && stars <= 5) {
            this.stars = stars;
        } else {
            throw new IllegalArgumentException("Rating must be between 1 and 5 stars.");
        }
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setProductID(String productId) {
        this.productID = productId;
    }
}

