package by.vladsimonenko.eleventhlab.variantA._main;

import by.vladsimonenko.eleventhlab.variantA.entity.Car;
import by.vladsimonenko.eleventhlab.variantA.entity.ParkingLot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {
    public static void main(String[] args) {
        int parkingSpaces = 5;
        int amountOfCars = 10;


        ParkingLot parkingLot = new ParkingLot(parkingSpaces);
        ExecutorService carExecutor = Executors.newFixedThreadPool(amountOfCars);

        for (int i = 0; i < amountOfCars; i++) {
            int waitingTime = (int) (Math.random() * 4) + 1;
            Car car = new Car(i + 1, parkingLot, waitingTime);
            carExecutor.execute(car);
        }

        carExecutor.shutdown();
    }
}
