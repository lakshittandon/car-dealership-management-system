// Admin.java
package model;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Admin-specific functionalities
    public void addCarToInventory(CarInventory carInventory, Car car) {
        carInventory.addCar(car);
        System.out.println("Admin added a car to inventory: " + car.getMake() + " " + car.getType());
    }

    public void editCarPrice(Car car, double newPrice) {
        car.setPrice(newPrice);
        System.out.println("Admin edited the price of car: " + car.getMake() + " " + car.getType() +
                " to " + newPrice);
    }
}
