package org.academiadecodigo.codezillas.menu;

//TODO: This class should have static methods that handle the necessary logic for the MenuPrompts methods to work
//TODO This class can be made an inner class of MenuPrompts or even deleted if it is not necessary

import java.io.InputStream;
import java.io.PrintStream;

public class MenuLogic {

    InputStream inputStream;
    PrintStream printStream;
    private MenuPrompts menuPrompts;

    public MenuLogic(InputStream inputStream, PrintStream printStream){
        this.inputStream = inputStream;
        this.printStream = printStream;
        menuPrompts = new MenuPrompts(inputStream,printStream);

    }

    public void clientLogin() {

        if (menuPrompts.login() == 1) {
            menuPrompts.clientMenu();
        } else {
            System.exit(1);
        }

    }

    public void askForDriver(){

    }

    public double checkWallet(){
       // return client.getWallet;
        return 20.00;
    }

    public void deposit(double money){



    }


}
