package by.vladsimonenko.fourthlab.variantB.threads;

import by.vladsimonenko.fourthlab.variantB.action.GameRoomAction;
import by.vladsimonenko.fourthlab.variantB.action.Serialization;
import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;

public class SerializationThread implements Runnable {
    Serialization serialization;
    GameRoom room;

    public SerializationThread(Serialization serialization, GameRoom room) {
        this.serialization = serialization;
        this.room = room;
    }

    @Override
    public void run() {
        serialization.serialize(room, "data/room.dat");
    }
}
