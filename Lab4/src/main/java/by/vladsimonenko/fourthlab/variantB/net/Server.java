package by.vladsimonenko.fourthlab.variantB.net;

import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.threads.DBSelectAllCallable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<Toy>> future = executor.submit(new DBSelectAllCallable());

        executor.shutdown();

        try {
            List<Toy> toys = future.get();
            GameRoom room = new GameRoom(toys);
            ServerSocket serverSocket = new ServerSocket(8080);
            int count = 0;
            while (true) {
                System.out.println("client + " + (++count));
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket, room);
                serverThread.start();
            }


        } catch (ExecutionException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
