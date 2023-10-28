class Player {
    private String name;
    private Double XP;
    private int LVL = 0;
    private Inventory inventory = new Inventory();

    Player(String name) {
        this.name = name;
    }

    void showInventory() {
        System.out.println(inventory.toString());
    }

    //Setters and getters
}