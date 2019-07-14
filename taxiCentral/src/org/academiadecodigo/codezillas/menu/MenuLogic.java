package org.academiadecodigo.codezillas.menu;

//TODO: This class should have static methods that handle the necessary logic for the MenuPrompts methods to work
//TODO This class can be made an inner class of MenuPrompts or even deleted if it is not necessary

import org.academiadecodigo.codezillas.tripManager.Location;
import org.academiadecodigo.codezillas.user.Client;

import java.io.InputStream;
import java.io.PrintStream;

public class MenuLogic {

    private InputStream inputStream;
    private PrintStream printStream;
    private MenuPrompts menuPrompts;

    private Client client;

    public MenuLogic(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
        menuPrompts = new MenuPrompts(inputStream, printStream);

    }

    public void clientLogin() {

        if (menuPrompts.login() == 1) {
            client = new Client(1, "Miguel", Location.ANGRA,Location.LAJES);
            menuPrompts.clientName();

            int answer;
            while ((answer = menuPrompts.clientMenu()) != 4){
                MenuOptions menuOptions = new MenuOptions(answer, client, printStream, inputStream);
                menuOptions.chooseOption();
            }

        } else {
            System.exit(1);
        }

    }


}
