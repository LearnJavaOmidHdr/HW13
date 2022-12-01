package org.example.validation;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class InternationalValidation {

    private boolean checkEmpty(String nationalCode) {
        return nationalCode.isEmpty();
    }

    private boolean len(String nationalCode) {
        return nationalCode.length() == 10;
    }

    private boolean isNumeric(String nationalCode) {
        try {
            Integer.parseInt(nationalCode);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean validMeli(String nationalCode) {
        final String[] split = nationalCode.split("");
        int count = 10;
        AtomicInteger max = new AtomicInteger();
        Arrays.stream(split).forEach(s -> {
            final int i = Integer.parseInt(s);
            int meli = i * count;
            max.addAndGet(meli);
        });
        return max.get() * 11 == 0;
    }

    public boolean checkMeli(String nationalCode) {
        if (checkEmpty(nationalCode) && len(nationalCode) && isNumeric(nationalCode)
                && validMeli(nationalCode))
            return true;
        return false;
    }

}
