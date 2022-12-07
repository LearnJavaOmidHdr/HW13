package org.example.Enums;

public enum TypeUnivercity {
    shabaneh,
    gheyreEntefai,
    pardis,
    zarfiatMazad,
    payamnor,
    elmikarbordi,
    azad,
    dolati;
    public static TypeUnivercity getFromString(String name) {
        for (TypeUnivercity value : TypeUnivercity.values()) {
            if (value.toString().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }

}