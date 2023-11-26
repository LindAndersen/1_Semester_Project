package com.genbrugsstation;

/* World class for modeling the entire in-game world
 */
import java.io.Serializable;

class World implements Serializable {
  //private static final long serialVersionUID = 6529685098267757691L;
  private Space kontor;
  private Space[] locations;
  
  World () {
    Space kontor = new Kontor("Kontor");
    Space villakvarter = new Villakvarter("Villakvarter");
    Space genbrugsstation = new Genbrugsstation("Genbrugsstation");
    Space park = new Park("Park");
    Space centrum = new Centrum("Centrum");
    Space butik = new Butik("Butik");

    //Adding all spaces to Space array, so we can access them in a more efficient way when adding edges
    Space[] locations = {kontor, villakvarter, genbrugsstation, park, centrum, butik};
    
    //Adds every location to every location with the exception of an arbitrary location cant reach itself
    for (Space loc : locations) {
      for (Space edge : locations) {
        if (loc != edge) {
          loc.addEdge(edge.getName(), edge);
        }
      }
    }
    
    this.kontor = kontor;
    this.locations = locations;
  }
  
  public Space getEntry () {
    return kontor;
  }

  public Space[] getLocations() {
    return locations;
  }

}

