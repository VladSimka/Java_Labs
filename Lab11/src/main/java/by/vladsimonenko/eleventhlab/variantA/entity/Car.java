package by.vladsimonenko.eleventhlab.variantA.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    static Logger logger = LogManager.getLogger();
    private int number;
    private Semaphore parkingLot;
    private int waitingTime;

    public Car(int number, Semaphore parkingLot, int waitingTime) {
        this.number = number;
        this.parkingLot = parkingLot;
        this.waitingTime = waitingTime;
    }


    @Override
    public void run() {
        try {
            logger.info("Машина №" + number + " прибыла на стоянку");
            if (parkingLot.tryAcquire(waitingTime, TimeUnit.SECONDS)) {
                logger.info("Машина №" + number + " заняла место на стоянке");
                int parkingTime = (int) (Math.random() * 3) + 2;
                TimeUnit.SECONDS.sleep(parkingTime);
                logger.info("Машина №" + number + " пробыла на стоянке "
                        + waitingTime + " сек. и уехала");

            } else {
                logger.info("Машина №" + number + " подождала " + waitingTime + " сек. и уехала на другую стоянку");
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
