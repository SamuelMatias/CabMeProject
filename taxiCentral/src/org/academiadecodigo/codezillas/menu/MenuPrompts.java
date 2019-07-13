package org.academiadecodigo.codezillas.menu;

//TODO: Implement Prompt-view menus and inputs here
//TODO (associated logic can be put in adjacent class MenuLogic if the methods become too large)
//TODO This class will need to "know" the main logic handler class in order to interact

//Symbolic "login" menu and "Request taxi" menus

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;


public class MenuPrompts {

    Prompt prompt = new Prompt(System.in, System.out);


    public int login() {

        System.out.println("WELCOME TO CENTRAL CRAZY TAXI");
        String[] options = {"Login", "Exit"};
        MenuInputScanner scanner = new MenuInputScanner(options);


        scanner.setMessage("Choose an option");
        int answerIndex = prompt.getUserInput(scanner);

        return answerIndex;

    }

    public int clientMenu(){
        System.out.println("WELCOME TO YOUR PROFILE");
        String[] options = {"Ask a Driver", "Check Wallet", "Put some money", "Logout"};

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Choose an option");

        int answerIndex = prompt.getUserInput(scanner);

        return answerIndex;

    }


}
