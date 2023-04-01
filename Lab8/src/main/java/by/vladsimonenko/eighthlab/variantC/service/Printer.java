package by.vladsimonenko.eighthlab.variantC.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class that describes Printer
 */
public class Printer implements PrintingDevice {
    static final Logger logger = LogManager.getLogger();
    private boolean isOn;

    public Printer() {
        this.isOn = false;
    }

    @Override
    public void print(String document) {
        if (isOn) {
            logger.info("Распечатан следующий текст:\n" + document);
        } else {
            throw new RuntimeException("Печать невозможна, принтер выключен!");
        }
    }

    @Override
    public void turnOn() {
        logger.info("Принтер включен!");
        this.isOn = true;
    }

    @Override
    public void turnOff() {
        logger.info("Принтер выключен!");
        this.isOn = false;
    }

}
