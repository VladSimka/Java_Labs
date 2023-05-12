package by.vladsimonenko.fourthlab.variantB.controller;

import by.vladsimonenko.fourthlab.variantB.action.GameRoomAction;
import by.vladsimonenko.fourthlab.variantB.action.Serialization;
import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.threads.DBSelectAllCallable;
import by.vladsimonenko.fourthlab.variantB.threads.DBSelectInPriceRangeCallable;
import by.vladsimonenko.fourthlab.variantB.threads.SerializationThread;
import by.vladsimonenko.fourthlab.variantB.threads.WriterThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


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
        System.out.println(6 + ") Записать информацию в бинарный файл");
        System.out.println(7 + ") Выход");

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
        Serialization serialization = new Serialization();

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

                    List<Toy> toys = null;
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    Future<List<Toy>> future = executor.submit(new DBSelectInPriceRangeCallable(min, max));

                    executor.shutdown();

                    try {
                        toys = future.get();

                        GameRoom gameRoom = new GameRoom(toys);
                        logger.info(gameRoom);
                    } catch (InterruptedException | ExecutionException e) {
                        logger.error(e.getMessage());
                    }

                    break;
                case 4:
                    logger.info(room);
                    break;
                case 5:
                    Thread writerThread = new Thread(new WriterThread(room, action));
                    writerThread.start();
                    break;
                case 6:
                    Thread serializationThread = new Thread(new SerializationThread(serialization, room));
                    serializationThread.start();
                    break;
                case 7:
                    break OUT;
                default:
                    logger.error("Неверный ввод данных(введенное число меньше 1  или больше 5 ");

            }

        }
    }
}
