class Player {
    private String name;
    private Double XP;
    private int LVL = 0;
    private Inventory inventory = new Inventory();

    Player(String name) {
        this.name = name;
    }

    void showInventory() {
        //Should call Inventory toString() method
    }

    //Setters and getters
}