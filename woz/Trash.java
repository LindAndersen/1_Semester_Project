import java.util.Random;

class Trash {
    private String name;
    private double modifier = 1;
    private int amount;

    Trash(String name) {
        this.name = name;
        amount = setTrash();
    }

    Trash(String name, int i) {
        this.name = name;
        this.modifier = i;
        amount = setTrash();
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void subtractTrash(int amount) throws InsufficientTrashException {
    if (this.amount < amount) { 
        throw new InsufficientTrashException("Du kan ikke samle så meget skrald op af denne type");
    }
    this.amount -= amount;
    }

    public int setTrash() {
        Random rand = new Random();
        int randInt = rand.nextInt(10);

        return (int) ((double) randInt * modifier);
    }
}