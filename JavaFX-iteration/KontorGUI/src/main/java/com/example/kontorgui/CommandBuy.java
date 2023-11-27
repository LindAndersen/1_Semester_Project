package com.example.kontorgui;

import java.util.HashMap;

public class CommandBuy extends BaseCommand implements Command {

    CommandBuy() {
        this.description = "Køb en opgradering";
    } 

    private void printHint(Butik butik, int upgradeName) {
        for (int name : butik.getUpgrades().keySet()) {
            if (name == upgradeName) {
                System.out.println(butik.getUpgrades().get(name).getHint());
                return;
            }
        }
        System.out.println("Didnt find upgrade");
    }

     @Override
    public void execute(Context context, String name) {

//        if(!guardEq(parameters, 0)){
//            System.out.println("Du bliver nødt til at sige hvad du vil ha");
//        }else{


            if(context.getCurrent() instanceof Butik){//tjek inden downcasting
                Butik butik = (Butik)context.getCurrent();//downcaster Space til Butik, så vi har adgang til metoder i Butik

                HashMap<Integer, Upgrades> upgrades = butik.getUpgrades();//henter upgrades og gemmer i en variabel

                Player player = context.getPlayer();
                System.out.println("command buy execute");

//                try{
//                    int upgradeIndex = Integer.parseInt(parameters[0]);
//
//                    if(upgrades.containsKey(upgradeIndex)){//tjekker om den angivne upgrade eksisterer
//
//                        Upgrades selectedUpgrade = upgrades.get(upgradeIndex);
//                        int price = selectedUpgrade.getPrice();
//                        int xp = selectedUpgrade.getXP();
//
//
//
//                        if(player.canAfford(price)){//hvis spiller har råd til upgraden...
//                            player.subtractMoney(price);//træk penge
//                            player.addXP(xp);//tilføj xp
//
//                            //opdater world med ny modifier - ikke implementeret
//
//                            // Determine the second upgrade to remove based on the selected upgrade.
//                            int secondUpgradeToRemove = selectedUpgrade.getRelatedUpgradeIndex();
//
//
//                            printHint(butik, upgradeIndex);
//
//                            System.out.println("Du har købt upgraderingen " + selectedUpgrade.getName());
//
//                            butik.removeUpgrade(upgradeIndex);//fjern upgrade fra shop
//
//                            if (upgrades.containsKey(secondUpgradeToRemove)) {
//                                Upgrades relatedUpgrade = upgrades.get(secondUpgradeToRemove);
//                                butik.removeUpgrade(secondUpgradeToRemove); // Remove the related second upgrade.
//                                System.out.println("Du har også fjernet " + relatedUpgrade.getName() + " fra butikken.");
//
//                                // Additional logic here...
//
//                            } else {
//                                System.out.println("Error: Related upgrade not found.");
//                            }
//
//                            System.out.println("\nDu har så mange mønter nu: " + player.getMoney());
//                            System.out.println("Du har så meget xp nu: " + player.getXP() + "\n");
//
//                        }else{
//                            System.out.println("Du har ikke råd til denne vare");
//                        }
//                    }else{
//                        System.out.println("Denne vare er ikke på lager");
//                    }
//                }catch(NumberFormatException e){
//                    System.out.println("Skriv tallet på den opgradering, du ønsker at købe");
//                }

//            }
        }
    }
}
