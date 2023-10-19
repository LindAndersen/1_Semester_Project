import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class New {
    public static void main(String[] args) {
       Trash trash1 = new Trash("plastikposer", 3);
       Trash trash2 = new Trash("dåser", 2);
       Trash trash3 = new Trash("glasflasker", 2);
       Trash trash4 = new Trash("batterier", 3);
       Trash trash5 = new Trash("stykker pap", 1);
       int total = trash1.randomNum + trash2.randomNum + trash3.randomNum + trash4.randomNum + trash5.randomNum;
        
       Scanner scanner = new Scanner(System.in);
       System.out.println("Der er skrald på jorden.");
       System.out.println(trash1.randomNum + " " + trash1.name );
       System.out.println(trash2.randomNum + " " + trash2.name );
       System.out.println(trash3.randomNum + " " + trash3.name );
       System.out.println(trash4.randomNum + " " + trash4.name );
       System.out.println(trash5.randomNum + " " + trash5.name );
       System.out.print("Hvor meget vil du samle op i din rygsæk? Der er " + total + " stykker skrald i alt.");
       int numTrash = scanner.nextInt();

        
       Inventory inventory = new Inventory();
        
       if (numTrash >= 1 && numTrash <= total) {
            for (int i = 0; i < total; i++) {
                switch (i) {
                    case 0:
                        inventory.addToInventory(trash1);
                        trash1.pickUp();
                        break;
                    case 1:
                        inventory.addToInventory(trash2);
                        trash2.pickUp();
                        break;
                    case 2:
                        inventory.addToInventory(trash3);
                        trash3.pickUp();
                        break;
                    case 3:
                        inventory.addToInventory(trash4);
                        trash4.pickUp();
                        break;
                    case 4:
                        inventory.addToInventory(trash5);
                        trash5.pickUp();
                        break;
                }
            }

            System.out.println("\nDu har nu dette i din rygsæk:");
            inventory.showInventory();
          }   else {
            System.out.println("Du skal skrive et tal mellem 1 og " + total);
        }
    }
}

class Trash {
    String name;
    int value;
    int randomNum;
    int numTrash;

    public Trash(String name, int value) {             //Trash constructor med 3 attributes.
        this.name = name;       
        this.value = value;                            //value bliver prisen som det er værd i genbrugsstation
        this.randomNum = generateRandomNumber();
    }

    private int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(5) + 2;                    //2 fordi at jeg har skrevet variablerne i flertal
    }   

    public void pickUp() {
        System.out.println("Samler " + numTrash + " stykker " + name + "op");
    }
}


class Inventory {
    ArrayList<Trash> collectedTrash;

    public Inventory() {
        collectedTrash = new ArrayList<>();            // Lige nu smider den bare alle objekter ind i en Array liste
    }

    public void addToInventory(Trash trash) {
        collectedTrash.add(trash);
    }

    public void showInventory() {
            for (Trash trash : collectedTrash) {
                System.out.println(trash.randomNum + " " + trash.name );
    }
            
    }
}