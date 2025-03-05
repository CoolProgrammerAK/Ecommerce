import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String address;
    private String phone;
    private List<Order> orders;
    private ShoppingCart shoppingCart;
    private Wishlist wishlist;

    // Constructor
    public Customer(int userId, String username, String password, String email, String address, String phone) {
        super(userId, username, password, email);
        this.address = address;
        this.phone = phone;
        this.orders = new ArrayList<>();
        this.shoppingCart = new ShoppingCart(null);
        this.wishlist = new Wishlist();
    }

    // Methods to interact with the shopping cart
    public void addToCart(Product product) {
        this.shoppingCart.addItem(product, getUserId());
    }

    public void removeFromCart(Product product) {
        this.shoppingCart.removeItem(product);
    }

    // Methods to interact with the wishlist
    public void addToWishlist(Product product) {
        this.wishlist.addItem(product);
    }

    public void removeFromWishlist(Product product) {
        this.wishlist.removeItem(product);
    }

    // Method to place an order
    public Order placeOrder() {
        // Logic to create and add an order to the customer's list of orders.
        for (CartItem item : this.shoppingCart.getItems()) {
            if (item.getQuantity() > item.getProduct().getStock()) {
                throw new IllegalStateException("Cannot place order: Item quantity exceeds stock.");
            }
        }
        Order newOrder = new Order(address, getUserId(), address, null, null, address, getUserId());
        orders.add(newOrder);
        return newOrder;
    }

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public ShoppingCart createCart() {
        return new ShoppingCart(this);
    }

}
