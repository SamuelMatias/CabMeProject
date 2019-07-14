package org.academiadecodigo.codezillas.tripManager;

    //TODO: Contains methods that calculate the cost of the trip based on travel distance and number of passengers
    //TODO Create new class or enum that will contain location related objects like "grid position"

public class CostCalculator {

    public static double calculateCost(int passengers, Location origin, Location destination){
        return (calculateDistance(origin, destination) + passengers * 2);
    }

    private static int calculateDistance(Location origin, Location destination){
        int distX = Math.abs(destination.getX() - origin.getX());
        int distY = Math.abs(destination.getY() - origin.getY());
        return (distX + distY);
    }
}
