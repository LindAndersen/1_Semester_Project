class Player {
    private String name;
    private int xp;
    private int lvl;
    private int money;
    private Inventory inventory;

    //some final int-attributes to determine intervals of xp for levels

    public Player(String name) {
        this.name = name;
        xp = 100;
        lvl = 1;
        money = 100;
        inventory = new Inventory();

    }

    public int getMoney(){
        return money;
    }

    void showInventory() {
        System.out.println(inventory.toString());
    }

    public Inventory getInventory(){
        return inventory;
    }

    void addToInventory(String name, int amount){
        //calls an add-method in Inventory class
        System.out.printf("Du har tilføjet %d %s til din inventar%n", amount, name);
    }

    void removeFromInventory(String name, int amount){
        //calls an remove-method in Inventory class
    }

    public Inventory getInventory() {
        return inventory;
    }

    //Setters and getters


    public void addXP(int amount){
    //adds xp 
    
    }

    public void addMoney(int amount){
    //adds money
    
    }

    public void subtractMoney(int amount){
    //subtracts money. call canAfford() to check 

    }

    public boolean canAfford(int price){
    //returns true if player can afford buying an item with given price
        return true;
    }

    public int getXP(){
        return xp;
    }

    public int getMoney(){
        return money;
    }

    public int getLvl() {
        //Tjekker hvor meget xps værdi er og sætter lvl value efter det
        int lvl = 0;

        if (xp < 100) {
            lvl = 1;
        } else if (99 < xp && xp < 200) {
            lvl = 2;
        } else if (199 < xp && xp < 300) {
            lvl = 3;
        } else if (299 < xp && xp < 400) {
            lvl = 4;
        } else {
            lvl = 5; // Alt over 400 xp er level 5
        }

        return lvl;
    }

}