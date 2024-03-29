package org.academiadecodigo.codezillas.user;

import org.academiadecodigo.codezillas.tripManager.Location;

public class Client {

    private int id;
    private double wallet;
    private String name;
    private Location location;
    private Location destination;

    public Client(int id, String name, Location location, Location destination, int wallet) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.destination = destination;
        this.wallet = wallet;
    }

    public void deposit(double cash) {
        wallet += cash;
    }

    public double getWallet() {
        return wallet;
    }

    public void cabFare(double cash) {
        wallet -= cash;
    }

    public Location getLocation() {
        return location;
    }

    public Location getDestination() {
        return destination;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public String getName() {
        return name;
    }
}

