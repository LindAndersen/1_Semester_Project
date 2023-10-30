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
        //Default modifier is 1, the thought is to say amount * modifier to change the actual amount of trash
        //Indirectly through the modifier
        this.modifier = i;
        amount = setTrash();
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    //Instead of printing not enough trash, we throw custom made exception "InsufficientTrashException"
    //This exception is caught in Space
    public void subtractTrash(int amount) throws InsufficientTrashException {
    if (this.amount < amount) { 
        throw new InsufficientTrashException("Du kan ikke samle så meget skrald op af denne type");
    }
    this.amount -= amount;
    }

    public int setTrash() {
        Random rand = new Random();
        int randInt = rand.nextInt(10);

        //First we convert randInt to a double to multiply with double modifier, then back to int
        return (int) ((double) randInt * modifier);
    }
}