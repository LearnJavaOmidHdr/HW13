package org.example;


import static sun.security.krb5.internal.crypto.Nonce.value;

public enum maghtaTahsili {
    kardani,
    karshenasi,
    karshenasiArshad,
    doktora;
    public static maghtaTahsili getFromString(String name) {
        for (maghtaTahsili value : maghtaTahsili.values()) {
            if (value.toString().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
