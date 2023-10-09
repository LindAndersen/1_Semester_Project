/* World class for modeling the entire in-game world
 */

class World {
  Space entry;
  
  World () {
    Space entry    = new Space("Entry");
    Space corridor = new Space("Corridor");
    Space cave     = new Space("Cave");
    Space pit      = new Space("Darkest Pit");
    Space outside  = new Space("Outside");
    
    entry.addEdge("door", corridor);
    corridor.addEdge("door", cave);
    cave.addEdge("north", pit);
    cave.addEdge("south", outside);
    pit.addEdge("door", cave);
    outside.addEdge("door", cave);
    
    this.entry = entry;
  }
  
  Space getEntry () {
    return entry;
  }
}

