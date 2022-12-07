package org.example.validation;

public class ShenasnamehValidation {

    private boolean checkEmpty(String nationalCode) {
        return !nationalCode.isEmpty();
    }

    private boolean len(String nationalCode) {
        return nationalCode.length() <= 10;
    }

    private boolean isNumeric(String nationalCode) {
        try {
            Double.parseDouble(nationalCode);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkShen(String nationalCode){
        return checkEmpty(nationalCode) && len(nationalCode) && isNumeric(nationalCode);
    }

}
