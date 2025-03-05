public class Notification {
    private String userID;
    private String message;

    // Constructor
    public Notification(String userID, String message) {
        this.userID = userID;
        this.message = message;
    }

    // Method to create a new notification (factory method pattern)
    public static Notification sendNotification(String message) {
        String id = generateUniqueId();
        return new Notification(id, message);
    }

    // Method to generate a unique ID for the notification
    private static String generateUniqueId() {
        return "NOTIF-" + System.currentTimeMillis();
    }

    // Getters and Setters
    public String getUserID() {
        return userID;
    }

    public void setUserID(String id) {
        this.userID = id;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }
}
