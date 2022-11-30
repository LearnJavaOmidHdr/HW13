package org.example.panels;


import org.example.Daneshjo;

import java.util.Scanner;

public class Run {
    public static void basePanel(){
        System.out.println("___________________");
        System.out.println("1. login \n" +
                           "2. Register \n" +
                           "3. Quit");
    }

    public static void register(){
        Daneshjo daneshjo = new Daneshjo();

    }

    public static void start(){
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                break;
        }
    }
}
