import java.io.Serializable;

public class Upgrades implements Serializable {
    private String name;
    private int xp;
    private int price;
    private double modifier;
<<<<<<< HEAD
    //private static final long serialVersionUID = 6529685098267757692L;
=======
    private String hint;
    private int relatedUpgradeIndex;
>>>>>>> main


    public Upgrades(String name, int price, int xp, double modifier, String hint, int relatedUpgradeIndex){
        this.name = name;
        this.price = price;
        this.xp = xp;
        this.modifier = modifier;
        this.hint = hint;
        this.relatedUpgradeIndex = relatedUpgradeIndex;
    }

    public String getHint() {
        return hint;
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

    public int getRelatedUpgradeIndex() {
        return relatedUpgradeIndex;
    }

    @Override
    public String toString(){
        return name + ", xp: " + xp + ", pris: " + price;
    }

}
