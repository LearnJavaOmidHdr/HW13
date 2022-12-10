package org.example.Enums;

public enum StatusDaneshjo {
    daneshjo,
    fareghTahsil;
    public static Status getFromString(String name) {
        for (Status value : Status.values()) {
            if (value.toString().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
