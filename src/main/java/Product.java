import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class Product {
    private String productId;
    private String productName;
    private float productPrice;
    private String productionDescription;
    private int stock;
    private static List<Product> allProducts = new ArrayList<>();
    // Constraint 7  Price Must Be Greater Than Zero and Limited to Two Decimal Places
    // Constraint 8  Product Name Must Be At Least 3 Characters Long and Alphanumeric
    // Constraint 9  Product Description Must Be Between 10 and 500 Characters and Cannot Be
    //Just Spaces

    private static final Pattern PRODUCT_NAME_PATTERN = Pattern.compile("^[A-Za-z0-9 ]{3,}$");

    public Product(String productId, String productName, float price, String description, int stock) {
        this.productId = productId;
        setProductName(productName);
        setProductPrice(price);
        setProductionDescription(description);
        setStock(stock);
        allProducts.add(this);
    }

    public void addToCart(ShoppingCart cart) {
        cart.addItem(this, 1);
    }

    public String getProductDetails() {
        return "Product ID: " + productId + ", Name: " + productName +
                ", Price: " + productPrice + ", Description: " + productionDescription;
    }

    public String getProductId() {
        return productId;
    }
    public static List<Product> allInstances() {
        return allProducts;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (!PRODUCT_NAME_PATTERN.matcher(productName).matches() || productName.length() < 3) {
            throw new IllegalArgumentException("Invalid product name: Must be at least 3 characters long and contain only letters, numbers, and spaces.");
        }
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Invalid product price: Must be greater than zero.");
        }
        BigDecimal roundedPrice = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        this.productPrice = roundedPrice.floatValue();
    }

    public String getProductionDescription() {
        return productionDescription;
    }

    public void setProductionDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid product description: Cannot be empty.");
        }
        if (description.length() < 10 || description.length() > 500) {
            throw new IllegalArgumentException("Invalid product description: Must be between 10 and 500 characters.");
        }
        this.productionDescription = description;
    }

    public int getStock() {
        return stock;
    }

    public int setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Invalid stock quantity: Cannot be negative.");
        }
        return this.stock = stock;
    }
}
