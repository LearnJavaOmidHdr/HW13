package org.example.panels;

import org.example.Enums.TypeUnivercity;
import org.example.Main;
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
        System.out.print("First Name : ");
        final String name = scanner.nextLine();

        System.out.print("LastName :");
        final String lastName = scanner.nextLine();

        System.out.print("Father Name : ");
        final String father = scanner.nextLine();

        System.out.print("Mother Name : ");
        final String mother = scanner.nextLine();

        System.out.print("International Code : ");
        final String international = scanner.nextLine();

        System.out.print("Number Shenasnameh : ");
        final String shenasnameh = scanner.nextLine();

        System.out.print("Enter birthDate : ");
        final String birthDate = scanner.nextLine();

        System.out.print("Enter Daneshjoi Number : ");
        final String daneshjoi = scanner.nextLine();

        System.out.print("Enter name Univercity : ");
        final String nameUnivercity = scanner.nextLine();

        System.out.print("Type Univercity : ");
        final String type = scanner.nextLine();

        System.out.print("Year Enter : ");
        final String yearEnter = scanner.nextLine();

        System.out.print("Maghta Tahsili : ");
        final String maghta = scanner.nextLine();
//         */

        /*
        String name = "omid" , lastName = "heidary" , father = "personal" , mother = "personal",international ="4310831877" , daneshjoi = "1234",shenasnameh="55",birthDate ="1994-05-06" , yearEnter = "2001" ,nameUnivercity = "parsian" , type ="azad" , maghta = "kardani";
         */

        // start Validating
        InternationalValidation validateInternation = new InternationalValidation();
        ShenasnamehValidation shenasnamehValidation = new ShenasnamehValidation();
        final boolean check = DateValidation.check(birthDate);


        //section todo
        // todo add these
        DaneshjoiValication daneshjoiValication = new DaneshjoiValication();
        // validation name ...

        if (validateInternation.checkMeli(international) &&
                shenasnamehValidation.checkShen(shenasnameh) &&
                daneshjoiValication.check(daneshjoi) &&
                DateValidation.check(birthDate)) {
            Daneshjo daneshjo = new Daneshjo(name, lastName, father, mother,
                    international, shenasnameh, Date.valueOf(birthDate), daneshjoi, nameUnivercity,
                    TypeUnivercity.getFromString(type), yearEnter, MaghtaTahsili.getFromString(maghta),
                    international, GeneratePassword.generatePassword());
            return daneshjo;
        }
        System.out.println("Wrong Information");
        return null;
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
                UserPanel.showLoan();
                if (login >= 1)
                    UserPanel.selectLoan(login);
                basePanel();
                start();
                break;
            case "2":
                Daneshjo daneshjoRegister = register();
                DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
                DaneshjoService daneshjoService = new DaneshjoService(daneshjoRepository);
                try {
                    daneshjoService.create(daneshjoRegister);
                }catch (Exception e){
                    System.out.println("Wrong information");
                    basePanel();
                    start();
                }
                System.out.println("User Created Successfully ");
                basePanel();
                start();
                break;
            case "3":
                System.out.println("Enter number between 1-2");
                basePanel();
                start();
                break;
            default:
                basePanel();
                start();
                break;
        }
    }
}
