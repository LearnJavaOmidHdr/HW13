package org.example.panels;

import org.example.Enums.MaghtaTahsili;
import org.example.Enums.StatusDaneshjo;
import org.example.Enums.TypeUnivercity;
import org.example.entity.CartBank;
import org.example.entity.Daneshjo;
import org.example.validation.GeneratePassword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class RunTest {

    @Test
    void register() {
        CartBank bank = new CartBank("6062561016133368","854",90000000000L);
        Daneshjo daneshjo = new Daneshjo("omid", "heidary", "slkhf", "saf", "4310831877","485", Date.valueOf("1995-05-05"),"4310831877" , "parsian",
                TypeUnivercity.getFromString("azad"), "2001", MaghtaTahsili.getFromString("kardani"),
                "4310831877", GeneratePassword.generatePassword(),bank, StatusDaneshjo.daneshjo);
//        Assertions.assertFalse();
    }

    @Test
    void login() {
    }

    @Test
    void start() {
    }
}