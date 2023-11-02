import java.io.Serializable;
public class Upgrades implements Serializable {
    private String name;
    private int xp;
    private int price;
    private double modifier;


    public Upgrades(String name, int price, int xp, double modifier){
        this.name = name;
        this.price = price;
        this.xp = xp;
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

    @Override
    public String toString(){
        return name + ", xp: " + xp + ", pris: " + price;
    }

}