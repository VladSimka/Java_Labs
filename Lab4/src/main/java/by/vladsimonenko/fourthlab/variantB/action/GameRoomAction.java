package by.vladsimonenko.fourthlab.variantB.action;

import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.service.GameRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to interact with GameRoom
 */
public class GameRoomAction {

    static Logger logger = LogManager.getLogger();


    /**
     * Method for sorting GameRoom by price
     *
     * @param room current GameRoom
     */
    public void sortByPrice(GameRoom room) {
        logger.info("Комната отсортирована по цене игрушек");
        Toy[] toys = room.getToys();
        for (int i = 0; i < toys.length; i++) {
            for (int j = 0; j < toys.length - 1; j++) {
                if (toys[i].getPrice() >= toys[j].getPrice()) {
                    Toy tmp = toys[i];
                    toys[i] = toys[j];
                    toys[j] = tmp;

                }
            }
        }
        //logger.info(room);
    }

    /**
     * Method for sorting GameRoom by age
     *
     * @param room current GameRoom
     */
    public void sortByAge(GameRoom room) {
        Toy[] toys = room.getToys();

        for (int i = 0; i < toys.length; i++) {
            for (int j = 0; j < toys.length - 1; j++) {
                if (toys[i].getAge() < toys[j].getAge()) {
                    Toy tmp = toys[i];
                    toys[i] = toys[j];
                    toys[j] = tmp;
                }
            }
        }
        logger.info("Комната отсортирована по возрастной категории");
    }

    /**
     * Method that shows toys of GameRoom in current price renge
     *
     * @param room current GameRoom
     * @param min  minimal price
     * @param max  maximum price
     */
    public void showInPriceRange(GameRoom room, double min, double max) {
        logger.info("Ищутся игрушки с ценой в заданном диапазоне");
        for (int i = 0; i < room.getToys().length; i++) {
            if (room.getToys()[i].getPrice() >= min && room.getToys()[i].getPrice() <= max) {
                System.out.println(room.getToys()[i]);
            }
        }
    }

    /**
     * Method to write information about GameRoom to file
     * @param room current room
     */
    public void writeToFile(GameRoom room) {
        try (FileWriter writer = new FileWriter("gameRoom.txt", false)) {
            writer.write(String.valueOf(room));
            writer.flush();
        } catch (IOException e) {
            logger.error("Ошибка при записи файла" + e.getMessage());
        }
        finally {
            logger.debug("Была произведена попытка записи информации про игровую комнату в файл");
        }

    }
}


