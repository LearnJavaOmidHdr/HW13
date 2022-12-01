package org.example.panels;


import org.example.Enums.TypeUnivercity;
import org.example.entity.Daneshjo;
import org.example.Enums.maghtaTahsili;

import java.sql.Date;
import java.util.Scanner;

public class Run {
    public static void basePanel(){
        System.out.println("___________________");
        System.out.println("1. login \n" +
                           "2. Register \n" +
                           "3. Quit");
    }

    public static Daneshjo register(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name : ");
        String name = scanner.nextLine();
        System.out.print("LastName :");
        String lastName = scanner.nextLine();
        System.out.print("Father Name : ");
        String father = scanner.nextLine();
        System.out.print("Mother Name : ");
        String mother = scanner.nextLine();
        System.out.print("International Code : ");
        String international = scanner.nextLine();
        System.out.print("Number Shenasnameh : ");
        String shenasnameh = scanner.nextLine();
        System.out.print("Enter birthDate : ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter Daneshjoi Number : ");
        String daneshjoi = scanner.nextLine();
        System.out.print("Enter name Univercity : ");
        String nameUnivercity = scanner.nextLine();
        System.out.print("Type Univercity : ");
        String type = scanner.nextLine();
        System.out.print("Year Enter : ");
        String yearEnter = scanner.nextLine();
        System.out.print("maghta Tahsili : ");
        String maghta = scanner.nextLine();
        Daneshjo daneshjo = new Daneshjo(1,name,lastName,father,mother,
                international,shenasnameh, Date.valueOf(birthDate),daneshjoi,nameUnivercity,
                TypeUnivercity.getFromString(type),yearEnter, maghtaTahsili.getFromString(maghta));
        return daneshjo;
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
