package org.example.validation;

public class DaneshjoiValication {

    private boolean checkEmpty(String daneshjoi) {
        return !daneshjoi.isEmpty();
    }

    private boolean len(String daneshjoi) {
        return daneshjoi.length() <= 14;
    }

    private boolean isNumeric(String daneshjoi) {
        try {
            Double.parseDouble(daneshjoi);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean check(String daneshjoi){
        return checkEmpty(daneshjoi) && len(daneshjoi) && isNumeric(daneshjoi);
    }
}
