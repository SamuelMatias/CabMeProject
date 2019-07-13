package org.academiadecodigo.codezillas.tripManager;

//TODO: Implement trip (a.k.a. "Corrida") management logic
//Could contain a client list as well as a taxi list if there
// is no need to create separate ClientList class

import org.academiadecodigo.codezillas.user.Client;
import org.academiadecodigo.codezillas.user.Driver;
import org.academiadecodigo.codezillas.user.DriverFactory;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Manager {
    private Client client;
    private Driver[] drivers;
    private double cost = 8;
    private PrintWriter out;
    private BufferedReader in;

    public Manager(Client client, int taxiAmount) {
        this.client = client;
        this.drivers = new Driver[taxiAmount];
    }

    public Client getClient() {
        return client;
    }

    public double getCost(int passengers) {
        return CostCalculator.calculateCost(passengers, client.getLocation(), client.getDestination());
    }

    public void addDriver() {
        for (int i = 0; i < drivers.length; i++) {
            drivers[i] = DriverFactory.getNewdriver();
        }
    }

    public void assignDriver() {

        boolean driverAssigned = false;

        for (int i = 0; i < drivers.length; i++) {

            if (client.getLocation() == drivers[i].getLocation()) {

                drivers[i].setDestination(client.getDestination());
                drivers[i].setAvailability();
                driverAssigned = true;
                break;
            }
        }
        if (!driverAssigned) {
            System.out.println("No driver available");

        } else {
            System.out.println("Driver on its way");
        }
    }
}
