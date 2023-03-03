package by.vladsimonenko.fourthlab.variantB.service;

import by.vladsimonenko.fourthlab.variantB.creators.GameRoomCreator;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;

import java.util.Arrays;

public class GameRoom {
    Toy[] toys;

    public GameRoom(double amountOfMoney) {
        GameRoomCreator creator = new GameRoomCreator();
        int amountOfToys = (int) amountOfMoney / 16 + 1;
        toys = creator.generateRoom(amountOfToys);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Игровая комната:\n");
        for (int i = 0; i < toys.length; i++) {
            result.append(i + 1).append(")\t").append(toys[i]).append("\n");
        }
        return result.toString();
    }
}
