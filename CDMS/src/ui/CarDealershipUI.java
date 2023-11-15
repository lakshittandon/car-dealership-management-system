// CarDealershipUI.java
package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

import model.CarInventory;
import model.Customer;
//import model.CustomerManager;
import model.Admin;
import model.Car;
import model.CustomerDatabase;

public class CarDealershipUI extends Application {

    private Customer loggedInCustomer;
    private CarInventory carInventory;
    private CustomerDatabase customerDatabase;


    private TextField signUpUsernameField;
    private PasswordField signUpPasswordField;
    private TextField phoneNumberField;
    private Text signUpMessage;
    private Text loginMessage= new Text();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        carInventory = new CarInventory(20);
        carInventory.hardcodeCars();
        customerDatabase = new CustomerDatabase();
        customerDatabase.hardcodeUsers();
    
        primaryStage.setTitle("Car Dealership Management System");
    
        // Call the showLoginScreen method
        showLoginScreen(primaryStage);
    
        primaryStage.show();
    }
    
    private void showLoginScreen(Stage primaryStage) {
        Label titleLabel = new Label("WELCOME TO CAR DEALERSHIP");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        titleLabel.setAlignment(Pos.CENTER);
    
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
    
        Button loginCustomerButton = new Button("Login as Customer");
        Button loginAdminButton = new Button("Login as Admin");
        Button signUpButton = new Button("Sign Up");
    
        loginCustomerButton.setOnAction(e -> handleLogin("customer", primaryStage, usernameField.getText(), passwordField.getText()));
        loginAdminButton.setOnAction(e -> handleLogin("admin", primaryStage, usernameField.getText(), passwordField.getText()));
        signUpButton.setOnAction(e -> showSignUpScreen(primaryStage));
    
        loginMessage = new Text();
        loginMessage.setFill(Color.GREEN);
    
        VBox layout = new VBox(10);
        layout.getChildren().addAll(titleLabel, usernameField, passwordField, loginCustomerButton, loginAdminButton, signUpButton, loginMessage);
    
        Scene scene1 = new Scene(layout, 500, 300);
        primaryStage.setScene(scene1);
    }
    
    private void showSignUpScreen(Stage primaryStage) {
        primaryStage.setTitle("Sign Up");
    
        Label signUpLabel = new Label("SIGN UP");
        signUpLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-transform: uppercase;"); // Increased font size, made it all caps
        signUpLabel.setAlignment(Pos.CENTER);
    
        signUpUsernameField = new TextField();
        signUpUsernameField.setPromptText("Username");
    
        signUpPasswordField = new PasswordField();
        signUpPasswordField.setPromptText("Password");
    
        phoneNumberField = new TextField(); // New text field for phone number
        phoneNumberField.setPromptText("Phone Number");

        signUpMessage = new Text(); // Text node to display the message
        signUpMessage.setStyle("-fx-fill: red;"); // Set the text color to red
    
        Button signUpSubmitButton = new Button("Submit");
        signUpSubmitButton.setOnAction(e -> handleSignUpSubmit(primaryStage));
    
        Button backButton = new Button("Back to Login");
        backButton.setOnAction(e -> showLoginScreen(primaryStage)); // Set the action to go back to scene1
    
        VBox signUpLayout = new VBox(10);
        signUpLayout.getChildren().addAll(signUpLabel, signUpUsernameField, signUpPasswordField, phoneNumberField, signUpSubmitButton, backButton, signUpMessage);
        signUpLayout.setAlignment(Pos.CENTER);
    
        Scene scene2 = new Scene(signUpLayout, 500, 300); // Set the size of scene2
        primaryStage.setScene(scene2);
    }


    private String getTypeSelection(ToggleGroup toggleGroup) {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        return selectedRadioButton != null ? selectedRadioButton.getText() : null;
    }


    private void showCarsScreen(Stage primaryStage) {
        primaryStage.setTitle("Select Car");

        Label titleLabel = new Label("SELECT CAR");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        titleLabel.setAlignment(Pos.CENTER);

        // Dropdown list for car make
        ComboBox<String> makeComboBox = new ComboBox<>();
        makeComboBox.setPromptText("Select Make");
        makeComboBox.getItems().addAll("All","Toyota", "Ford", "Honda", "Chevrolet", "BMW");

        // Radio buttons for car type
        ToggleGroup typeToggleGroup = new ToggleGroup();
        RadioButton sedanRadioButton = new RadioButton("Sedan");
        sedanRadioButton.setToggleGroup(typeToggleGroup);
        RadioButton hatchbackRadioButton = new RadioButton("Hatchback");
        hatchbackRadioButton.setToggleGroup(typeToggleGroup);
        RadioButton suvRadioButton = new RadioButton("SUV");
        suvRadioButton.setToggleGroup(typeToggleGroup);

        // Additional controls as needed

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> handleCarSearch(primaryStage, makeComboBox.getValue(), getTypeSelection(typeToggleGroup)));

        VBox carsLayout = new VBox(10);
        carsLayout.getChildren().addAll(titleLabel, makeComboBox, sedanRadioButton, hatchbackRadioButton, suvRadioButton, searchButton);
        carsLayout.setAlignment(Pos.CENTER);

        Scene scene3 = new Scene(carsLayout, 500, 300);
        primaryStage.setScene(scene3);
    }


    private void handleLogin(String userType, Stage primaryStage, String username, String password) {
        // Use userType to distinguish between customer and admin logins
        if (userType.equals("admin")) {
            // Admin login
            Admin admin = new Admin("admin", "admin123");
            handleAdminActions(admin, primaryStage);
        } else if (userType.equals("customer")) {
            // Customer login
            // Implement your logic to handle customer login
            loggedInCustomer = customerDatabase.login(username, password);
    
            if (loggedInCustomer != null) {
                loginMessage.setText("Login successful. Welcome, " + loggedInCustomer.getUsername() + "!");
                showCarsScreen(primaryStage);
            } else {
                loginMessage.setText("Login failed. Please check your username and password.");
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

    private void handleSignUpSubmit(Stage primaryStage) {
        // Implement sign-up submission logic here
        // Retrieve data from text fields (signUpUsernameField, signUpPasswordField, phoneNumberField)
        String username = signUpUsernameField.getText();
        String password = signUpPasswordField.getText();
        String phoneNumber = phoneNumberField.getText();
        Customer customer = new Customer(username, password, phoneNumber);
        
        if(CustomerDatabase.usernameExists(username)) {
            signUpMessage.setText("Sign Up failed. Username already exists.");
        }
        else{
            CustomerDatabase.addCustomer(customer);// Add customer to the database
            signUpMessage.setText("Sign Up successful. You can go back to login.");
        }

        // Print the list of customers for verification (you can remove this in production)
        System.out.println("List of Customers:");
        for (int i = 0; i < CustomerDatabase.getCustomerCount(); i++) {
            System.out.println(CustomerDatabase.getCustomers()[i].getUsername() + " - " + CustomerDatabase.getCustomers()[i].getPhone());
        }
        // You can add more sophisticated logic based on your requirements

        // After handling signup, you can navigate back to the login screen or another screen
        primaryStage.setScene(primaryStage.getScene());
    }

    private void handleCarSearch(Stage primaryStage, String make, String type) {
        // Implement logic for searching cars based on the selected criteria (make, type, etc.)
        // For now, let's assume you have a method in CarInventory to search for cars
        Car[] matchingCars = carInventory.searchCars(make, type);
    
        // Display the search results (you can customize this based on your UI design)
        if (matchingCars.length > 0) {
            System.out.println("Search Results:");
            for (Car car : matchingCars) {
                System.out.println(car.getMake() + " " + car.gettype() + " - $" + car.getPrice() + " - Year " + car.getYear());
            }
        } else {
            System.out.println("No matching cars found.");
        }
    
        // Navigate back to the login screen or another screen after handling car search
        showLoginScreen(primaryStage);
    }

}
