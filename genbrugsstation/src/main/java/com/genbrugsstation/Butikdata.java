package com.genbrugsstation;

public class Butikdata {
    // 1 --> Cykelsti v motorvej
    // 2 --> Solceller v Billboards
    // 3 --> Filter i parksøem vs farve i parksøen
    // 4 --> Busstoppested vs Parkeringshus
    // 5 --> Isolerende vinduer v Oliefyr
    // 6 --> Legeplads v Fodboldstadion


    private static String[] upgrades = {
            " ", " ", " ",
            " ", " ", " "
    };

    public static String[] getUpgrades() {
        return upgrades;
    }

    public static String getStringUpgrade(int index) {
        return upgrades[index];
    }

    public static void setStringUpgrade(int index, String upgrade) {
        upgrades[index] = upgrade;
    }

}