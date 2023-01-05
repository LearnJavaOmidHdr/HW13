package org.example.validation;


public class CartBankValidation {
    public static boolean validation(String cartNumber){
        InternationalValidation international = new InternationalValidation();
        return international.checkEmpty(cartNumber) && international.lenCart(cartNumber) && international.isNumeric(cartNumber);
    }

}
