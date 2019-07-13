package org.academiadecodigo.codezillas.user;

    //TODO: Taxi implementation will be hardcoded at first but it can still be thought of as a "fake user" of the app

public class Driver {

    private int id;
    private String location;
    private String destination;
    private boolean isAvailable = true;

    public Driver(int id){
        this.id = id;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }

    public void setDestination(String destination){
        isAvailable = false;
        this.destination = destination;
    }

    public String getDestination(){
        return destination;
    }

    public boolean getAvailability(){
        return isAvailable;
    }


}
