/* World class for modeling the entire in-game world
 */

class World {
  static Space kontor;
  static Space park;
  static Space bymidte;
  static Space hospital;
  static Space butik;
  static Space genbrugsstation;
  //statiske instanser så Space kan finde dem
  
  World () {

    //redigeret til at passe til vores lokationer - mangler ændring ----------------------------------------------------------

    kontor = new Space("Kontor");
    park = new Space("Park");
    bymidte = new Space("Bymidte"); //bymidte? rådhusplads?
    hospital = new Space("Hospital");
    butik  = new Space("Butik");
    genbrugsstation = new Space("Genbrugsstation");
    
    //arrays af hhv navne og steder, som kan sættes ind i et for-loop, der laver edges til alle steder
    String[] locationArr = {"kontor", "park", "bymidte", "hospital", "butik", "genbrugsstation"};
    Space[] spaceArr = {kontor, park, bymidte, hospital, butik, genbrugsstation};

    //uddelegerer edges til hver lokation/rum. sørger også for, at et rum ikke har adgang til sig selv.
    for(int i = 0; i < spaceArr.length; i++){
      for(int j = 0; j < locationArr.length; j++){
        if(locationArr[j].toLowerCase().equals(spaceArr[i].toString().toLowerCase())){
          continue;
        }else{
          spaceArr[i].addEdge(locationArr[j], spaceArr[j]);
        }
      }
    }

    //kontor skal have sig selv som edge, for at resetDay() virker inde fra kontoret af.
    //hvis ikke kontor har adgang til sig selv, vil transition() ikke du, da den "næste"
    //edge er null.
    kontor.addEdge("kontor", kontor);
    //-------------------------------------------------------------------------------------------------------------------------
    
    this.kontor = kontor;
  }
  
  Space getEntry () {
    return kontor;//redigeret fra "entry" til "kontor", da kontor fungerer som vores entry
  }
}

