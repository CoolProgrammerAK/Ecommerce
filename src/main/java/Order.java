import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private int userId;
    private String productId;
    private Date orderDate;
    private Date deliveryDate;
    private String status;
    private float totalAmount;
    private ShoppingCart shoppingCart;
    private static List<Order> allOrders = new ArrayList<>();
    private String deliveryStatus;
    // Constraint 19  Unique Order ID
// Constraint 25 Order Cannot Be Marked Delivered Without a Successful Payment
    // Constraint 20: Check if the product is in stock before placing the order
    // Constructor
    public Order(String orderId, int userId, String productId, Date orderDate,
                 Date deliveryDate, String status, float totalPrice) {
        // Constraint 19: Check if the order ID is unique
        for (Order order : allOrders) {
            if (order.getOrderId().equals(orderId)) {
                throw new IllegalArgumentException("Order ID must be unique.");
            }
        }

        boolean productInStock = Product.allInstances().stream()
                .anyMatch(p -> p.getProductId().equals(productId) && p.getStock() > 0);

        if (!productInStock) {
            throw new IllegalArgumentException("The ordered product is out of stock.");
        }

        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.totalAmount = totalPrice;
        this.deliveryStatus = "Placed";
        allOrders.add(this); // Add order to the list of all orders
    }

    // Other methods (cancelOrder, shipOrder, deliverOrder, etc.) remain unchanged...

    // Method to place an order
    public void placeOrder() {
        // This is where we would enforce the stock constraint, so it's handled in the constructor
        this.status = "Placed";
        this.orderDate = new Date();
    }

    public boolean cancelOrder() {
        if (this.status.equals("Placed")) {
            this.status = "Order cancelled";
            return true;
        }
        return false;
    }

    public void shipOrder() {
        if (this.status.equals("Placed")) {
            this.status = "Order shipped";
        }
    }

    // Constraint 25: Cannot mark delivered without successful payment
    public void deliverOrder(List<Payment> payments) {
        if (this.status.equals("Placed")) {
            boolean paymentSuccessful = payments.stream()
                    .anyMatch(p -> p.getOrderId().equals(this.orderId) && p.isPaymentStatus());

            if (paymentSuccessful) {
                this.status = "Order delivered";
                this.deliveryDate = new Date();
                this.deliveryStatus = "Delivered"; // Mark as delivered
            } else {
                System.out.println("Cannot deliver the order. Payment is not successful.");
            }
        }
    }

    // Method to calculate the total price of the order
    public void calculateTotalPrice(float price, int quantity) {
        float totalPrice = 0;
        for (CartItem item : this.shoppingCart.getItems()) {
            totalPrice += item.getProduct().getProductPrice() * item.getQuantity();
        }
        this.totalAmount = price * quantity;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalPrice) {
        this.totalAmount = totalPrice;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(null); // Assuming a ShoppingCart class exists

        // Assuming a product with ID "PRD456" exists and is in stock
        Product product = new Product("PRD456", "TV",10000f,"Des",5); // Assuming Product class exists
        List<Product> products = new ArrayList<>();
        products.add(product); // Adding product to list of products in stock

        // Trying to create an order for a product that is in stock
        Order order = new Order("ORD123", 1, "PRD456", new Date(), null, "Placed", 99.99f);

        // Place the order
        order.placeOrder();
        System.out.println("Order Status: " + order.getStatus());

        // Assuming other operations (like payment, delivery) follow...
    }
}


// Constraint 19  Unique Order ID
// Constraint 25 Order Cannot Be Marked Delivered Without a Successful Payment