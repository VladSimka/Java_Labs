package by.vladsimonenko.fourthlab.variantB.action;

import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

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
        List<Toy> toys = room.getToys();
        toys.sort(Comparator.comparingDouble(Toy::getPrice));
        room.setToys(toys);
    }

    /**
     * Method for sorting GameRoom by age
     *
     * @param room current GameRoom
     */
    public void sortByAge(GameRoom room) {
        List<Toy> toys = room.getToys();
        toys.sort(Comparator.comparingInt(Toy::getAge));
        room.setToys(toys);
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
        for (int i = 0; i < room.getToys().size(); i++) {
            if (room.getToys().get(i).getPrice() >= min && room.getToys().get(i).getPrice() <= max) {
                System.out.println(room.getToys().get(i));
            }
        }
    }

    /**
     * Method to write information about GameRoom to file
     *
     * @param room current room
     */
    public synchronized void writeToFile(GameRoom room) {
        try (FileWriter writer = new FileWriter("data/gameRoom.txt", false)) {
            writer.write(String.valueOf(room));
            writer.flush();
        } catch (IOException e) {
            logger.error("Ошибка при записи файла" + e.getMessage());
        } finally {
            logger.debug("Была произведена попытка записи информации про игровую комнату в файл");
        }
    }


}


