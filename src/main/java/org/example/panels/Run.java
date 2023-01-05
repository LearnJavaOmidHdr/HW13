package org.example.panels;

import org.example.Enums.StatusDaneshjo;
import org.example.Enums.TypeUnivercity;
import org.example.Main;
import org.example.Services.AdminService;
import org.example.Services.DaneshjoService;
import org.example.Utils.CallMaghtaByNumber;
import org.example.entity.CartBank;
import org.example.entity.Daneshjo;
import org.example.Enums.MaghtaTahsili;
import org.example.exception.InvalidException;
import org.example.exception.NullpointerExeption;
import org.example.repository.DaneshjoRepository;
import org.example.validation.*;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Run {
    public static final Logger logger = LoggerFactory.getLogger(Run.class);
    //section basePanel
    public static void basePanel() {
        logger.info("user loged in base panel");
        System.out.println("-----------------------\n" +
                "1. login \n" +
                "2. Register \n" +
                "3. Quit");
        System.out.print("Enter your Number : ");
    }

    //section Register
    public static Daneshjo register() throws DataFormatException, Invalid {

//        /*
        logger.info("user loged Start Register");
        System.out.print("Enter your Name : ");
        String name = Main.scanner.nextLine();
        name = Validation.validString(name);

        System.out.print("LastName :");
        String lastName = Main.scanner.nextLine();
        lastName = Validation.validString(lastName);

        System.out.print("Father Name : ");
        String father = Main.scanner.nextLine();
        father = Validation.validString(father);

        System.out.print("Mother Name : ");
        String mother = Main.scanner.nextLine();
        mother = Validation.validString(mother);

        System.out.print("International Code : ");
        String international = Main.scanner.nextLine();
        international = Validation.validInternational(international);

        System.out.print("Number Shenasnameh : ");
        String shenasnameh = Main.scanner.nextLine();
        shenasnameh = Validation.validShen(shenasnameh);

        System.out.print("Enter birthDate \n"+
                "For Example (1400-05-06) : ");
        String birthDate = Main.scanner.nextLine();
        birthDate = Validation.validDate(birthDate);

        System.out.print("Enter Daneshjoi Number : ");
        String daneshjoi = Main.scanner.nextLine();
        daneshjoi = Validation.validInternational(daneshjoi);
        // i think validation daneshjoi number is same as national code
        System.out.print("Enter name Univercity : ");
        String nameUnivercity = Main.scanner.nextLine();
        nameUnivercity = Validation.validString(nameUnivercity);
        System.out.println("________________ \n" +
                "1. shabaneh\n" +
                "2. gheyreEntefai\n" +
                "3. pardis\n" +
                "4. zarfiatMazad\n" +
                "5. payamnor\n" +
                "6. elmikarbordi\n" +
                "7. azad\n");
        System.out.print("Type Univercity : ");
        String type = Main.scanner.nextLine();
        type = Validation.between(type);
        String typeUnivercity = CallMaghtaByNumber.typeUnivercity(Integer.parseInt(type));

        System.out.print("Year Enter\n");
        System.out.print("For example Enter '1400' : ");
        String yearEnter = Main.scanner.nextLine();
        yearEnter = Validation.validYear(yearEnter);
        
        System.out.print("Maghta Tahsili : ");

        System.out.println("________________ \n" +
                "1. kardani\n"+
                "2. karshenasiPeyvasteh\n"+
                "3. karshenasiNaPeyvasteh\n"+
                "4. karshenasiArshadPeyvasteh\n"+
                "5. karshenasiArshadNaPeyvasteh\n"+
                "6. doctoraHerfei\n"+
                "7. doctoaPeyvasteh\n"+
                "8. doktoraTakhasosiNapeyvasteh");
        String maghta = Main.scanner.nextLine();
        maghta = Validation.between(maghta);
        String tahsili = CallMaghtaByNumber.maghtaTahsili(Integer.parseInt(maghta));

        System.out.print("Enter Your CartBank Number : ");
        final String bankNumber = Main.scanner.nextLine();
        Validation.cartNumber(bankNumber);

        System.out.print("Enter cvv2 : ");
        String cvv2 = Main.scanner.nextLine();
        cvv2 = Validation.validYear(cvv2);
        
        CartBank cartNumber = new CartBank(bankNumber,cvv2,900000000000L);
        /*
        String name = "omid" , lastName = "heidary" , father = "personal" , mother = "personal",international ="4310831877" , daneshjoi = "4310831877",shenasnameh="55",birthDate ="1994-05-06" , yearEnter = "2001" ,nameUnivercity = "parsian" , TypeUnivercity.getFromString("azad") , MaghtaTahsili.getFromString("kardani");
         */
        Daneshjo daneshjo = new Daneshjo(name, lastName, father, mother,
                international, shenasnameh, Date.valueOf(birthDate), daneshjoi, nameUnivercity,
                TypeUnivercity.getFromString(typeUnivercity), yearEnter, MaghtaTahsili.getFromString(tahsili),
                international, GeneratePassword.generatePassword(),cartNumber, StatusDaneshjo.daneshjo);
        logger.info("user {} logged Login",daneshjo);
        return daneshjo;
    }

    //section Login
    public static Daneshjo login() {
        logger.info("user loged Start Login");
        System.out.print("Enter your username : ");
        final String username = Main.scanner.nextLine();
        System.out.print("Enter your password : ");
        final String password = Main.scanner.nextLine();
        Daneshjo daneshjo = new Daneshjo(username, password);
        logger.info("user {} logged Login",daneshjo);
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
