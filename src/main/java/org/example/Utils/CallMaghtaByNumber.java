package org.example.Utils;

public class CallMaghtaByNumber {
    public static String maghtaTahsili(int ID){
        if (ID == 1) return"kardani";
        else if (ID == 2) return "karshenasiPeyvasteh";
        else if (ID == 3) return "karshenasiNaPeyvasteh";
        else if (ID == 4) return "karshenasiArshadPeyvasteh";
        else if (ID == 5) return "karshenasiArshadNaPeyvasteh";
        else if (ID == 6) return "doctoraHerfei";
        else if (ID == 7) return "doctoaPeyvasteh";
        else if (ID == 8) return "doktoraTakhasosiNapeyvasteh";
        else return null;
    }
    public static String typeUnivercity(int vorodi) {
        if (vorodi == 1 ) return "shabaneh";
        else if (vorodi == 2 ) return "gheyreEntefai";
        else if (vorodi == 3 ) return "pardis";
        else if (vorodi == 4 ) return "zarfiatMazad";
        else if (vorodi == 5 ) return "payamnor";
        else if (vorodi == 6 ) return "elmikarbordi";
        else if (vorodi == 7 ) return "azad";
        else return null;
    }
}
