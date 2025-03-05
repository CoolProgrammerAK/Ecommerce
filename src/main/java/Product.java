public class Product {
    private String productId;
    private String productName;
    private float productPrice;
    private String productionDescription;
    private int stock;

    // Constructor
    public Product(String productId, String productName, float price, String description,int stock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = price;
        this.productionDescription = description;
        this.stock=stock;
    }

    // Method to add this product to a shopping cart
    public void addToCart(ShoppingCart cart) {
        cart.addItem(this, 1);
    }

    // Method to retrieve the product's details
    public String getProductDetails() {
        return "Product ID: " + productId + ", Name: " + productName +
                ", Price: " + productPrice + ", Description: " + productionDescription;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float price) {
        this.productPrice = price;
    }

    public String getProductionDescription() {
        return productionDescription;
    }

    public void setProductionDescription(String description) {
        this.productionDescription = description;
    }

    public int getStock() {

        return stock;
    }

    public int setStock(int stock) {
        return this.stock=stock;
    }
}
