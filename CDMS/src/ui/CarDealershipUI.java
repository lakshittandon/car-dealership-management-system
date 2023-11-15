// CarDealershipUI.java
package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import model.CarInventory;
import model.Customer;
import model.CustomerManager;
import model.Admin;
import model.Car;

public class CarDealershipUI extends Application {

    private Customer loggedInCustomer;
    private CarInventory carInventory;

    private TextField signUpUsernameField;
    private PasswordField signUpPasswordField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Car Dealership Management System");

        // Create text fields for username and password
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        TextField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginCustomerButton = new Button("Login as Customer");
        Button loginAdminButton = new Button("Login as Admin");
        Button signUpButton = new Button("Sign Up");
        Button viewInventoryButton = new Button("View Inventory");
        Button purchaseButton = new Button("Purchase");

        loginCustomerButton.setOnAction(e -> handleLogin("customer", primaryStage, usernameField.getText(), passwordField.getText()));
        loginAdminButton.setOnAction(e -> handleLogin("admin", primaryStage, usernameField.getText(), passwordField.getText()));
        signUpButton.setOnAction(e -> handleSignUp(primaryStage)); // Handle Sign Up button
        viewInventoryButton.setOnAction(e -> handleViewInventory(primaryStage));
        purchaseButton.setOnAction(e -> handlePurchase(primaryStage));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(usernameField, passwordField, loginCustomerButton, loginAdminButton, viewInventoryButton, purchaseButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    // ... (other methods)

    private void handleLogin(String userType, Stage primaryStage, String username, String password) {
        // Use userType to distinguish between customer and admin logins
        if (userType.equals("admin")) {
            // Admin login
            Admin admin = new Admin("admin", "admin123");
            handleAdminActions(admin, primaryStage);
        } else if (userType.equals("customer")) {
            // Customer login
            // Implement your logic to handle customer login
            CustomerManager customerManager = new CustomerManager(10);
            loggedInCustomer = customerManager.login(username, password);
    
            if (loggedInCustomer != null) {
                System.out.println("Customer login successful. Welcome, " + loggedInCustomer.getName() + "!");
                // Additional logic for customer...
            } else {
                System.out.println("Login failed. Please check your username and password.");
            }
        }
    }

    private void handleAdminActions(Admin admin, Stage primaryStage) {
        // Admin-specific actions
        System.out.println("Admin login successful. Welcome, Admin!");
        // Additional logic for admin...

        // For example, adding a car to inventory
        Car newCar = new Car("Ford", "Mustang", 35000.0, 2022);
        admin.addCarToInventory(carInventory, newCar);

        // Editing the price of a car
        Car carToEdit = carInventory.getCars()[0]; // Assuming there is at least one car in inventory
        double newPrice = 30000.0;
        admin.editCarPrice(carToEdit, newPrice);
    }
    private void handleViewInventory(Stage primaryStage) {
        // Implement logic to show the inventory using JavaFX dialog or scene transition
        // Example:
        carInventory = new CarInventory(20);
        carInventory.addCar(new Car("Toyota", "Camry", 25000.0, 2022));
        carInventory.addCar(new Car("Honda", "Accord", 27000.0, 2022));
        carInventory.listCars();
    }

    private void handlePurchase(Stage primaryStage) {
        // Implement purchase logic using JavaFX dialog or scene transition
        // Example:
        if (carInventory != null && loggedInCustomer != null && carInventory.getCarCount() > 0) {
            Car carToPurchase = carInventory.getCars()[0];
            double carPrice = carToPurchase.getPrice();

            if (loggedInCustomer.getFunds() >= carPrice) {
                loggedInCustomer.setFunds(loggedInCustomer.getFunds() - carPrice);
                carInventory.removeCar(carToPurchase);
                System.out.println("Purchase successful. Remaining funds: " + loggedInCustomer.getFunds());
            } else {
                System.out.println("Insufficient funds to purchase the car.");
            }
        } else {
            System.out.println("No cars available for purchase.");
        }
    }

    private void handleSignUp(Stage primaryStage) {
        // Implement sign-up logic using JavaFX dialog or scene transition
        // Example:
        System.out.println("Sign Up button clicked. Implement sign-up logic here.");
    }
}
