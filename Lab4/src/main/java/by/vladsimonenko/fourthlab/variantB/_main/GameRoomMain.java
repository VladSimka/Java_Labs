package by.vladsimonenko.fourthlab.variantB._main;

import by.vladsimonenko.fourthlab.variantB.action.GameRoomAction;
import by.vladsimonenko.fourthlab.variantB.controller.MenuController;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.service.GameRoom;

import java.util.Random;
import java.util.Scanner;

/**
 * Class with main method for variant B
 */
public class GameRoomMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money;
        System.out.println("Введите доступную сумму денег");
        money = scanner.nextDouble();
        GameRoom room = new GameRoom(money);
        MenuController menu = new MenuController();
        menu.mainMenu(room);
    }
}
