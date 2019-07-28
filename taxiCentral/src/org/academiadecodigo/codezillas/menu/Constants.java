package org.academiadecodigo.codezillas.menu;

import org.academiadecodigo.codezillas.ConsoleColors.Colors;

public class Constants {
    public static final int MIN_PASSENGERS = 1;
    public static final int MAX_PASSENGERS =4;

    public static final String CLEAR_SCREEN = "\033[H\033[2J";
    public static final String TOP_LINE = "------------------------------------";
    public static final String WELCOME = Colors.YELLOW + "########  WELCOME TO CABME  ########" + Colors.RESET;
    public static final String NAME_SELECTION = Colors.CYAN + "CHOOSE USERNAME" + Colors.RESET + "\n";
    public static final String INSERT_USERNAME = Colors.CYAN + "Insert your username\n" + Colors.RESET;
    public static final String NAME = "Name: ";
    public static final String INVALID_NAME = Colors.RED + "NAME CANNOT BE EMPTY" + Colors.RESET;

    public static final String PROFILE = Colors.CYAN + "WELCOME TO YOUR PROFILE" + Colors.RESET;
    public static final String CHOOSE_OPTION = Colors.CYAN + "Choose an option" + Colors.RESET;
    public static final String[] MAIN_MENU_OPTIONS = {"Request Driver", "Driver locations", "View balance", "Add funds", "Logout"};
    public static final String[] OPTIONS_LOGIN = {"Login", "Exit"};
    public static final String EXIT_APP = Colors.YELLOW + "\n######  Thank you for using CABME  ######" + Colors.RESET;

    public static final String ADD_FUNDS = Colors.CYAN + "ADD FUNDS\n" + Colors.RESET;
    public static final String INSERT_AMOUNT = Colors.CYAN + "Insert the amount you want to add\n" + Colors.RESET;
    public static final String AMOUNT = "Amount: ";
    public static final String DEPOSIT_SUCCESSFUL = Colors.GREEN + "Successfully deposited " + Colors.RESET;
    public static final String INVALID_AMOUNT = Colors.RED + "\nPLEASE INSERT A VALID AMOUNT" + Colors.RESET;

    public static final String PASSENGERS = Colors.CYAN + "Number of passengers: " + Colors.RESET;
    public static final String DRIVERS_AVAILABLE = Colors.CYAN + "Drivers Available: " + Colors.RESET;
    public static final String[] LOCATIONS = {"ANGRA", "LAJES", "STA_BARBARA", "RAMINHO", "S_SEBASTIAO", "QUATRO_RIBEIRAS"};
    public static final String SELECT_LOCATION = Colors.CYAN + "Select current location:" + Colors.RESET;
    public static final String SELECT_DESTINATION = Colors.CYAN + "Select destination:" + Colors.RESET;
    public static final String NOT_ENOUGH_MONEY = Colors.RED + "CURRENT BALANCE INSUFFICIENT TO COMPLETE THIS TRIP" + Colors.RESET;

    public static final String DRIVER_ON_THE_WAY = Colors.GREEN + "############  DRIVER ON THE WAY  ############" + Colors.RESET;
    public static final String DRIVER_ARRIVED = Colors.GREEN + "#############  DRIVER ARRIVED   #############" + Colors.RESET;
    public static final String TRIP_OVER = Colors.YELLOW + "###### YOU HAVE REACHED YOUR DESTINATION ######" + Colors.RESET + "\n";
    public static final String NO_DRIVERS = Colors.RED + "#### NO DRIVERS AVAILABLE AT YOUR LOCATION ####" + Colors.RESET;
    public static final String ARROW = "   ---------------------->   ";

    public static final String LEFT_SERVER = " has left the server.";
    public static final String SERVER_CREATED = "Server created";
    public static final String WAITING_FOR_CLIENT = "Waiting for a client connection";
    public static final String CLIENT_FOUND = "Client accepted";

    public static final String TAXI= Colors.YELLOW + "" +
            "                   [\\\n" +
            "              .----' `-----.\n" +
            "             //^^^^;;^^^^^^`\\\n" +
            "     _______//_____||_____()_\\________\n" +
            "    /       :      : ___    CabMe      `\\\n" +
            "   |>   ____;      ;  |/\\><|   ____   _<)\n" +
            "  {____/    \\_________________/    \\____}\n" +
            "       \\ '' /                 \\ '' /\n" +
            "        '--'                   '--'\r"  + Colors.RESET;
}

