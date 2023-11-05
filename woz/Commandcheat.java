public class Commandcheat extends BaseCommand implements Command{

    Commandcheat(){
        this.description = "Motherlode";
    }


    @Override
    public void execute(Context context, String command, String[] parameters) {
        Player player = context.getPlayer();
        int money = 1000;
        int XP = 1000;
        player.addMoney(money);
        player.addXP(XP);
        System.out.printf("\nTilføjede %d mønter og %d XP\n", money, XP);



    }
}
