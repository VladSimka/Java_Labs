package by.vladsimonenko.thirteenthlab.variantA.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    static final Logger logger = LogManager.getLogger();
    private Socket clientSocket = null;
    private volatile static int count = 0;

    public ClientThread(Socket socket) {
        super("ClientThread");
        clientSocket = socket;
    }

    public void run() {
        try {
            count++;
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Измененное сообщение клиента №"+count + " : " + inputLine.toUpperCase());
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}