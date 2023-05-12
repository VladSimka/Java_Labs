package by.vladsimonenko.fourthlab.variantB.action;

import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
    static Logger logger = LogManager.getLogger();

    public synchronized void serialize(GameRoom room, String fileName) {

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
            output.writeObject(room);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }


}
