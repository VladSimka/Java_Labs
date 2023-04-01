package by.vladsimonenko.eighthlab.variantC.action;

import by.vladsimonenko.eighthlab.variantC.service.LaserPrinter;
import by.vladsimonenko.eighthlab.variantC.service.Printer;

import java.util.Scanner;

/**
 * Class to work with Printers
 */
public class PrintingDeviceAction {
    public void showMenu() {
        System.out.println("Выберите действие (-1 для выхода):");
        System.out.println("1) Включить принтер");
        System.out.println("2) Выключить принтер");
        System.out.println("3) Печать");
    }

    public void showLaserPrinterMenu() {
        showMenu();
        System.out.println("4) Заменить картридж");
        System.out.println("5) Проверка уровня тонера");
    }

    public void consoleAppLaserPrinter(LaserPrinter laserPrinter) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int choice;
        out:
        while (true) {
            showLaserPrinterMenu();
            choice = scanner1.nextInt();

            switch (choice) {
                case 1:
                    laserPrinter.turnOn();
                    break;
                case 2:
                    laserPrinter.turnOff();
                    break;
                case 3:
                    System.out.println("Введите текст для печати");
                    String document = scanner2.nextLine();
                    laserPrinter.print(document);
                    break;
                case 4:
                    laserPrinter.replaceToner();
                    break;
                case 5:
                    laserPrinter.checkTonerLevel();
                    break;
                case -1:
                    break out;
                default:
                    System.out.println("Нет такого варианта!");
            }

        }
    }

}

