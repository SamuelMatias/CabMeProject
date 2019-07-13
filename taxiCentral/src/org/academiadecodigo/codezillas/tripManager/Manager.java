package org.academiadecodigo.codezillas.tripManager;

    //TODO: Implement trip (a.k.a. "Corrida") management logic
    //Could contain a client list as well as a taxi list if there
    // is no need to create separate ClientList class

import org.academiadecodigo.codezillas.user.Client;
import org.academiadecodigo.codezillas.user.Driver;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Manager {
    private Client client;
    private Driver[] driver;
    private double cost = 8;
    private PrintWriter out;
    private BufferedReader in;

    public void Manager(Client client, Driver[] driver) {
        this.client = client;
        this.driver = driver;
    }

    public Client getClient() {
        return client;
    }

    public double getCost() {
        return cost;
    }

//

}
