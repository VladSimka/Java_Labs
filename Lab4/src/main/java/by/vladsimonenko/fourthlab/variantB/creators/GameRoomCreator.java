package by.vladsimonenko.fourthlab.variantB.creators;

import by.vladsimonenko.fourthlab.variantB.entity.Toy;

import java.util.Random;

/**
 * Class - creator a GameRoom
 */
public class GameRoomCreator {

    /**
     * Method to create a game room
     *
     * @param NUMBER_TOYS number of Toys in GameRoom
     * @return room
     */
    public Toy[] generateRoom(final int NUMBER_TOYS) {
        Toy[] room = new Toy[NUMBER_TOYS];

        for (int i = 0; i < NUMBER_TOYS; i++) {
            int mode = new Random().nextInt(6);
            room[i] = CreateInterior.generateToy(mode);
        }
        return room;
    }
}
