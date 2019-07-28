package org.academiadecodigo.codezillas.menu;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
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
            printStream.println(Constants.CLEAR_SCREEN);
            printStream.println(Constants.TOP_LINE);
            printStream.println(Constants.WELCOME);
            MenuInputScanner scanner = new MenuInputScanner(Constants.OPTIONS_LOGIN);
            scanner.setMessage(Constants.CHOOSE_OPTION);
            return prompt.getUserInput(scanner);
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return 0;
    }

    public String clientName() {
        try {
            printStream.println(Constants.CLEAR_SCREEN);
            printStream.println(Constants.TOP_LINE);
            printStream.println(Constants.NAME_SELECTION);
            printStream.println(Constants.INSERT_USERNAME);
            StringInputScanner scanner = new StringInputScanner();
            scanner.setMessage(Constants.NAME);
            scanner.setError(Constants.INVALID_NAME);
            name = prompt.getUserInput(scanner);
            return name;
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return "";
    }

    public int passengerNumber() {
        try {
            printStream.println(Constants.CLEAR_SCREEN + Constants.TOP_LINE);
            IntegerRangeInputScanner inputScanner = new IntegerRangeInputScanner(Constants.MIN_PASSENGERS, Constants.MAX_PASSENGERS);
            inputScanner.setMessage(Constants.PASSENGERS);
            return prompt.getUserInput(inputScanner);
        } catch (NullPointerException e) {
            printStream.close();
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return 0;
    }

    public int clientMenu() {
        try {
            printStream.println(Constants.CLEAR_SCREEN);
            printStream.println(Constants.TOP_LINE);
            printStream.println(Constants.PROFILE + " " + Colors.GREEN + name.toUpperCase() + Colors.RESET);
            MenuInputScanner scanner = new MenuInputScanner(Constants.MAIN_MENU_OPTIONS);
            scanner.setMessage(Constants.CHOOSE_OPTION);
            return prompt.getUserInput(scanner);
        } catch (NullPointerException e) {
            printStream.close();
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return 0;
    }

    public double amountToDeposit() {
        try {
            printStream.println(Constants.CLEAR_SCREEN);
            printStream.println(Constants.TOP_LINE);
            printStream.println(Constants.ADD_FUNDS);
            printStream.println(Constants.INSERT_AMOUNT);
            IntegerInputScanner scanner = new IntegerInputScanner();
            scanner.setMessage(Constants.AMOUNT);
            scanner.setError(Constants.INVALID_AMOUNT);
            return prompt.getUserInput(scanner);
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return 0;
    }

    public Location askLocation(String option) {
        try {
            printStream.println(Constants.TOP_LINE);
            MenuInputScanner scanner = new MenuInputScanner(Constants.LOCATIONS);
            scanner.setMessage(option);
            return Location.values()[prompt.getUserInput(scanner) - 1];
        } catch (NoSuchElementException e) {
            printStream.close();
        }
        return null;
    }
}
