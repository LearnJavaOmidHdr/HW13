package org.example.validation;

import org.example.Main;

import java.util.regex.Pattern;

public class CartBankValidation {
    public static boolean validation(String cartNumber){
        InternationalValidation international = new InternationalValidation();
        return international.checkEmpty(cartNumber) && international.lenCart(cartNumber) && international.isNumeric(cartNumber);
    }

}
