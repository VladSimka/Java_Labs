package by.vladsimonenko.fourthlab.variantB._main;

import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationMain {
    static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        GameRoom room = null;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(args[0]));
            room = (GameRoom) input.readObject();
            room.setPrice();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e.getMessage());
        }

        System.out.println(room);
    }

}
