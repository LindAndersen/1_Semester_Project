
import java.util.Map;
import java.util.HashMap;

class Player{
	private int level;
	private int points;
	private int money;
	private int trash;
	HashMap<String, Integer> inventory;


	private final int LEVEL1 = 10; //level 1 når point er mellem 0 og 9
	private final int LEVEL2 = 20; //level 2 når point er mellem 10 og 19
	private final int LEVEL3 = 30; //level 3 når point er mellem 20 og 29
	private final int LEVEL4 = 40; //level 4 når point er mellem 30 og 39
	private final int LEVEL5 = 50; //level 5 når point er mellem 40 og 49

	public Player(){
		level = 1;
		points = 0;
		money = 200;
		inventory = new HashMap<String, Integer>();
	}

	public void addToInventory(String itemName, int amount) { //adds trash to player inventory
		if(inventory.containsKey(itemName)){
			inventory.put(itemName, inventory.get(itemName) + amount) ;
		}else{
			inventory.put(itemName, Integer.valueOf(amount));
		}
	}

	public void removeFromInventory(String itemName, int amount){
		if(inventory.containsKey(itemName) && amount <= inventory.get(itemName)){//hashmap function, not our containsKey
			//checks if we actually can remove the given amount from inventory 
			
			inventory.put(itemName, inventory.get(itemName) - amount);
		}else{
			System.out.println("det er ikke muligt");
		}
	}

	public HashMap<String, Integer> getInventory(){
		return inventory;
	}



	public int getTrash() {
		return trash;
	}

	void addPoints(int amount){//add points /xp after buying from the shop 
		points += amount;
	}

	void addMoney(int amount){//earn money by selling trash 
		money += amount;
	}


	void subtractMoney(int amount){//subtract money from player
		if(canAfford(amount)){ //checks if the player has enough money
			money -= amount;
		}else{
			System.out.printf("Det har du ikke råd til. Du har %d penge på din konto", money);
		}
	}

	boolean canAfford(int price) {
		return (price <= getMoney() ? true : false);
	}

	public int getPoints(){
		return points;
	}

	public int getMoney(){
		return money;
	}

	public int getLevel(){
		return level;
	}

	public void getPlayerStatus(){
		System.out.println("Level: " + level + ", XP: " + points + ", money: " + money + " on day " + Game.context.getDay());
	}


	void levelUp(int points){
		if(points > 0 && points < LEVEL1){
			level = 1;
		}else if (points > LEVEL1 && points < LEVEL2){
			level = 2;
		}else if (points > LEVEL2 && points < LEVEL3){
			level = 3;
		}else if (points > LEVEL3 && points < LEVEL4){
			level = 4;
		}else if (points > LEVEL4 && points < LEVEL5){
			level = 5;
		}
	}




}