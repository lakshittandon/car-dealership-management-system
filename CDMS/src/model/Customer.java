// Customer.java
package model;

public class Customer {
    private String name;
    private double funds;
    private String username;
    private String password;

    // Default constructor
    public Customer() {
    }

    // Parameterized constructor
    public Customer(String name, double funds, String username, String password) {
        this.name = name;
        this.funds = funds;
        this.username = username;
        this.password = password;
    }

    // Getters and setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters for funds
    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    // Getters and setters for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getters and setters for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
