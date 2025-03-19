import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private String ticketID;
    private String customerQuery;
    private boolean isResolved;
    private User user;
    private static List<Ticket> allTickets = new ArrayList<>(); // To keep track of all tickets
     // Constaint 34. A Ticket Must Have a Valid Customer Query
    // Constaint 35. A Customer Cannot Have More Than Five Open Tickets at a Time
    // Constaint 36 A Ticket Can Be Marked Resolved Only If It Was Previously Unresolved

    // Constructor
    public Ticket(String ticketID, String customerQuery, User user) {
        if (customerQuery == null || customerQuery.length() < 10) {
            throw new IllegalArgumentException("Customer query must be at least 10 characters long.");
        }

        // Check if the customer already has 5 unresolved tickets
        long openTickets = allTickets.stream().filter(t -> t.isResolved == false && t.user.equals(user)).count();
        if (openTickets >= 5) {
            throw new IllegalArgumentException("A customer cannot have more than five open tickets at a time.");
        }

        this.ticketID = ticketID;
        this.customerQuery = customerQuery;
        this.isResolved = false;
        this.user = user;
        allTickets.add(this); // Add the ticket to the list of all tickets
    }

    // Getters and Setters
    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getCustomerQuery() {
        return customerQuery;
    }

    public void setCustomerQuery(String customerQuery) {
        if (customerQuery == null || customerQuery.length() < 10) {
            throw new IllegalArgumentException("Customer query must be at least 10 characters long.");
        }
        this.customerQuery = customerQuery;
    }

    public boolean isResolved() {
        return isResolved;
    }

    // Method to raise a ticket
    public void raiseTicket() {
        System.out.println("Ticket raised with ID: " + this.ticketID + " by user: " + user.getUsername());
    }

    // Method to resolve a ticket
    public void resolveTicket() {
        if (this.isResolved) {
            throw new IllegalStateException("This ticket is already resolved and cannot be reopened.");
        }
        this.isResolved = true;
        System.out.println("Ticket with ID: " + this.ticketID + " has been resolved.");
    }

    public void setResolved(boolean resolved) {
        // Ensure the ticket can only be marked as resolved if it was previously unresolved
        if (this.isResolved && resolved) {
            throw new IllegalStateException("This ticket has already been resolved and cannot be reopened.");
        }
        this.isResolved = resolved;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Assuming a User class exists with a getUsername() method
        User user = new User(54, "John Doe","","");  // Placeholder for user creation

        try {
            // Creating a new ticket
            Ticket ticket = new Ticket("TCK123", "My order hasn't arrived yet.", user);
            ticket.raiseTicket(); // Raising the ticket

            // Checking if the ticket is resolved (expecting false)
            System.out.println("Is the ticket resolved? " + ticket.isResolved());

            // Resolving the ticket
            ticket.resolveTicket();

            // Checking if the ticket is resolved (expecting true)
            System.out.println("Is the ticket resolved? " + ticket.isResolved());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}