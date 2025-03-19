import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;
    private Date creationDate;
    private Customer owner;

    // Constraint 11  No Duplicate Products in the Cart
    // Constraint 12  Product Quantity in Cart Must Be at Least 1 and Not Exceed Available Stock
    // Constraint 14  A User Cannot Have More Than 10 Items of the Same Product in the Cart

    public ShoppingCart(Customer owner) {
        this.items = new ArrayList<>();
        this.owner = owner;
        this.creationDate = new Date(); // Set the creation date to the current date
    }

    public void addItem(Product product, int quantity) {
        // Check for existing product in the cart
        for (CartItem item : items) {
            if (item.getProduct().getProductId().equals(product.getProductId())) {
                // If product exists, update the quantity
                int updatedQuantity = item.getQuantity() + quantity;
                if (updatedQuantity <= 10 && updatedQuantity <= product.getStock()) {
                    item.setQuantity(updatedQuantity);
                }
                return; // Exit method if product was updated
            }
        }

        // Add new product if not already in the cart
        if (quantity >= 1 && quantity <= product.getStock() && quantity <= 10) {
            this.items.add(new CartItem(product, quantity));
        } else {
            throw new IllegalArgumentException("Invalid quantity. Must be between 1 and the available stock, and no more than 10.");
        }
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
            total += item.getQuantity() * item.getProduct().getProductPrice();
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
