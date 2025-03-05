import java.util.Date;

public class Order {
    private String orderId;
    private int userId;
    private String productId;
    private Date orderDate;
    private Date deliveryDate;
    private String status;
    private float totalAmount;
    private ShoppingCart shoppingCart;

    // Constructor
    public Order(String orderId, int userId, String productId, Date orderDate,
                 Date deliveryDate, String status, float totalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.totalAmount = totalPrice;
    }

    public Order(String string, int i, String string2, float f, ShoppingCart cart) {
        // TODO Auto-generated constructor stub
    }

    // Method to place an order
    public void placeOrder() {
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

    public void deliverOrder() {
        if (this.status.equals("Placed")) {
            this.status = "Order delivered";
            this.deliveryDate = new Date();

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

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(null); // Assuming a ShoppingCart class exists
        Order order = new Order("ORD123", 1, "PRD456", 99.99f, cart);

        // Place the order
        order.placeOrder();
        System.out.println("Order Status: " + order.getStatus());

        // Try to cancel the order
        if (order.cancelOrder()) {
            System.out.println("Order was cancelled.");
        } else {
            System.out.println("Order could not be cancelled.");
        }


        // Ship the order
        order.shipOrder();
        System.out.println("Order Status: " + order.getStatus());

        // Deliver the order
        order.deliverOrder();
        System.out.println("Order Status: " + order.getStatus());
    }
}

