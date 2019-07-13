package org.academiadecodigo.codezillas.user;

    //TODO: Taxi implementation will be hardcoded at first but it can still be thought of as a "fake user" of the app

import org.academiadecodigo.codezillas.tripManager.Location;

public class Driver {

    private int id;
    private Location location;
    private Location destination;
    private boolean availability = true;

    public Driver(Location location){
        this.location = location;
        //this.id = id;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public Location getLocation(){
        return location;
    }

    public void setDestination(Location destination){
        availability = false;
        this.destination = destination;
    }

    public Location getDestination(){
        return destination;
    }

    public boolean isAvailable(){
        return availability;
    }

    public void setAvailability(){
        availability = false;
    }


}
