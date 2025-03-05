import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private List<Product> product;

    public Wishlist() {
        this.product = new ArrayList<>(); // Initialize the wishlist with an empty list of product
    }

    // Method to add an item to the wishlist
    public void addItem(Product p) {
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


    public List<Product> getproduct() {
        return product;
    }

    public void setproduct(List<Product> product) {
        this.product = product;
    }
}
