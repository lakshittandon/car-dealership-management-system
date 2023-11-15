// Car.java
package model;

public class Car {
    private String make;
    private String model;
    private double price;
    private int year;

    // Constructors, getters, setters...

    // Default constructor
    public Car() {
    }

    // Parameterized constructor
    public Car(String make, String model, double price, int year) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    // Getters and setters for make
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    // Getters and setters for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getters and setters for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getters and setters for year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Additional methods...

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car otherCar = (Car) obj;
        return make.equals(otherCar.make) && model.equals(otherCar.model) && year == otherCar.year;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}
