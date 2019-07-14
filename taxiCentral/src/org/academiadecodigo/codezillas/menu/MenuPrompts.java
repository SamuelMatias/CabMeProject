package org.academiadecodigo.codezillas.menu;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.codezillas.ConsoleColors.Colors;
import org.academiadecodigo.codezillas.tripManager.Location;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public class MenuPrompts {

    private InputStream inputStream;
    private PrintStream printStream;
    private Prompt prompt;
    private String name;

    public MenuPrompts(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
        prompt = new Prompt(inputStream, printStream);
    }

    public int login() {
        try {
            clearConsole();
            printStream.println(MenuAssets.LINE);
            printStream.println(MenuAssets.WELCOME);
            MenuInputScanner scanner = new MenuInputScanner(MenuAssets.OPTIONS_LOGIN);
            scanner.setMessage(MenuAssets.CHOOSE_OPTION);
            return prompt.getUserInput(scanner);
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return 0;
    }

    public String clientName() {
        try {
            clearConsole();
            printStream.println(MenuAssets.LINE);
            printStream.println(MenuAssets.NAME_SELECTION);
            printStream.println(MenuAssets.INSERT_USERNAME);
            StringInputScanner scanner = new StringInputScanner();
            scanner.setMessage(MenuAssets.NAME);
            name = prompt.getUserInput(scanner);
            return name;
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return "";
    }

    public int passengerNumber() {
        try {
            printStream.println(MenuAssets.LINE);
            IntegerRangeInputScanner inputScanner = new IntegerRangeInputScanner(MenuAssets.MIN_PASSENGERS, MenuAssets.MAX_PASSENGERS);
            inputScanner.setMessage(MenuAssets.PASSENGERS);
            return prompt.getUserInput(inputScanner);
        } catch (NullPointerException e) {
            printStream.close();
        }
        return 0;
    }

    public int clientMenu() {
        try {
            clearConsole();
            printStream.println(MenuAssets.LINE);
            printStream.println(MenuAssets.PROFILE + " " + Colors.GREEN + name.toUpperCase() + Colors.RESET);
            MenuInputScanner scanner = new MenuInputScanner(MenuAssets.OPTIONS_PROFILE);
            scanner.setMessage(MenuAssets.CHOOSE_OPTION);
            return prompt.getUserInput(scanner);
        } catch (NullPointerException e) {
            printStream.close();
        }
        return 0;
    }

    public double amountToDeposit() {
        try {
            clearConsole();
            printStream.println(MenuAssets.LINE);
            printStream.println(MenuAssets.AMOUNT);

            DoubleInputScanner scanner = new DoubleInputScanner();

            return prompt.getUserInput(scanner);
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return 0;
    }

    public Location askLocation(String option) {
        try {
            printStream.println(MenuAssets.LINE);
            MenuInputScanner scanner = new MenuInputScanner(MenuAssets.LOCATIONS);
            scanner.setMessage(option);
            return Location.values()[prompt.getUserInput(scanner) - 1];
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return null;
    }

    public void clearConsole() {
        printStream.println("\033[H\033[2J");
    }
}
