package org.example.validation;

import org.example.Main;

import java.util.regex.Pattern;

public class CartBankValidation {
    public static boolean validation(String cartNumber){
        InternationalValidation international = new InternationalValidation();
        return international.checkEmpty(cartNumber) && international.lenCart(cartNumber) && international.isNumeric(cartNumber);
    }
    public static boolean cvv2(String cvv){
        Pattern pattern = Pattern.compile("^[3-4]$");
        boolean matches = cvv.matches(String.valueOf(pattern));
        String newNum = cvv;
        while (!matches) {
            System.out.print("Enter Number Between '1-8' : ");
            newNum = Main.scanner.nextLine();
            matches = newNum.matches(String.valueOf(pattern));
        }
        return newNum(Integer.parseInt(newNum));
    }

}
