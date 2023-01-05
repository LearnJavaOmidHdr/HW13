package org.example.validation;

import org.example.Main;
import org.omg.CORBA.DynAnyPackage.Invalid;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class Validation {

    //section Number
    public static boolean noNumber(String string) {
        AtomicBoolean flag = new AtomicBoolean(true);
        Arrays.stream(string.split("")).forEach(s -> {
            if (s.matches("[0-9]"))
                flag.set(false);
        });
        return flag.get();
    }
    //section cart
    public static boolean cartNumber(String cartNumber){
        CartBankValidation cart = new CartBankValidation();
        boolean validation = cart.validation(cartNumber);
        while (!validation){
            System.out.print("Wrong information \nTry again : ");
            validation = cart.validation(Main.scanner.nextLine());
        }
        return validation;
    }

    //section String
    public static String validString(String string) {
        boolean result = Validation.noNumber(string);
        String returnResult = string;
        while (!result) {
            System.out.println("Wrong Information ! ");
            System.out.print("Enter your Information : ");
            String name = Main.scanner.nextLine();
            result = Validation.noNumber(name);
            returnResult = name;
        }
        return returnResult;
    }

    //section shen
    public static String validShen(String s) {
        ShenasnamehValidation shenasnamehValidation = new ShenasnamehValidation();
        boolean shen = shenasnamehValidation.checkShen(s);
        boolean resultFoundNumber = Validation.noNumber(s);
        String resultFound = s;
        while (!shen) {
            System.out.println("Wrong Information ! ");
            System.out.println("Enter again : ");
            String found = Main.scanner.nextLine();
            shen = shenasnamehValidation.checkShen(found);
            resultFound = found;
        }
        return resultFound;
    }


    //section international
    public static String validInternational(String international) {
        InternationalValidation validateInternation = new InternationalValidation();
        boolean binternational = validateInternation.checkMeli(international);
        String resultInformational = international;
        while (!binternational) {
            System.out.println("Wrong International ! ");
            System.out.print("Enter Your Information again : ");
            String meli = Main.scanner.nextLine();
            binternational = validateInternation.checkMeli(meli);
            resultInformational = meli;
        }
        return resultInformational;
    }

    //section year
    public static String validYear(String year) {
        Pattern pattern = Pattern.compile("^\\d{4}$");
        boolean matches = year.matches(String.valueOf(pattern));
        String newYear = year;
        while (!matches) {
            System.out.print("Wrong information Enter again : ");
            newYear = Main.scanner.nextLine();
            matches = newYear.matches(String.valueOf(pattern));
        }
        return newYear;
    }

    //section valid date
    public static String validDate(String date) throws DataFormatException {
        boolean check = DateValidation.check(date);
        String newDate = date;
        while (!check) {
            System.out.print("Wrong Information !! \n" +
                    "try Again : ");
            newDate = Main.scanner.nextLine();
            check = DateValidation.check(newDate);
        }
        return newDate;
    }

    //section between
    public static String between(String number) throws Invalid {
        Pattern pattern = Pattern.compile("^[1-8]$");
        boolean matches = number.matches(String.valueOf(pattern));
        String newNum = number;
        while (!matches) {
            System.out.print("Enter Number Between '1-8' : ");
            newNum = Main.scanner.nextLine();
            matches = newNum.matches(String.valueOf(pattern));
        }
        return newNum;
    }

    public static String numberOne(String number) throws Invalid {
        Pattern pattern = Pattern.compile("^\\d+$");
        boolean matches = number.matches(String.valueOf(pattern));
        String newNum = number;
        while (!matches) {
            System.out.print("Enter Number again : ");
            newNum = Main.scanner.nextLine();
            matches = newNum.matches(String.valueOf(pattern));
        }
        return newNum;
    }
    //section univercity
    public static String univercity(int uni){
        if (uni == 1)
            return "shabaneh";
        else if (uni == 2)
            return "gheyreEntefai";
        else if (uni == 3)
            return "pardis";
        else if (uni ==4)
            return "zarfiatMazad";
        else if (uni == 5)
            return "payamnor";
        else if (uni ==6)
            return "elmikarbordi";
        else if (uni == 7)
            return "azad";
        else if (uni ==8)
            return "dolati";
        return null;
    }

}
