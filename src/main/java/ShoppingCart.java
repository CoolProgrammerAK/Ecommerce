import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;
    private Date creationDate;
    private Customer owner;

    public ShoppingCart(Customer owner) {
        this.items = new ArrayList<>();
        this.owner = owner;
        this.creationDate = new Date(); // Set the creation date to the current date
    }

    public void addItem(Product product, int quantity) {

        for (CartItem item : items) {
            if (item.getProduct().getProductId().equals(product.getProductId())) {

                return;
            }
        }
        this.items.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        this.items.removeIf(item -> item.getProduct().equals(product));
    }

    public void clear() {
        this.items.clear();
    }

    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getProduct().getProductPrice() * item.getQuantity();
        }
        return total;
    }

    // Getters
    public List<CartItem> getItems() {
        return items;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    // Setters
    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<CartItem> checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot checkout an empty shopping cart.");
        }
        return items;
    }
    public Customer getOwner() {
        return owner;
    }

}
