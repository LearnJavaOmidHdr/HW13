package org.example.panels;

import org.example.Enums.TypeUnivercity;
import org.example.Main;
import org.example.Services.AdminService;
import org.example.Services.DaneshjoService;
import org.example.entity.Daneshjo;
import org.example.Enums.MaghtaTahsili;
import org.example.exception.InvalidException;
import org.example.exception.NullpointerExeption;
import org.example.repository.DaneshjoRepository;
import org.example.validation.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Run {
    //section basePanel
    public static void basePanel() {
        System.out.println("-----------------------\n" +
                "1. login \n" +
                "2. Register \n" +
                "3. Quit");
        System.out.print("Enter your Number : ");
    }


    //section Register
    public static Daneshjo register() throws DataFormatException {
        Scanner scanner = new Scanner(System.in);

//        /*
        System.out.print("Enter your Information Again : ");
        String name = Main.scanner.nextLine();
        Validation.validString(name);

        System.out.print("LastName :");
        final String lastName = scanner.nextLine();
        Validation.validString(lastName);

        System.out.print("Father Name : ");
        final String father = scanner.nextLine();
        Validation.validString(father);

        System.out.print("Mother Name : ");
        final String mother = scanner.nextLine();
        Validation.validString(mother);

        System.out.print("International Code : ");
        final String international = scanner.nextLine();
        Validation.validInternational(international);

        System.out.print("Number Shenasnameh : ");
        final String shenasnameh = scanner.nextLine();
        Validation.validShen(shenasnameh);

        System.out.print("Enter birthDate : ");
        final String birthDate = scanner.nextLine();
        Validation.validDate(birthDate);

        System.out.print("Enter Daneshjoi Number : ");
        final String daneshjoi = scanner.nextLine();
        Validation.validInternational(daneshjoi);
        // i think daneshjoi name is same as national code
        System.out.print("Enter name Univercity : ");
        final String nameUnivercity = scanner.nextLine();
        Validation.validString(nameUnivercity);

        System.out.print("Type Univercity : ");
        final String type = scanner.nextLine();

        System.out.print("Year Enter : ");
        final String yearEnter = scanner.nextLine();
        Validation.validYear(yearEnter);

        System.out.print("Maghta Tahsili : ");
        final String maghta = scanner.nextLine();
//         */
        /*
        String name = "omid" , lastName = "heidary" , father = "personal" , mother = "personal",international ="4310831877" , daneshjoi = "1234",shenasnameh="55",birthDate ="1994-05-06" , yearEnter = "2001" ,nameUnivercity = "parsian" , type ="azad" , maghta = "kardani";
         */
        Daneshjo daneshjo = new Daneshjo(name, lastName, father, mother,
                international, shenasnameh, Date.valueOf(birthDate), daneshjoi, nameUnivercity,
                TypeUnivercity.getFromString(type), yearEnter, MaghtaTahsili.getFromString(maghta),
                international, GeneratePassword.generatePassword());
        return daneshjo;
    }

    //section Login
    public static Daneshjo login() {
        System.out.print("Enter your username : ");
        final String username = Main.scanner.nextLine();
        System.out.print("Enter your password : ");
        final String password = Main.scanner.nextLine();
        Daneshjo daneshjo = new Daneshjo(username, password);
        return daneshjo;
    }

    //section start
    public static void start() throws NullpointerExeption, DataFormatException, SQLException, InvalidException {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1":
                Daneshjo daneshjoLogin = login();
                final long login = DaneshjoService.login(daneshjoLogin);
                boolean loginAdmin = AdminService.login(daneshjoLogin);
                if (login >= 1) {
                    UserPanel.showLoan();
                    UserPanel.selectLoan(login);
                } else if (loginAdmin) {
                    //todo add panel admin
                } else {
                    basePanel();
                    start();
                }
                break;
            case "2":
                Daneshjo daneshjoRegister = register();
                DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
                DaneshjoService daneshjoService = new DaneshjoService(daneshjoRepository);
                try {
                    daneshjoService.create(daneshjoRegister);
                } catch (Exception e) {
                    System.out.println("Wrong information");
                    basePanel();
                    start();
                }
                System.out.println("User Created Successfully ");
                basePanel();
                start();
                break;
            case "3":
                break;
            default:
                basePanel();
                start();
                break;
        }
    }
}
