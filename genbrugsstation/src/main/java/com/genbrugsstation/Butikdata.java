package com.genbrugsstation;

public class Butikdata {
    // 1 --> Cykelsti v motorvej
    // 2 --> Solceller v Billboards
    // 3 --> Filter i parksøem vs farve i parksøen
    // 4 --> Busstoppested vs Parkeringshus
    // 5 --> Isolerende vinduer v Oliefyr
    // 6 --> Legeplads v Fodboldstadion

    private static String stringupgrade1 = "";
    private static String stringupgrade2 = "";
    private static String stringupgrade3 = "";
    private static String stringupgrade4 = "";
    private static String stringupgrade5 = "";
    private static String stringupgrade6 = "";

    public static String[] getUpgrades() {
        return new String[]{getStringupgrade1(), getStringupgrade2(), getStringupgrade3(), getStringupgrade4(), getStringupgrade5(), getStringupgrade6()};
    }

    public static String getStringupgrade1() {
        return stringupgrade1;
    }

    public static void setStringupgrade1(String s1) {
        stringupgrade1 = s1;
    }

    public static String getStringupgrade2() {
        return stringupgrade2;
    }

    public static void setStringupgrade2(String s2) {
        stringupgrade2 = s2;
    }

    public static String getStringupgrade3() {
        return stringupgrade3;
    }

    public static void setStringupgrade3(String s3) {
        stringupgrade3 = s3;
    }

    public static String getStringupgrade4() {
        return stringupgrade4;
    }

    public static void setStringupgrade4(String s4) {
        stringupgrade4 = s4;
    }

    public static String getStringupgrade5() {
        return stringupgrade5;
    }

    public static void setStringupgrade5(String s5) {
        stringupgrade5 = s5;
    }

    public static String getStringupgrade6() {
        return stringupgrade6;
    }

    public static void setStringupgrade6(String s6) {
        stringupgrade6 = s6;
    }

}