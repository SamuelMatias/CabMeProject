package org.academiadecodigo.codezillas.menu;

import org.academiadecodigo.codezillas.ConsoleColors.Colors;

public class MenuAssets {
    public static final int MIN_PASSENGERS = 1;
    public static final int MAX_PASSENGERS =4;

    public static final String WELCOME = Colors.CYAN + "WELCOME TO CABME" + Colors.RESET;
    public static final String PROFILE = Colors.CYAN + "WELCOME TO YOUR PROFILE" + Colors.RESET;
    public static final String AMOUNT = Colors.CYAN + "HOW MUCH YOU WANT?" + Colors.CYAN;
    public static final String CHOOSE_OPTION = Colors.CYAN + "Choose an option" + Colors.RESET;
    public static final String INSERT_USERNAME = Colors.CYAN + "Insert your username\n" + Colors.RESET;

    public static final String NAME = "Name: ";
    public static final String PASSENGERS = Colors.CYAN + "Passengers number: " + Colors.RESET;
    public static final String SELECT_LOCATION = Colors.CYAN + "Choose your current location" + Colors.RESET;
    public static final String SELECT_DESTINATION = Colors.CYAN + "Choose your destination" + Colors.RESET;
    public static final String NOT_ENOUGH_MONEY = Colors.RED + "YOU DONT HAVE ENOUGH MONEY, SELECT OPTION 3!" + Colors.RESET;
    public static final String NAME_SELECTION = Colors.CYAN + "CHOOSE USERNAME" + Colors.RESET + "\n";

    public static final String LEFT_SERVER = " has left the server.";
    public static final String WINNER = Colors.PURPLE + "CONGRATULATION YOU FUCKING NERD YOU WON 100€ STARTING BALANCE!" + Colors.RESET;
    public static final String NO_DRIVERS = Colors.RED + "############# NO DRIVER AVAILABLE #############" + Colors.RESET;
    public static final String DRIVER_COMING = Colors.GREEN + "############# DRIVER ON ITS WAY #############" + Colors.RESET;
    public static final String DRIVER_ARRIVED = Colors.GREEN + "############# DRIVER ARRIVED #############" + Colors.RESET;
    public static final String TRIP_OVER = Colors.YELLOW + "############# YOU HAVE REACHED YOUR DESTINATION #############" + Colors.RESET + "\n";
    public static final String DRIVER_MESSAGE = "Thank you, come again!";
    public static final String ARROW = "   ---------------------->   ";

    public static final String LINE = "-----------------------------";
    public static final String[] OPTIONS_PROFILE = {"Request Driver", "Check Wallet", "Put some money", "Logout"};
    public static final String[] OPTIONS_LOGIN = {"Login", "Exit"};
    public static final String[] LOCATIONS = {"RAMINHO", "QUATRO_RIBEIRAS", "LAJES", "STA_BARBARA", "ANGRA", "S_SEBASTIAO"};

    public static final String TAXI="" +
            "                   [\\\n" +
            "              .----' `-----.\n" +
            "             //^^^^;;^^^^^^`\\\n" +
            "     _______//_____||_____()_\\________\n" +
            "    /       :      : ___    CABME      `\\\n" +
            "   |>   ____;      ;  |/\\><|   ____   _<)\n" +
            "  {____/    \\_________________/    \\____}\n" +
            "       \\ '' /                 \\ '' /\n" +
            "        '--'                   '--'\r";
}

