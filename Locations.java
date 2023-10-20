class Locations{

	static boolean trashParkCollected;
	static boolean trashBymidteCollected;
	static boolean trashHospitalCollected;
	static boolean shopVisited;
	static boolean recyclingVisited;

	static void shopNow(){
		System.out.println("du er i butikken nu");
		//her skal der være et udvalg af upgrades til byen, som man kan vælge at købe
		/*måske en dictionary med navn på hver upgrade og pris? 
		og et if/else eller switch-statement, der ved køb af en ting tjekker om spilleren
		har råd til det, printer en besked hvis ikke, og ellers opdaterer spilleres penge 
		efter køb og opdaterer byen afhængigt af køb*/
		
		shopVisited = true;
	}

	static void collectTrashPark(){
		System.out.println("collecting trash at this park"); //placeholder
		trashParkCollected = true;
	}


	static void collectTrashBymidte(){
		System.out.println("collecting trash at bymidte"); //placeholder
		trashBymidteCollected = true;
	}

	static void collectTrashHospital(){
		System.out.println("collecting trash at this hospital"); //placeholder
		trashHospitalCollected = true;
	}


	static void recycle(int amountOfTrash){
		System.out.println("du har afleveret " + amountOfTrash + " stykker affald i dag"); //placeholder

		recyclingVisited = true;
	}




}