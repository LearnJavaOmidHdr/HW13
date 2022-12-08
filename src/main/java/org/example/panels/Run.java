package org.example.panels;

import org.example.Enums.TypeUnivercity;
import org.example.Main;
import org.example.Services.AdminService;
import org.example.Services.DaneshjoService;
import org.example.entity.CartBank;
import org.example.entity.Daneshjo;
import org.example.Enums.MaghtaTahsili;
import org.example.exception.InvalidException;
import org.example.exception.NullpointerExeption;
import org.example.repository.DaneshjoRepository;
import org.example.validation.*;
import org.omg.CORBA.DynAnyPackage.Invalid;
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
    public static Daneshjo register() throws DataFormatException, Invalid {

        System.out.print("Enter your Information Again : ");
        String name = Main.scanner.nextLine();
        Validation.validString(name);

        System.out.print("LastName :");
        final String lastName = Main.scanner.nextLine();
        Validation.validString(lastName);

        System.out.print("Father Name : ");
        final String father = Main.scanner.nextLine();
        Validation.validString(father);

        System.out.print("Mother Name : ");
        final String mother = Main.scanner.nextLine();
        Validation.validString(mother);

        System.out.print("International Code : ");
        final String international = Main.scanner.nextLine();
        Validation.validInternational(international);

        System.out.print("Number Shenasnameh : ");
        final String shenasnameh = Main.scanner.nextLine();
        Validation.validShen(shenasnameh);

        System.out.print("Enter birthDate \n"+
                "For Example (1400-05-06) : ");
        final String birthDate = Main.scanner.nextLine();
        Validation.validDate(birthDate);

        System.out.print("Enter Daneshjoi Number : ");
        final String daneshjoi = Main.scanner.nextLine();
        Validation.validInternational(daneshjoi);
        // i think daneshjoi name is same as national code
        System.out.print("Enter name Univercity : ");
        final String nameUnivercity = Main.scanner.nextLine();
        Validation.validString(nameUnivercity);


        System.out.println("________________ \n" +
                "1. shabaneh\n" +
                "2. gheyreEntefai\n" +
                "3. pardis\n" +
                "4. zarfiatMazad\n" +
                "5. payamnor\n" +
                "6. elmikarbordi\n" +
                "7. azad\n" +
                "8. dolati");
        System.out.print("Type Univercity : ");
        final String type = Main.scanner.nextLine();
        final String typeUnivercity = Validation.between(type);

        System.out.print("Year Enter : ");
        final String yearEnter = Main.scanner.nextLine();
        Validation.validYear(yearEnter);

        System.out.print("Maghta Tahsili : ");
        final String maghta = Main.scanner.nextLine();

        System.out.println("________________ \n" +
                "1. kardani\n"+
                "2. karshenasiPeyvasteh\n"+
                "3. karshenasiNaPeyvasteh\n"+
                "4. karshenasiArshadPeyvasteh\n"+
                "5. karshenasiArshadNaPeyvasteh\n"+
                "6. doctoraHerfei\n"+
                "7. doctoaPeyvasteh\n"+
                "8. doktoraTakhasosiNapeyvasteh");
        final String tahsili = Validation.between(maghta);

        System.out.print("Enter Your CartBank Number : ");
        final String bankNumber = Main.scanner.nextLine();
        Validation.cartNumber(bankNumber);

        System.out.print("Enter cvv2 : ");
        final String cvv2 = Main.scanner.nextLine();
        Validation.validYear(cvv2);
        
        CartBank cartNumber = new CartBank(bankNumber,cvv2,900000000000L);

        /*
        String name = "omid" , lastName = "heidary" , father = "personal" , mother = "personal",international ="4310831877" , daneshjoi = "1234",shenasnameh="55",birthDate ="1994-05-06" , yearEnter = "2001" ,nameUnivercity = "parsian" , type ="azad" , maghta = "kardani";
         */
        Daneshjo daneshjo = new Daneshjo(name, lastName, father, mother,
                international, shenasnameh, Date.valueOf(birthDate), daneshjoi, nameUnivercity,
                TypeUnivercity.getFromString(typeUnivercity), yearEnter, MaghtaTahsili.getFromString(tahsili),
                international, GeneratePassword.generatePassword(),cartNumber);
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
    public static void start() throws NullpointerExeption, DataFormatException, SQLException, InvalidException, Invalid {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1":
                Daneshjo daneshjoLogin = login();
                final long login = DaneshjoService.login(daneshjoLogin);
                boolean loginAdmin = AdminService.login(daneshjoLogin);
                if (login >= 1) {
                    UserPanel.userPanel();
                    UserPanel.selectUserPanel(login);
                } else if (loginAdmin) {
                    AdminPanel.panel();
                    AdminPanel.select();
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
