class Park extends Space {
    Trash[] trash = {new Trash("flasker"), new Trash("aviser")};

    Park(String name) {
        super(name);
    }

    public void showTrash() {
        super.showTrash(trash);
    }

    public void welcome() {
        super.welcome();
    }

    public void subtractTrash(String name, int amount) {
        super.subtractTrash(name, amount, trash);
    }
}