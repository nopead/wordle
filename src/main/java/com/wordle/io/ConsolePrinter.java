package com.wordle.io;

import com.wordle.io.Printable;

public class ConsolePrinter implements Printable  {

    public void printMessage(String message) {
        System.out.println(message);
    }

}
