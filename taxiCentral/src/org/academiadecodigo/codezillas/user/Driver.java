package org.academiadecodigo.codezillas.user;

import org.academiadecodigo.codezillas.tripManager.Location;

public class Driver {

    private int id;
    private Location location;
    private boolean availability = true;

    public Driver(Location location) {
        this.location = location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }


    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean set) {
        availability = set;
    }
}
