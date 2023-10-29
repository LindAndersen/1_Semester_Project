import java.util.ArrayList;

public class Upgrades {
    private String name;
    private int xp;
    private int price;
    private double modifier;

    public Upgrades(String name, int xp, int price, double modifier){
        this.name = name;
        this.xp = xp;
        this.price = price;
        this.modifier = modifier;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getXP(){
        return xp;
    }

    public double getModifier(){
        return modifier;
    }
    


}