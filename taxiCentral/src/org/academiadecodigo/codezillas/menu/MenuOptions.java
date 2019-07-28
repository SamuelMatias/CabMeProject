package org.academiadecodigo.codezillas.menu;

import org.academiadecodigo.codezillas.ConsoleColors.Colors;
import org.academiadecodigo.codezillas.tripManager.Manager;
import org.academiadecodigo.codezillas.user.Client;
import org.academiadecodigo.codezillas.user.Driver;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class MenuOptions {
    private int clientMenuInput;
    private Client client;
    private PrintStream printStream;
    private InputStream inputStream;
    private MenuPrompts menuPrompts;
    private Socket clientSocket;

    public MenuOptions(int clientMenuInput, Client client, PrintStream printStream, InputStream inputStream, Socket clientSocket) {
        this.clientMenuInput = clientMenuInput;
        this.client = client;
        this.printStream = printStream;
        this.inputStream = inputStream;
        menuPrompts = new MenuPrompts(inputStream, printStream);
        this.clientSocket = clientSocket;
    }

    public void chooseOption() {

        switch (clientMenuInput) {
            case 1:
                requestDriver();
                break;
            case 2:
                showDrivers();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                getWallet();
                break;
            case 4:
                deposit();
                break;
            case 5:
                logout();
                break;
        }
    }

    public void requestDriver() {
        System.out.println(client.getName() + " has requested a driver");
        int passengers = menuPrompts.passengerNumber();
        showDrivers();

        try {
            client.setLocation(menuPrompts.askLocation(Constants.SELECT_LOCATION));
            printStream.println(Constants.CLEAR_SCREEN + Constants.TOP_LINE);
            printStream.println("Location: " + client.getLocation());
            client.setDestination(menuPrompts.askLocation(Constants.SELECT_DESTINATION));
            if (client.getWallet() < Manager.getCost(passengers, client)) {
                printStream.println("\n");
                printStream.println(Constants.NOT_ENOUGH_MONEY);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            Manager.assignDriver(client, printStream, passengers);
        } catch (NullPointerException e) {
            logout();
            e.getStackTrace();
        }
    }

    public void showDrivers() {
        int angra = 0;
        int lajes = 0;
        int sta_barbara = 0;
        int raminho = 0;
        int s_sebastiao = 0;
        int quatro_ribeiras = 0;
        for (Driver driver : Manager.getDrivers()) {
            switch (driver.getLocation()) {
                case ANGRA:
                    angra++;
                    break;
                case LAJES:
                    lajes++;
                    break;
                case STA_BARBARA:
                    sta_barbara++;
                    break;
                case RAMINHO:
                    raminho++;
                    break;
                case S_SEBASTIAO:
                    s_sebastiao++;
                    break;
                case QUATRO_RIBEIRAS:
                    quatro_ribeiras++;
                    break;
            }
        }
        printStream.println(Constants.TOP_LINE);
        printStream.println(Constants.DRIVERS_AVAILABLE +
                "\nANGRA:" + angra +
                "\nLAJES: " + lajes +
                "\nSTA. BARBARA: " + sta_barbara +
                "\nRAMINHO: " + raminho +
                "\nS. SEBASTIAO: " + s_sebastiao +
                "\nQUATRO RIBEIRAS: " + quatro_ribeiras);
    }

    public void getWallet() {
        printStream.println(Colors.GREEN + "\nCurrent balance: " + client.getWallet() + "€" + Colors.RESET);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deposit() {
        double amount = menuPrompts.amountToDeposit();
        if (amount > 0) {
            client.deposit(amount);
            printStream.println(Constants.DEPOSIT_SUCCESSFUL + amount + "€");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            printStream.println(Constants.INVALID_AMOUNT);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void logout() {
        try {
            printStream.println(Constants.EXIT_APP);
            System.out.println(client.getName() + Constants.LEFT_SERVER);
            inputStream.close();
            printStream.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
