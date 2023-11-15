// Car.java
package model;

public class Car {
    private String make;
    private String type;
    private double price;
    private int year;

    // Constructors, getters, setters...

    // Default constructor
    public Car() {
    }

    // Parameterized constructor
    public Car(String make, String type, double price, int year) {
        this.make = make;
        this.type = type;
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

    // Getters and setters for type
    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
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
        return make.equals(otherCar.make) && type.equals(otherCar.type) && year == otherCar.year;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + type;
    }
}
