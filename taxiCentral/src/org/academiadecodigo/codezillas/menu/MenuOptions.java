package org.academiadecodigo.codezillas.menu;

import org.academiadecodigo.codezillas.tripManager.Location;
import org.academiadecodigo.codezillas.tripManager.Manager;
import org.academiadecodigo.codezillas.user.Client;

import java.io.InputStream;
import java.io.PrintStream;

public class MenuOptions {
    private int clientMenuInput;
    private Client client;
    PrintStream printStream;
    InputStream inputStream;
    MenuPrompts menuPrompts;

    public MenuOptions(int clientMenuInput, Client client, PrintStream printStream, InputStream inputStream) {
        this.clientMenuInput = clientMenuInput;
        this.client = client;
        this.printStream = printStream;
        this.inputStream = inputStream;
        menuPrompts = new MenuPrompts(inputStream,printStream);
    }

    public void chooseOption() {

        switch (clientMenuInput) {
            case 1:
                Manager.showDrivers();
                askDriver();
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

    public void askDriver(){
        client.setLocation(menuPrompts.askLocation("current location"));
        client.setDestination(menuPrompts.askLocation("destination"));
        Manager.assignDriver(client,printStream, menuPrompts.passengersNumber());
    }

    public void getWallet(){
        printStream.println("You have " + client.getWallet() + " €");
    }

    public void deposit(){
            client.deposit(menuPrompts.amountToDeposit());
    }

    public void logout(){
        // TODO client socket close
    }

}
