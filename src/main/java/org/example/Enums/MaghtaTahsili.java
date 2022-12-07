package org.example.Enums;


public enum MaghtaTahsili {
    // one
    kardani,
    karshenasiPeyvasteh,
    karshenasiNaPeyvasteh,

    // two
    karshenasiArshadPeyvasteh,
    karshenasiArshadNaPeyvasteh,
    doctoraHerfei,
    doctoaPeyvasteh,

    // three
    doktoraTakhasosiNapeyvasteh;
    public static MaghtaTahsili getFromString(String name) {
        for (MaghtaTahsili value : MaghtaTahsili.values()) {
            if (value.toString().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
