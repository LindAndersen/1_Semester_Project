/* World class for modeling the entire in-game world
 */

class World {
  private Space kontor;
  private Space[] locations;
  
  World () {
    Space kontor = new Kontor("Kontor");
    Space rækkehuse = new Rækkehuse("Villakvarter");
    Space genbrugsstation = new Genbrugsstation("Genbrugsstation");
    Space park = new Park("Park");
    Space rådhusplads = new Rådhusplads("Centrum");
    Space butik = new Butik("Butik");

    //Adding all spaces to Space array, so we can access them in a more efficient way when adding edges
    Space[] locations = {kontor, rækkehuse, genbrugsstation, park, rådhusplads, butik};
    
    //Adds every location to every location with the exception of an arbitrary location cant reach itself
    for (Space loc : locations) {
      for (Space edge : locations) {
        if (loc != edge) {
          loc.addEdge(edge.getName(), edge);
        }
      }
    }
    kontor.addEdge("kontor", kontor);
    
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

