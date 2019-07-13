package org.academiadecodigo.codezillas.menu;

//TODO: Implement Prompt-view menus and inputs here
//TODO (associated logic can be put in adjacent class MenuLogic if the methods become too large)
//TODO This class will need to "know" the main logic handler class in order to interact

//Symbolic "login" menu and "Request taxi" menus

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MenuPrompts {

    InputStream inputStream;
    PrintStream printStream;
    Prompt prompt;

    public MenuPrompts(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
        prompt = new Prompt(inputStream, printStream);
    }

    public int login() {
        printStream.println(MenuAssets.LINE);
        printStream.println(MenuAssets.WELCOME);

        MenuInputScanner scanner = new MenuInputScanner(MenuAssets.OPTIONSLOGIN);
        scanner.setMessage("Choose an option");
        printStream.println(" ");
        return prompt.getUserInput(scanner);

    }

    public int clientMenu() {
        printStream.println(" ");
        printStream.println(MenuAssets.LINE);
        printStream.println(MenuAssets.PROFILE);

        MenuInputScanner scanner = new MenuInputScanner(MenuAssets.OPTIONSPROFILE);
        scanner.setMessage("Choose an option");
        printStream.println(" ");
        return prompt.getUserInput(scanner);
    }

    public double amountToDeposit(){
        printStream.println(" ");
        printStream.println(MenuAssets.LINE);
        printStream.println(MenuAssets.AMOUNT);

        DoubleInputScanner scanner = new DoubleInputScanner();

        return prompt.getUserInput(scanner);

    }

    public void callDriver () {
        printStream.println(" ");
        printStream.println(MenuAssets.LINE);


    }


}
