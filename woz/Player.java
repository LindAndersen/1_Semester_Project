class Player {
    private String name;
    private Double xp;
    private int lvl;
    private money;
    private Inventory inventory;

    //some final int-attributes to determine intervals of xp for levels

    public Player(String name) {
        this.name = name;
        xp = 0;
        lvl = 1;
        money = 100;
        inventory = new Inventory();

    }

    void showInventory() {
        //Should call Inventory toString() method
    }

    void addToInventory(String name, int amount){
        //calls an add-method in Inventory class
    }

    void removeFromInventory(String name, int amount){
        //calls an remove-method in Inventory class
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

    }
 
}