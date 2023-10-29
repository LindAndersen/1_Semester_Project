class Player {
    private String name;
    private int xp;
    private int lvl;
    private int money;
    private Inventory inventory;

    //some final int-attributes to determine intervals of xp for levels

    public Player(String name) {
        this.name = name;
        xp = 0.0;
        lvl = 1;
        money = 100;
        inventory = new Inventory();

    }

    void showInventory() {
        System.out.println(inventory.toString());
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
        return true;
    }
 
}