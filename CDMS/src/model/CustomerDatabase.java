//CustomerDatabase.java
package model;

public class CustomerDatabase {
    public static Customer[] customers = new Customer[100]; // Assuming a maximum of 100 customers for simplicity
    private static int customerCount = 0;

    // Method to check if a username already exists
    public static boolean usernameExists(String username) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getUsername().equals(username)) {
                return true; // Username already exists
            }
        }
        return false; // Username does not exist
    }

    // Method to add a new customer to the database
    public static void addCustomer(Customer newCustomer) {
        customers[customerCount++] = newCustomer;
    }

    public static int getCustomerCount() {
        return customerCount;
    }

    public static Customer[] getCustomers() {
        return customers;
    }

    // Method to hardcode some users for testing
    public void hardcodeUsers() {
        addCustomer(new Customer("user1", "pass1", "1234567890"));
        addCustomer(new Customer("user2", "pass2", "9876543210"));
        addCustomer(new Customer("user3", "pass3", "5555555555"));
        addCustomer(new Customer("user4", "pass4", "1231231234"));
        addCustomer(new Customer("user5", "pass5", "7778889999"));
    }

    // Sign-up method
    public void signUp(String username, String password, String phoneNumber) {
        if (!usernameExists(username) && customerCount < customers.length) {
            addCustomer(new Customer(username, password, phoneNumber));
            System.out.println("Sign-up successful!");
        } else if (usernameExists(username)) {
            System.out.println("Username already exists. Please choose another username.");
        } else {
            System.out.println("Customer limit reached. Cannot sign up.");
        }
    }

    // Login method
    public Customer login(String username, String password) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getUsername().equals(username) && customers[i].getPassword().equals(password)) {
                return customers[i];
            }
        }

        // No match found
        return null;
    }

}