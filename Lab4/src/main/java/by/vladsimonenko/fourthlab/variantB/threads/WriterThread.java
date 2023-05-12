package by.vladsimonenko.fourthlab.variantB.threads;

import by.vladsimonenko.fourthlab.variantB.action.GameRoomAction;
import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;

public class WriterThread implements Runnable {
    GameRoom room;
    GameRoomAction action;

    public WriterThread(GameRoom room, GameRoomAction action) {
        this.room = room;
        this.action = action;
    }

    @Override
    public void run() {
        action.writeToFile(room);
    }
}
