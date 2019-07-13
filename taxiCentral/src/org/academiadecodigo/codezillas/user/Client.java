package org.academiadecodigo.codezillas.user;

    //TODO: Implement user properties and methods
    //FixMe: I suggest using the word "Location" instead of origin to improve readability

import org.academiadecodigo.codezillas.tripManager.Location;
import org.academiadecodigo.codezillas.tripManager.Manager;

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

    public void callDriver(Manager manager){
        if (wallet <10){
            //TODO REFUSE TRIP LOGIC
        }
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
