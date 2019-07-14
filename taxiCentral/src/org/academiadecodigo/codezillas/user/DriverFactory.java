package org.academiadecodigo.codezillas.user;

import org.academiadecodigo.codezillas.tripManager.Location;

public class DriverFactory {

    public static Driver getNewDriver() {
        return new Driver(driverLocation());
    }

    private static Location driverLocation() {
        int probability = ((int) (Math.random() * 100));

        if (probability < 15) {
            return Location.ANGRA;
        }

        if (probability < 30) {
            return Location.LAJES;
        }

        if (probability < 45) {
            return Location.RAMINHO;
        }

        if (probability < 60) {
            return Location.QUATRO_RIBEIRAS;
        }

        if (probability < 75) {
            return Location.S_SEBASTIAO;
        }

        if (probability < 100) {
            return Location.STA_BARBARA;
        }
        return null;
    }
}

