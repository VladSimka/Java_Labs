package by.vladsimonenko.fourthlab.variantB.service;

import by.vladsimonenko.fourthlab.variantB.creators.GameRoomCreator;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;


/**
 * Class to represent a GameRoom
 */

public class GameRoom {
    Toy[] toys;
    double price;


    public GameRoom(double amountOfMoney) throws CreatorException {
        GameRoomCreator creator = new GameRoomCreator();
        int amountOfToys = (int) (amountOfMoney / 16) + 1;
        toys = new Toy[amountOfToys];

        creator.generateRoom(amountOfToys,toys);
        for (int i = 0; i < toys.length; i++) {
            price += toys[i].getPrice();
        }
        price = Math.ceil((price) * 100) / 100;
    }

    public Toy[] getToys() {
        return toys;
    }

    public void setToys(Toy[] toys) {
        this.toys = toys;
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
