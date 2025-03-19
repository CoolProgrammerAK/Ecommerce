import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private List<Product> product;
    // Constraint 15 A Wishlist Cannot Be Empty
    // Constraint 16  A Wishlist Cannot Contain Duplicate Products
    // Constraint 17 A Wishlist Cannot Contain More Than 20 Products
    public Wishlist(Product initialProduct) {
        if (initialProduct == null) {
            throw new IllegalArgumentException("Wishlist must have at least one product.");
        }
        this.product = new ArrayList<>();
        this.product.add(initialProduct);
    }

    // Method to add an item to the wishlist
    public void addItem(Product p) {
        if (product.size() >= 20) {
            throw new IllegalStateException("Wishlist cannot contain more than 20 products.");
        }

        if (!product.contains(p)) { // Prevent adding duplicates
            product.add(p);
        }
    }

    // Method to remove an item from the wishlist
    public void removeItem(Product p) {
        product.remove(p);
    }

    // Method to clear the wishlist
    public void clear() {
        product.clear();
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
