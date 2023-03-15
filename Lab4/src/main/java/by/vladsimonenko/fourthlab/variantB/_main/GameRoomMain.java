package by.vladsimonenko.fourthlab.variantB._main;

import by.vladsimonenko.fourthlab.variantB.action.Serialization;
import by.vladsimonenko.fourthlab.variantB.controller.MenuController;
import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;
import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

/**
 * Class with main method for variant B
 */
public class GameRoomMain {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CreatorException {
        Serialization serialization = new Serialization();
        Scanner scanner = new Scanner(System.in);
        double money;
        System.out.println("Введите доступную сумму денег");
        money = scanner.nextDouble();
        try {
            if (money < 0) {
                throw new IllegalArgumentException("Недопустимое количество денег, взято асболютное значение указанной суммы");
            }
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            money = Math.abs(money);
        }


        GameRoom room = new GameRoom(money);
        serialization.serialize(room, args[0]);

        MenuController menu = new MenuController();
        menu.mainMenu(room);
    }
}
