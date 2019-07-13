package org.academiadecodigo.codezillas;

    //TODO: Main class should only instantiate and execute the class that handles all program logic
    //TODO: Nested psvm can be used elsewhere to execute the whole program and this one can be used for testing and deleted later

    //TODO: IMPORTANT: Try to implement Design Patterns and interface-based programming and code conventions

import org.academiadecodigo.codezillas.ConsoleColors.Colors;

public class Main {
    Colors color;
    public static void main(String[] args) {
        System.out.println("Boas");
        System.out.println(Colors.ANSI_RED + "This text is red" + Colors.ANSI_RESET);
    }
}
