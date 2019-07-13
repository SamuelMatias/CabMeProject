package org.academiadecodigo.codezillas.tcpServer;

import java.io.*;
import java.net.Socket;

    //TODO: Handle client thread logic
    //Not sure if the name of this class is ideal, up for discussion

public class ClientHandler implements Runnable{

    BufferedReader reader;
    PrintWriter writer;

    Socket clientSocket;

    public ClientHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        System.out.println("Client handler created");
        setupStreams();
        respond();

    }

    public void setupStreams(){
        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void respond(){
        try{
            if(clientSocket.isBound()) {
                System.out.println("Location");
                System.out.println(reader.readLine());
                System.out.println("Destination");
                System.out.println(reader.readLine());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
