package by.vladsimonenko.eleventhlab.variantA.entity;

import java.util.concurrent.Semaphore;


/**
 * Class - semaphore that represents parking lot
 */
public class ParkingLot extends Semaphore {
    public ParkingLot(int permits) {
        super(permits);
    }
}
