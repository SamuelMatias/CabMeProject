package org.academiadecodigo.codezillas.user;

public class DriverFactory {


    public static Driver getNewdriver(/*location*/) {

        int location = (int) (Math.random() * location.getValues().length);

        Driver driver = new Driver(location);


    }
}
