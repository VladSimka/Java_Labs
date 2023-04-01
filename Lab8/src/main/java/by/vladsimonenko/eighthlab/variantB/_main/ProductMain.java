package by.vladsimonenko.eighthlab.variantB._main;

import by.vladsimonenko.eighthlab.variantB.action.ProductAction;
import by.vladsimonenko.eighthlab.variantB.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Class with main method for variant B
 */
public class ProductMain {
    static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        ButterImpls butter = new ButterImpls(1,"31124","Минская марка",
                3.99,"07.04.2023", 5,884);
        MilkImpls milk = new MilkImpls(5,"41421","Брест-Литовск",
                2.99,"10.04.2023", 23,3);
        CottageCheeseImpls cottageCheese = new CottageCheeseImpls(1,"34457","Савушкин продукт",
                3.99,"15.04.2023", 10,9);
        Scanner scanner = new Scanner(System.in);

        ProductAction action = new ProductAction();

        out:
        while(true) {
            logger.info("Выберите продукт:");
            logger.info("1)Молоко");
            logger.info("2)Масло");
            logger.info("3)Творог");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    action.consoleApp(milk);
                    break out;
                case 2:
                    action.consoleApp(butter);
                    break out;
                case 3:
                    action.consoleApp(cottageCheese);
                    break out;
                default:
                    logger.error("Нет такого варианта ответа");
            }


        }


    }
}
