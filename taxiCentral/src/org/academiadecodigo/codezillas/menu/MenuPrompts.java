package org.academiadecodigo.codezillas.menu;

//TODO: Implement Prompt-view menus and inputs here
//TODO (associated logic can be put in adjacent class MenuLogic if the methods become too large)
//TODO This class will need to "know" the main logic handler class in order to interact

//Symbolic "login" menu and "Request taxi" menus

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.io.InputStream;
import java.io.PrintStream;

public class MenuPrompts {

    InputStream inputStream;
    PrintStream printStream;
    Prompt prompt;

    public MenuPrompts(InputStream inputStream, PrintStream printStream){
        this.inputStream = inputStream;
        this.printStream = printStream;
        prompt = new Prompt(inputStream, printStream);
    }

    public int login() {

        System.out.println("WELCOME TO CENTRAL CRAZY TAXI");
        String[] options = {"Login", "Exit"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Choose an option");

        return prompt.getUserInput(scanner);

    }

    public int clientMenu(){
        System.out.println("WELCOME TO YOUR PROFILE");
        String[] options = {"Ask a Driver", "Check Wallet", "Put some money", "Logout"};

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Choose an option");

        return prompt.getUserInput(scanner);
    }


}
