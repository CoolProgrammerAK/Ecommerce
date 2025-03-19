import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private static List<User> allUsers = new ArrayList<>();

    // Constraint 1  Unique Username and Email for Users
    // Constraint 2 Password Validation
    // Constraint 4 Email Format Validation
    // Constraint 6  Username restrictions

    // Regex patterns
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9_]{5,}$");

    public User(int userId, String username, String password, String email) {
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            throw new IllegalArgumentException("Invalid username: Must be at least 5 characters long and contain only letters, digits, and underscores.");
        }
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException("Invalid password: Must be at least 8 characters long with an uppercase, lowercase, digit, and special character.");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static User register(String username, String password, String email) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                throw new IllegalArgumentException("Username already taken.");
            }
            if (user.getEmail().equals(email)) {
                throw new IllegalArgumentException("Email already in use.");
            }
        }

        int newUserId = allUsers.size() + 1;
        User newUser = new User(newUserId, username, password, email);
        allUsers.add(newUser);
        return newUser;
    }

    public static User login(String username, String password) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // Login failed
    }

    public void updateProfile(String newUsername, String newPassword, String newEmail) {
        if (!USERNAME_PATTERN.matcher(newUsername).matches()) {
            throw new IllegalArgumentException("Invalid username: Must be at least 5 characters long and contain only letters, digits, and underscores.");
        }
        if (!PASSWORD_PATTERN.matcher(newPassword).matches()) {
            throw new IllegalArgumentException("Invalid password: Must be at least 8 characters long with an uppercase, lowercase, digit, and special character.");
        }
        if (!EMAIL_PATTERN.matcher(newEmail).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        // Ensure new username and email are unique
        for (User user : allUsers) {
            if (!user.equals(this)) {
                if (user.getUsername().equals(newUsername)) {
                    throw new IllegalArgumentException("Username already taken.");
                }
                if (user.getEmail().equals(newEmail)) {
                    throw new IllegalArgumentException("Email already in use.");
                }
            }
        }

        this.username = newUsername;
        this.password = newPassword;
        this.email = newEmail;
    }

    public boolean verifyUser() {
        return this.username != null && this.password != null;
    }

    // Getters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
}
