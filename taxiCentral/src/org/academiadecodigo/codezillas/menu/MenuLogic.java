package org.academiadecodigo.codezillas.menu;

import org.academiadecodigo.codezillas.tripManager.Location;
import org.academiadecodigo.codezillas.user.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class MenuLogic {

    private InputStream inputStream;
    private PrintStream printStream;
    private MenuPrompts menuPrompts;

    private Client client;

    public MenuLogic(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
        menuPrompts = new MenuPrompts(inputStream, printStream);
    }

    public void clientLogin(Socket clientSocket) {

        if (menuPrompts.login() == 1) {
            client = new Client(1, menuPrompts.clientName(), Location.ANGRA, Location.LAJES);

            int answer;
            while ((answer = menuPrompts.clientMenu()) > 0 && answer < 5){
                MenuOptions menuOptions = new MenuOptions(answer, client, printStream, inputStream, clientSocket);
                menuOptions.chooseOption();
            }

        } else {
            try {
                System.out.println(clientSocket.getInetAddress() + MenuAssets.LEFT_SERVER);
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
