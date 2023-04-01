package by.vladsimonenko.eighthlab.variantC.service;

/**
 * Interface that describes Printing Device
 */
public interface PrintingDevice {
    void print(String document);
    void turnOn();
    void turnOff();
}
