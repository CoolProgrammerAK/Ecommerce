import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private static List<User> allUsers = new ArrayList<>();

    public User(int userId, String username, String password, String email) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public boolean verifyUser() {
        return this.username != null && this.password != null;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    // Constraint 42: UniqueUserID
    //Constraint 43: OnlyOneRegistration
    public void register(String username, String password, String email) {
        for (User user : allUsers) {
            if (user.getUserId() == userId) {
                throw new IllegalArgumentException("UserId must be unique.");
            }
            if (user.getUsername().equals(username)) {
                throw new IllegalArgumentException("A user with this username is already registered.");
            }
        }

        allUsers.add(new User(userId, username, password, email));
    }

    public void updateProfile(String newUsername, String newPassword, String newEmail) {
        this.username = newUsername;
        this.password = newPassword;
        this.email = newEmail;
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUsername() { return username; }

    //Constraint 41:NonEmptyUsername
    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

