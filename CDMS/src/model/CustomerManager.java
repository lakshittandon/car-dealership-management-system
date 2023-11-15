// CustomerManager.java
package model;

public class CustomerManager {
    private Customer[] customers;
    private int customerCount;

    // Constructor
    public CustomerManager(int capacity) {
        customers = new Customer[capacity];
        customerCount = 0;
    }

    // Sign-up method
    public void signUp(String name, double funds, String username, String password) {
        if (customerCount < customers.length) {
            customers[customerCount++] = new Customer(name, funds, username, password);
            System.out.println("Sign-up successful!");
        } else {
            System.out.println("Customer limit reached. Cannot sign up.");
        }
    }

    // Login method
    public Customer login(String username, String password) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getUsername().equals(username) && customers[i].getPassword().equals(password)) {
                System.out.println("Login successful!");
                return customers[i];
            }
        }
        System.out.println("Invalid username or password. Login failed.");
        return null;
    }
}
