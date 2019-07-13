package org.academiadecodigo.codezillas.user;

import org.academiadecodigo.codezillas.tripManager.Location;

public class DriverFactory {


    public static Driver getNewdriver(/*location*/) {

        int random = (int) (Math.random() * Location.values().length);

        Location location = Location.QUATRO_RIBEIRAS;

        Driver driver = new Driver(location);

        return driver;
    }
}
