package org.example.validation;

import java.util.Arrays;
import java.util.Random;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

public class GeneratePassword {
    public static String generatePassword() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String number = "1234567890";
        String speshial = "!@#$%^&*";
        String ALPHA = alphabet.toUpperCase();
        String password = "";
        char c[] = new char[8];
        Random rand = new Random();
        int index = 0;
        for (int i = 0; i < 7; i++) {
            c[i] = alphabet.charAt(rand.nextInt(alphabet.length()));
            c[++i] = ALPHA.charAt(rand.nextInt(ALPHA.length()));
        }
        for (int i = 6; i < 7; i++) {
            c[rand.nextInt(3)] = speshial.charAt(rand.nextInt(speshial.length()));
            c[rand.nextInt(8-4)+4] = number.charAt(rand.nextInt(number.length()));
        }
        int i = 0;
        while (i < c.length) {
            password += c[i];
            char check = password.charAt(0);
            String ff = Character.toString(check);
            if (isNumeric(ff)) {
                password += c[i];
            }
            i++;
        }
        return password;
    }
}