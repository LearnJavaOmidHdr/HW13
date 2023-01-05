package org.example.validation;

import java.util.zip.DataFormatException;

public class DateValidation {
    public static boolean check(String date) throws DataFormatException {
        try {
            final boolean matches = date.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
            return matches;
        }catch (Exception e){
            throw new DataFormatException("Wrong Date format");
        }

    }
}
