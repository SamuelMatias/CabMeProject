package org.academiadecodigo.codezillas.tcpServer;

import org.academiadecodigo.codezillas.menu.MenuLogic;
import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    PrintStream printStream;
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
            printStream = new PrintStream(clientSocket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void respond(){
        try{
            if(clientSocket.isBound()) {
                MenuLogic menu = new MenuLogic(clientSocket.getInputStream(),printStream);
                menu.clientLogin(clientSocket);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
