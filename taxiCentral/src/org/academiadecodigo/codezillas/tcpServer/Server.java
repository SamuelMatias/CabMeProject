package org.academiadecodigo.codezillas.tcpServer;

import org.academiadecodigo.codezillas.tripManager.Manager;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ExecutorService executor;

    public Server(int port){
        this.port = port;
        executor = Executors.newCachedThreadPool();
        new Manager(15);
    }

    public void initialize(){
        try {
            System.out.println(ServerMessages.SERVER_CREATED);
            serverSocket = new ServerSocket(port);
            System.out.println(ServerMessages.WAITING_FOR_CLIENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen(){
        try{
            clientSocket = serverSocket.accept();
            executor.submit(new ClientHandler(clientSocket){
                @Override
                public void run() {
                    super.run();
                }
            });
            System.out.println(ServerMessages.CLIENT_FOUND);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
