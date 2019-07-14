package org.academiadecodigo.codezillas.tripManager;

//TODO: Implement trip (a.k.a. "Corrida") management logic
//Could contain a client list as well as a taxi list if there
// is no need to create separate ClientList class

import org.academiadecodigo.codezillas.user.Client;
import org.academiadecodigo.codezillas.user.Driver;
import org.academiadecodigo.codezillas.user.DriverFactory;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Manager {
    private static Driver[] drivers;

    public Manager(int taxiAmount) {
        drivers = addDriver(taxiAmount);

    }

    public static synchronized void assignDriver(Client client, PrintStream printStream, int passengers) {
        try {
            boolean driverAssigned = false;
            int currentDriver = 0;
            for (int i = 0; i < drivers.length; i++) {

                if (client.getLocation().getX() == drivers[i].getLocation().getX()
                        && client.getLocation().getY() == drivers[i].getLocation().getY()) {
                    if (drivers[i].isAvailable()) {
                        drivers[i].setAvailability(false);
                        driverAssigned = true;
                        currentDriver = i;
                        break;
                    }
                }
            }

            if (!driverAssigned) {
                printStream.println("############# NO DRIVER AVAILABLE #############");

            } else {
                printStream.println("############# DRIVER ON ITS WAY #############");
                try {
                    Thread.sleep(1000);
                    printStream.println("############# DRIVER ARRIVED #############");
                    Thread.sleep(3000);
                    printStream.println("############# YOU HAVE REACHED YOUR DESTINATION #############");
                    drivers[currentDriver].setLocation(client.getDestination());
                    drivers[currentDriver].setAvailability(true);
                    client.cabFare(getCost(passengers, client));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (NullPointerException ex) {
            System.out.println(client.getName() + " has left the server.");
        }
    }

    public static void showDrivers() {
        for (Driver driver : drivers) {
            System.out.println(driver.isAvailable() + " " + driver.getLocation());
        }
        System.out.println("\n");
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
