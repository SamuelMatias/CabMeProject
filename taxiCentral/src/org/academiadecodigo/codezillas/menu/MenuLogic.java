package org.academiadecodigo.codezillas.menu;

import org.academiadecodigo.codezillas.ConsoleColors.Colors;
import org.academiadecodigo.codezillas.tripManager.Location;
import org.academiadecodigo.codezillas.user.Client;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class MenuLogic {

    private InputStream inputStream;
    private PrintStream printStream;
    private MenuPrompts menuPrompts;

    private Client client;

    public static int counter;

    public MenuLogic(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
        menuPrompts = new MenuPrompts(inputStream, printStream);

    }

    public void clientLogin(Socket clientSocket) {
        counter++;
        int wallet = 25;
        if (menuPrompts.login() == 1) {
            if(counter < 4){
                wallet = 100;
                printStream.println(MenuAssets.WINNER);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            client = new Client(counter,menuPrompts.clientName(), Location.ANGRA,Location.LAJES,wallet);

            int answer;
            while ((answer = menuPrompts.clientMenu()) > 0 && answer < 5){
                MenuOptions menuOptions = new MenuOptions(answer, client, printStream, inputStream, clientSocket);
                menuOptions.chooseOption();
            }

        } else {
            try {
                System.out.println(clientSocket.getInetAddress() + MenuAssets.LEFT_SERVER);
                clientSocket.close();
            } catch (Exception ex) {
                printStream.close();
            }
        }
    }
}
