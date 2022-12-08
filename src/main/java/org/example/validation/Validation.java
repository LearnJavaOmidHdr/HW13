package org.example.validation;

import org.example.Main;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class Validation {
    public static boolean noNumber(String string) {
        AtomicBoolean flag = new AtomicBoolean(true);
        Arrays.stream(string.split("")).forEach(s -> {
            if (s.matches("[0-9]"))
                flag.set(false);
        });
        return flag.get();
    }

    public static String validString(String string) {
        boolean result = Validation.noNumber(string);
        String returnResult = string;
        while (!result) {
            System.out.println("Wrong Information ! ");
            System.out.print("First Name : ");
            String name = Main.scanner.nextLine();
            result = Validation.noNumber(name);
            returnResult = name;
        }
        return returnResult;
    }

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


    public static String validInternational(String international) {
        InternationalValidation validateInternation = new InternationalValidation();
        boolean binternational = validateInternation.checkMeli(international);
        String resultInformational = international;
        while (!binternational) {
            System.out.println("Wrong International ! ");
            System.out.print("Enter Your International Code : ");
            String meli = Main.scanner.nextLine();
            binternational = validateInternation.checkMeli(meli);
            resultInformational = meli;
        }
        return resultInformational;
    }

    public static String validYear(String year) {
        Pattern pattern = Pattern.compile("^\\d{4}$");
        boolean matches = year.matches(String.valueOf(pattern));
        String newYear = year;
        while (!matches) {
            System.out.print("Wrong Year for example Enter '1400' : ");
            newYear = Main.scanner.nextLine();
            matches = newYear.matches(String.valueOf(pattern));
        }
        return newYear;
    }

    public static String validDate(String date) throws DataFormatException {
        boolean check = DateValidation.check(date);
        String newDate = date;
        while (!check) {
            System.out.print("Wrong Date !! \n" +
                    "Enter Correct Date Again \n" +
                    "For Example (1400-05-06) : ");
            newDate = Main.scanner.nextLine();
            check = DateValidation.check(newDate);
        }
        return newDate;
    }
}