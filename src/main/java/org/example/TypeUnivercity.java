package org.example;

public enum TypeUnivercity {
    azad,
    dolati,
    payamnor,
    elmikarbordi;

    public static TypeUnivercity getFromString(String name) {
        for (TypeUnivercity value : TypeUnivercity.values()) {
            if (value.toString().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }

}