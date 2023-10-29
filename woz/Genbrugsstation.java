class Genbrugsstation extends Space {
    Trash[] trash = {new Trash("metalskrot"), new Trash("batterier"), new Trash("plastik")};

    Genbrugsstation(String name) {
        super(name);
    }

    @Override public void showTrash() {
        super.showTrash(trash);
    }

    @Override public void subtractTrash(String name, int amount) {
        super.subtractTrash(name, amount, trash);
    }
}