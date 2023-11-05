public class Upgrades {
    private String name;
    private int xp;
    private int price;
    private double modifier;
    private String hint;
    private int relatedUpgradeIndex;


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
