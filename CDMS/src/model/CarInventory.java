// CarInventory.java
package model;

public class CarInventory {
    private Car[] cars;
    private int carCount;

    // Constructor
    public CarInventory(int capacity) {
        cars = new Car[capacity];
        carCount = 0;
    }

    // Add a car to the inventory
    public void addCar(Car car) {
        if (carCount < cars.length) {
            cars[carCount++] = car;
            System.out.println("Car added to inventory: " + car.getMake() + " " + car.getModel());
        } else {
            System.out.println("Car inventory is full. Cannot add more cars.");
        }
    }

    // Remove a car from the inventory
    public void removeCar(Car car) {
        int index = findCarIndex(car);
        if (index != -1) {
            for (int i = index; i < carCount - 1; i++) {
                cars[i] = cars[i + 1];
            }
            cars[carCount - 1] = null;
            carCount--;
            System.out.println("Car removed from inventory: " + car.getMake() + " " + car.getModel());
        } else {
            System.out.println("Car not found in the inventory.");
        }
    }

    // List all cars in the inventory
    public void listCars() {
        if (carCount == 0) {
            System.out.println("No cars in the inventory.");
        } else {
            System.out.println("Cars in the inventory:");
            for (int i = 0; i < carCount; i++) {
                System.out.println((i + 1) + ". " + cars[i].getMake() + " " + cars[i].getModel());
            }
        }
    }

    // Get the count of cars in the inventory
    public int getCarCount() {
        return carCount;
    }

    // Get an array containing all cars in the inventory
    public Car[] getCars() {
        Car[] allCars = new Car[carCount];
        System.arraycopy(cars, 0, allCars, 0, carCount);
        return allCars;
    }

    // Find the index of a car in the inventory
    private int findCarIndex(Car car) {
        for (int i = 0; i < carCount; i++) {
            if (cars[i].equals(car)) {
                return i;
            }
        }
        return -1; // Car not found
    }
}
