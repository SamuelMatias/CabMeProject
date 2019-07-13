package org.academiadecodigo.codezillas.tcpServer;

import org.academiadecodigo.codezillas.tripManager.Manager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TODO: Implement server logic with support for multithreading
//TODO Create Thread Handler class separately from this one (I would name it ClientHandler but we can pick a name together)

public class Server {

    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    private ExecutorService executor;

    private Manager manager = new Manager(5);

    public Server(int port){
        this.port = port;
        executor = Executors.newCachedThreadPool();
    }

    public void initialize(){
        try {
            System.out.println(ServerMessages.SERVERCREATED);
            serverSocket = new ServerSocket(port);
            System.out.println(ServerMessages.WAITINGFORCLIENT);
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
            System.out.println(ServerMessages.CLIENTFOUND);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
