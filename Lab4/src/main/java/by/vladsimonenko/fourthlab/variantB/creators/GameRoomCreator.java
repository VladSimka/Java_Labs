package by.vladsimonenko.fourthlab.variantB.creators;

import by.vladsimonenko.fourthlab.variantB.entity.Toy;

import java.util.Random;

public class GameRoomCreator {

    public Toy[] generateRoom(final int NUMBER_TOYS) {
        Toy[] room = new Toy[NUMBER_TOYS];

        for (int i = 0; i < NUMBER_TOYS; i++) {
            int mode = new Random().nextInt(6);
            room[i] = CreateInterior.generateToy(mode);
        }
        return room;
    }
}
