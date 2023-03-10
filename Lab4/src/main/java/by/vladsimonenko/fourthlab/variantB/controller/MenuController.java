package by.vladsimonenko.fourthlab.variantB.controller;

import by.vladsimonenko.fourthlab.variantB.action.GameRoomAction;
import by.vladsimonenko.fourthlab.variantB.service.GameRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


/**
 * Class that help user to interact with program
 */
public class MenuController {
    static Logger logger = LogManager.getLogger();

    /**
     * Method that shows main menu
     */
    private void showMenu() {
        System.out.println(1 + ") Сортировка по цене");
        System.out.println(2 + ") Сортировка по возрасту ребенка");
        System.out.println(3 + ") Поиск игрушек в заданном диапазоне цены");
        System.out.println(4 + ") Вывод всех игрушек комнаты");
        System.out.println(5 + ") Записать информацию в файл");
        System.out.println(6 + ") Выход");

    }

    /**
     * Method that allows the user to interact with the menu
     *
     * @param room current room
     */
    public void mainMenu(GameRoom room) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double min;
        double max;
        GameRoomAction action = new GameRoomAction();

        OUT:
        while (true) {
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    action.sortByPrice(room);
                    break;
                case 2:
                    action.sortByAge(room);
                    break;
                case 3:
                    System.out.println("Введите границы диапазона");
                    min = scanner.nextDouble();
                    max = scanner.nextDouble();
                    action.showInPriceRange(room, min, max);
                    break;
                case 4:
                    logger.info(room);
                    break;
                case 5:
                    action.writeToFile(room);
                    break;
                case 6:
                    break OUT;
                default:
                    logger.error("Неверный ввод данных(введенное число меньше 1  или больше 5 ");

            }

        }
    }
}
