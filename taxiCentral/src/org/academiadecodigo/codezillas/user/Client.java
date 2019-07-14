package org.academiadecodigo.codezillas.user;

import org.academiadecodigo.codezillas.tripManager.Location;

public class Client {

    private int id;
    private double wallet = 100.00;
    private String name;
    private Location location;
    private Location destination;

    public Client(int id, String name, Location location, Location destination ){
        this.id = id;
        this.name = name;
        this.location = location;
        this.destination = destination;
    }

    public void deposit(double cash){
        wallet += cash;

    }

    public double getWallet(){
        return wallet;
    }

    public void cabFare(double cash){
        wallet -= cash;
    }

    public Location getLocation(){
        return location;
    }

    public Location getDestination(){
        return destination;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}
