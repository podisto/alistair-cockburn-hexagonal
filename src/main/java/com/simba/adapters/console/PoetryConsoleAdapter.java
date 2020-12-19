package com.simba.adapters.console;

import java.util.Scanner;

public class PoetryConsoleAdapter {

    public String enterPoetry() {
        System.out.println("Enter a poetry...");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
