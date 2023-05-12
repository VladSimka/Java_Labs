package by.vladsimonenko.fourthlab.variantB.entity;

import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Class to represent a GameRoom
 */

public class GameRoom implements Serializable {
    static Logger logger = LogManager.getLogger();
    List<Toy> toys;
    private transient double price;

    @Serial
    private static final long serialVersionUID = 1L;


    public GameRoom(List<Toy> toys)  {
        this.toys = new ArrayList<>(toys);
        try {
            for (int i = 0; i < toys.size(); i++) {
                price += toys.get(i).getPrice();
            }
        } catch (NullPointerException e) {
            logger.error("Игровая комната не создана");
            System.exit(0);
        }
        price = Math.ceil((price) * 100) / 100;
    }

    public List<Toy> getToys() {
        return new ArrayList<>(List.copyOf(toys));
    }

    public void setToys(List<Toy> toys) {
        this.toys = new ArrayList<>(List.copyOf(toys));
    }

    public void setPrice() {
        price = 0;
        for (int i = 0; i < toys.size(); i++) {
            price += toys.get(i).getPrice();
        }
        price = Math.ceil((price) * 100) / 100;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Игровая комната общей стоимостью ").append(this.price).append(":\n");
        for (int i = 0; i < toys.size(); i++) {
            result.append(i + 1).append(")\t").append(toys.get(i)).append("\n");
        }
        return result.toString();
    }
}
