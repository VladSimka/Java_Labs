package by.vladsimonenko.fourthlab.variantB.entity;

import by.vladsimonenko.fourthlab.variantB.creators.GameRoomCreator;
import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serial;
import java.io.Serializable;


/**
 * Class to represent a GameRoom
 */

public class GameRoom implements Serializable {
    static Logger logger = LogManager.getLogger();
    Toy[] toys;
    private transient double price;

    @Serial
    private static final long serialVersionUID = 1L;


    public GameRoom(double amountOfMoney) throws CreatorException {
        GameRoomCreator creator = new GameRoomCreator();
        int amountOfToys = (int) (amountOfMoney / 16) + 1;
        toys = new Toy[amountOfToys];

        creator.generateRoom(amountOfToys, toys);
        try {
            for (int i = 0; i < toys.length; i++) {
                price += toys[i].getPrice();
            }
        } catch (NullPointerException e) {
            logger.error("Игровая комната не создана");
            System.exit(0);
        }
        price = Math.ceil((price) * 100) / 100;
    }

    public Toy[] getToys() {
        return toys;
    }

    public void setToys(Toy[] toys) {
        this.toys = toys;
    }

    public void setPrice() {
        price = 0;
        for (int i = 0; i < toys.length; i++) {
            price += toys[i].getPrice();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Игровая комната общей стоимостью ").append(this.price).append(":\n");
        for (int i = 0; i < toys.length; i++) {
            result.append(i + 1).append(")\t").append(toys[i]).append("\n");
        }
        return result.toString();
    }
}
