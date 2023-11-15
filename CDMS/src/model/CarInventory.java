// CarInventory.java
package model;

import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Car added to inventory: " + car.getMake() + " " + car.gettype());
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
            System.out.println("Car removed from inventory: " + car.getMake() + " " + car.gettype());
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
                System.out.println((i + 1) + ". " + cars[i].getMake() + " " + cars[i].gettype());
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

    public Car[] searchCars(String make, String type) {
        List<Car> matchingCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMake().equals(make) && car.gettype().equals(type)) {
                matchingCars.add(car);
            }
        }

        return matchingCars.toArray(new Car[0]);
    }



    public void hardcodeCars() {
        Car car1 = new Car("Toyota", "Sedan", 200000.0, 2022);
        Car car2 = new Car("Honda", "Sedan", 220000.0, 2022);
        Car car3 = new Car("Ford", "Sedan", 240000.0, 2022);

        Car car4 = new Car("Volkswagen", "Hatchback", 160000.0, 2022);
        Car car5 = new Car("Mazda", "Hatchback", 180000.0, 2022);
        Car car6 = new Car("Hyundai", "Hatchback", 200000.0, 2022);

        Car car7 = new Car("Jeep", "SUV", 300000.0, 2022);
        Car car8 = new Car("Chevrolet", "SUV", 320000.0, 2022);
        Car car9 = new Car("Nissan", "SUV", 340000.0, 2022);

        Car car10 = new Car("Kia", "Sedan", 230000.0, 2022);
        Car car11 = new Car("BMW", "Hatchback", 280000.0, 2022);
        Car car12 = new Car("Audi", "SUV", 360000.0, 2022);

        Car car13 = new Car("Toyota", "Hatchback", 190000.0, 2022);
        Car car14 = new Car("Honda", "Sedan", 250000.0, 2022);
        Car car15 = new Car("Ford", "SUV", 330000.0, 2022);


        addCar(car1);
        addCar(car2);
        addCar(car3);
        addCar(car4);
        addCar(car5);
        addCar(car6);
        addCar(car7);
        addCar(car8);
        addCar(car9);
        addCar(car10);
        addCar(car11);
        addCar(car12);
        addCar(car13);
        addCar(car14);
        addCar(car15);

    }
}
