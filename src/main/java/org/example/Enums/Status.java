package org.example.Enums;

public enum Status {
    pending,
    request,
    paid;
    public static Status getFromString(String name) {
        for (Status value : Status.values()) {
            if (value.toString().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
