package org.academiadecodigo.codezillas.tripManager;

import org.academiadecodigo.codezillas.ConsoleColors.Colors;
import org.academiadecodigo.codezillas.menu.Constants;
import org.academiadecodigo.codezillas.user.Client;
import org.academiadecodigo.codezillas.user.Driver;
import org.academiadecodigo.codezillas.user.DriverFactory;

import java.io.PrintStream;

public class Manager {

    private static Driver[] drivers;

    public Manager(int taxiAmount) {
        drivers = addDriver(taxiAmount);
    }

    public static Driver[] getDrivers() {
        return drivers;
    }

    public static synchronized void assignDriver(Client client, PrintStream printStream, int passengers) {
        try {
            boolean driverAssigned = false;
            int currentDriver = 0;
            for (int i = 0; i < drivers.length; i++) {

                if (client.getLocation().equals(drivers[i].getLocation())) {
                    if (drivers[i].isAvailable()) {
                        drivers[i].setAvailability(false);
                        driverAssigned = true;
                        currentDriver = i;
                        break;
                    }
                }
            }

            if (!driverAssigned) {
                printStream.println(Constants.NO_DRIVERS);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                printStream.println(Constants.CLEAR_SCREEN + Constants.TOP_LINE);
                printStream.println(Constants.DRIVER_ON_THE_WAY);
                try {
                    Thread.sleep(1000);
                    printStream.println(Constants.DRIVER_ARRIVED);
                    Thread.sleep(1000);
                    printStream.println("\n");
                    printStream.println(" " + client.getLocation() + Constants.ARROW + client.getDestination());
                    printStream.println(Constants.TAXI);
                    Thread.sleep(3000);
                    printStream.println(Constants.TRIP_OVER);
                    printStream.println(Colors.PURPLE + "Your trip was: " + getCost(passengers, client) + " €" + Colors.RESET);
                    client.cabFare(getCost(passengers, client));
                    drivers[currentDriver].setLocation(client.getDestination());
                    drivers[currentDriver].setAvailability(true);
                    Thread.sleep(4500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    public static double getCost(int passengers, Client client) {
        return CostCalculator.calculateCost(passengers, client.getLocation(), client.getDestination());
    }

    public Driver[] addDriver(int taxiAmount) {
        drivers = new Driver[taxiAmount];
        for (int i = 0; i < drivers.length; i++) {
            drivers[i] = DriverFactory.getNewDriver();
        }
        return drivers;
    }
}
