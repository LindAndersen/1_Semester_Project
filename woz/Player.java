import java.util.*;

class Player{
	private int level;
	private int points;
	private int money;
	private int trash;

	private final int LEVEL1 = 10; //level 1 når point er mellem 0 og 9
	private final int LEVEL2 = 20; //level 2 når point er mellem 10 og 19
	private final int LEVEL3 = 30; //level 3 når point er mellem 20 og 29
	private final int LEVEL4 = 40; //level 4 når point er mellem 30 og 39
	private final int LEVEL5 = 50; //level 5 når point er mellem 40 og 49

	public Player(){
		level = 1;
		points = 0;
		money = 200;
		trash = 0;

	}

	public void addTrash(int amount) {
		trash += amount;
	}

	public int getTrash() {
		return trash;
	}

	void addPoints(int amount){//efter køb af udvidelse
		points += amount;
	}

	void addMoney(int amount){//skal bruges på genbrugsstationen i Space-class
		money += amount;
	}


	void subtractMoney(int amount){//bruges i butik ved køb
		if((money-amount) < 0){
			System.out.println("Beklager, men du har ikke råd til dette.");
		}else{
			money -= amount;

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

	public void getStatus(){
		System.out.println("Level: " + level + ", XP: " + points + ", money: " + money + " on day " + Game.context.getDay());
	}


	void levelUp(int points){
		if(points >= 0 && points <= LEVEL1){
			level = 1;
		}else if (points > LEVEL1 && points <= LEVEL2){
			level = 2;
		}else if (points > LEVEL2 && points <= LEVEL3){
			level = 3;
		}else if (points > LEVEL3 && points <= LEVEL4){
			level = 4;
		}else if (points > LEVEL4 && points <= LEVEL5){
			level = 5;
		} else {
			level = 9001;
		}
	}




}