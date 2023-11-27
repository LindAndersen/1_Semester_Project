package com.example.kontorgui;

public class CommandRecycle extends BaseCommand implements Command {
    CommandRecycle() {
        this.description = "Genbrug fra din inventar";
    }

    //Handle recycling of trash
    @Override
    public void execute(Context context, String name) {
        /*if player has enough trash in inventory to hand in specified amount (from console):
            Remove amount from player inventory - context.getPlayer().getInventory().removeFromInventory("name / key").
            Give player the appropriate amount of XP and coins - context.getPlayer().addXP(amount) & context.getPlayer().addCoins(amount)
        */
            System.out.println("command recycle execute");

//        int nParam = parameters.length;
//        Player player = context.getPlayer();
//
//        switch(nParam) {
//            case 0:
//                System.out.println("\n Du kan konvertere dit affald på 2 måder:\n" +
//                "- [1] Brænd alt det skrald du har samlet op" +
//                "\n- [2] Sorter alt det skrald du har samlet op");
//                break;
//            case 1:
//                int inp = 0;
//                try {
//                    inp = Integer.parseInt(parameters[0]);
//                } catch (NumberFormatException e) {
//                    System.out.println("\nPrøv igen, brug tallene til at indikere din handling");
//                }
//                if (inp == 1) {
//                    int amountOfTrash = player.getTrashAmount();
//                    player.emptyInventory();
//                    int money = 7*amountOfTrash;
//                    int XP = money;
//                    player.addMoney(money);
//                    player.addXP(-XP);
//                    System.out.printf("\nTilføjede %d mønter og %d XP\n", money, -XP);
//                } else if (inp == 2) {
//                    int amountOfTrash = player.getTrashAmount();
//                    int money = 3*amountOfTrash;
//                    int XP = money;
//                    player.emptyInventory();
//                    player.addMoney(money);
//                    player.addXP(XP);
//                    System.out.printf("\nTilføjede %d mønter og %d XP\n", money, XP);
//                } else {
//                    System.out.println("\nDette er ikke en mulighed prøv igen...");
//                }
//        }

    }
    
}
