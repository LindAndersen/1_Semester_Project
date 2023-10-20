/* World class for modeling the entire in-game world
 */

class World {
  Space overview;
  
  World () {

    //redigeret til at passe til vores lokationer-----------------------------------------------------------------

    Space overview = new Space("Overblik");
    Space park = new Space("Park");
    Space bymidte = new Space("Bymidte"); //bymidte? rådhusplads?
    Space hospital = new Space("Hospital");
    Space butik  = new Space("Butik");
    Space genbrugsstation = new Space("Genbrugsstation");
    
    //sørger for at alle lokationer kan nås fra overview
    overview.addEdge("park", park);
    overview.addEdge("bymidte", bymidte);
    overview.addEdge("hospital", hospital);
    overview.addEdge("butik", butik);
    overview.addEdge("genbrugsstation", genbrugsstation);


    //alle lokationer har kun adgang til overblik
    park.addEdge("overblik", overview);
    bymidte.addEdge("overblik", overview);
    hospital.addEdge("overblik", overview);
    butik.addEdge("overblik", overview);
    genbrugsstation.addEdge("overblik", overview);
    
    this.overview = overview;
  }
  
  Space getEntry () {
    return overview;//redigeret fra "entry" til "overview", da overview fungerer som vores entry
  }
}

