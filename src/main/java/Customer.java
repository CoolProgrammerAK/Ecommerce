public class Customer extends User {
    private String address;
    private String phone;

    private ShoppingCart shoppingCart;
    public Customer(int userId, String username, String password, String email, String address, String phone) {
        super(userId, username, password, email);
        this.address = address;
        this.phone = phone;
    }

    public void addToCart(Product product) {
        this.shoppingCart.addItem(product, getUserId());
    }

    public void removeFromCart(Product product) {
        this.shoppingCart.removeItem(product);
    }

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

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public ShoppingCart createCart() {
        return new ShoppingCart(this);
    }




}
