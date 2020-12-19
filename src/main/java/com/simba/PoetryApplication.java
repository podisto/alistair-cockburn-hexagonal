package com.simba;

import com.simba.adapters.console.PoetryConsoleAdapter;
import com.simba.adapters.infrastructure.PoetryLibraryFileAdapter;
import com.simba.domain.IObtainPoems;
import com.simba.domain.IRequestVerses;
import com.simba.domain.PoetryReader;

public class PoetryApplication {

    public static void main(String[] args) {
        // instantiate the right side adapter ("i want to go outside the hexagon")
        IObtainPoems fileAdapter = new PoetryLibraryFileAdapter();
        // instantiate the hexagon
        IRequestVerses requestVerses = new PoetryReader(fileAdapter);
        // instantiate the left side adapter (i want ask/to go inside the hexagon)
        PoetryConsoleAdapter consoleAdapter = new PoetryConsoleAdapter();
        String poetry = consoleAdapter.enterPoetry();
        requestVerses.write(poetry);

        requestVerses.giveMeSomePoetry();
    }
}
