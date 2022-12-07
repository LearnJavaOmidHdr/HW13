package org.example.Enums;

public enum TypeLoan {
    maskan,
    shahrieh,
    tahsili;
    public static TypeLoan getFromString(String name) {
        for (TypeLoan value : TypeLoan.values()) {
            if (value.toString().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
