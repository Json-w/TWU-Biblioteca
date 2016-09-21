package com.twu.biblioteca.entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public void print(String content) {
        System.out.print(content);
    }

    public void println(String content) {
        System.out.println(content);
    }

    public int getNextInt() throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
