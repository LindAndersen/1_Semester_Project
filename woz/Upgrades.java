public class Upgrades {
    private String name;
    private int xp;
    private int price;
    private double modifier;
<<<<<<< Updated upstream
    private String hint;

=======
 
>>>>>>> Stashed changes

    public Upgrades(String name, int price, int xp, double modifier, String hint){
        this.name = name;
        this.price = price;
        this.xp = xp;
        this.modifier = modifier;
        this.hint = hint;
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

    @Override
    public String toString(){
        return name + ", xp: " + xp + ", pris: " + price;
    }

}