package by.vladsimonenko.fourthlab.variantB._main;

import by.vladsimonenko.fourthlab.variantB.controller.MenuController;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;
import by.vladsimonenko.fourthlab.variantB.threads.DBSelectAllCallable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Class with main method for variant B
 */
public class GameRoomMain {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<Toy>> future = executor.submit(new DBSelectAllCallable());

        executor.shutdown();

        try{
            List<Toy> toys = future.get();


            GameRoom room = new GameRoom(toys);
            MenuController menu = new MenuController();
            menu.mainMenu(room);
        } catch (ExecutionException | InterruptedException e) {
            logger.error(e.getMessage());
        }


    }
}
