package by.vladsimonenko.eighthlab.variantB.action;

import by.vladsimonenko.eighthlab.variantB.service.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Class that works with Product
 */
public class ProductAction {
    static final Logger logger = LogManager.getLogger();

    /**
     * Method to show menu
     */
    public void showMainMenu() {
        System.out.println("1) Данные о товаре");
        System.out.println("2) Переместить товар на склад");
        System.out.println("3) Переместить в торговый зал");
        System.out.println("4) Оплатить товар");
        System.out.println("5) Списать");
        System.out.println("6) Поменять id товара");
        System.out.println("7) Выход");
    }

    /**
     * Method fo work with product
     * @param product current product
     */
    public void consoleApp(Product product) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        out:
        while (true) {
            showMainMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("---------------------------");
                    System.out.println(product);
                    System.out.println("---------------------------");
                    break;
                case 2:
                    product.moveToWarehouse();
                    break;
                case 3:
                    product.moveToStore();
                    break;
                case 4:
                    product.pay();
                    break;
                case 5:
                    product.writeOff();
                    break;
                case 6:
                    System.out.println("Введите новый id");
                    int id = scanner.nextInt();
                    product.setId(id);
                    break;
                case 7:
                    break out;
                default:
                    System.out.println("Нет такого варианта!");
            }

        }
    }
}
