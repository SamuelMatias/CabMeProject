package org.academiadecodigo.codezillas.menu;

import org.academiadecodigo.codezillas.ConsoleColors.Colors;
import org.academiadecodigo.codezillas.tripManager.Manager;
import org.academiadecodigo.codezillas.user.Client;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class MenuOptions {
    private int clientMenuInput;
    private Client client;
    PrintStream printStream;
    InputStream inputStream;
    MenuPrompts menuPrompts;
    Socket clientSocket;

    public MenuOptions(int clientMenuInput, Client client, PrintStream printStream, InputStream inputStream, Socket clientSocket) {
        this.clientMenuInput = clientMenuInput;
        this.client = client;
        this.printStream = printStream;
        this.inputStream = inputStream;
        menuPrompts = new MenuPrompts(inputStream,printStream);
        this.clientSocket = clientSocket;
    }

    public void chooseOption() {

        switch (clientMenuInput) {
            case 1:
                requestDriver();
                break;
            case 2:
                getWallet();
                break;
            case 3:
                deposit();
                break;
            case 4:
                logout();
                break;
        }
    }

    public void requestDriver(){
        System.out.println(client.getName() + " has requested a driver");
        int passengers = menuPrompts.passengerNumber();
        client.setLocation(menuPrompts.askLocation("current location"));
        client.setDestination(menuPrompts.askLocation("destination"));
        if (client.getWallet() < Manager.getCost(passengers,client)){
            printStream.println("\n");
            printStream.println(Colors.RED + "YOU DONT HAVE ENOUGH MONEY, SELECT OPTION 3! " + Colors.RESET);
            return;
        }
        Manager.assignDriver(client,printStream, passengers);
    }

    public void getWallet(){
        printStream.println(Colors.GREEN + "You have " + client.getWallet() + " €" + Colors.GREEN);
    }

    public void deposit(){
            client.deposit(menuPrompts.amountToDeposit());
    }

    public void logout(){
        try {
            System.out.println(client.getName() + " has left the server");
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
