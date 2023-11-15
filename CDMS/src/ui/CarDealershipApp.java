// CarDealershipApp.java
package ui;

import model.Customer;
import model.CustomerManager;

public class CarDealershipApp {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(10);

        // Test sign-up
        customerManager.signUp("John Doe", 50000.0, "john_doe", "password123");

        // Test login
        Customer loggedInCustomer = customerManager.login("john_doe", "password123");

        // Additional logic based on login status...
        if (loggedInCustomer != null) {
            System.out.println("Welcome, " + loggedInCustomer.getName() + "!");
            // Perform actions for logged-in customers, e.g., display available cars, initiate purchases, etc.
        } else {
            System.out.println("Login failed. Please check your credentials.");
            // Handle unsuccessful login, e.g., prompt user to retry, display error message, etc.
        }
    }
}
