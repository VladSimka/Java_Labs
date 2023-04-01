package by.vladsimonenko.eighthlab.variantC._main;

import by.vladsimonenko.eighthlab.variantB.action.ProductAction;
import by.vladsimonenko.eighthlab.variantC.action.PrintingDeviceAction;
import by.vladsimonenko.eighthlab.variantC.service.LaserPrinter;
import by.vladsimonenko.eighthlab.variantC.service.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Class with main method for variant C
 */
public class PrinterMain {
    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        LaserPrinter laserPrinter = new LaserPrinter(1);

        Scanner scanner = new Scanner(System.in);
        PrintingDeviceAction action = new PrintingDeviceAction();

        action.consoleAppLaserPrinter(laserPrinter);


    }
}
