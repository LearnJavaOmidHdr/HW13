package org.example.Enums;


public enum MaghtaTahsili {
    kardani,
    karshenasiNapeyvasteh,
    karshenasiPeyvasteh,
    karshenasiArshad,
    doktoraTakhasosi;
    public static MaghtaTahsili getFromString(String name) {
        for (MaghtaTahsili value : MaghtaTahsili.values()) {
            if (value.toString().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
