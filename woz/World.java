/* World class for modeling the entire in-game world
 */

class World {
  Space kontor;
  
  World () {
    Space kontor = new Kontor("Kontor");
    Space rækkehuse = new Rækkehuse("Rækkehuse");
    Space genbrugsstation = new Genbrugsstation("Genbrugsstation");
    Space park = new Park("Park");
    Space rådhusplads = new Rådhusplads("Rådhusplads");

    Space[] locations = {kontor, rækkehuse, genbrugsstation, park, rådhusplads};
    
    for (Space loc : locations) {
      for (Space edge : locations) {
        if (loc != edge) {
          loc.addEdge(edge.getName(), edge);
        }
      }
    }
    
    this.kontor = kontor;
  }
  
  Space getEntry () {
    return kontor;
  }
}

