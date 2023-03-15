package by.vladsimonenko.fourthlab.variantB.creators;

import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Random;

/**
 * Class - creator a GameRoom
 */
public class GameRoomCreator implements Serializable {

    static Logger logger = LogManager.getLogger();

    /**
     * Method to create a game room
     *
     * @param NUMBER_TOYS number of Toys in GameRoom
     */
    public void generateRoom(final int NUMBER_TOYS, Toy[] room) throws CreatorException {
        try {
            if (NUMBER_TOYS < 0) {
                throw new IndexOutOfBoundsException("Отрицательный размер массива");
            }

            for (int i = 0; i < NUMBER_TOYS; i++) {
                int mode = new Random().nextInt(6);
                room[i] = CreateInterior.generateToy(mode);
            }
        } catch (IndexOutOfBoundsException e) {
            logger.error("Возникла следующая ошибка: " + e.getMessage());
        } catch (CreatorException e) {
            logger.error("Возникла ошибка при создании игрушки:" + e.getMessage());
        }

    }


}
