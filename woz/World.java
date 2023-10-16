/* World class for modeling the entire in-game world
 */

class World {
  Space entry;
  
  World () {
    Space entry    = new Space("borgmesterenshus");
    Space city     = new Space("midtbyen");
    Space trash    = new Space("losseplads");
    Space park     = new Space("park");
    Space pond     = new Space("soe");
    
    entry.addEdge(city.name, city);
    entry.addEdge(pond.name, pond);
    pond.addEdge(entry.name, entry);
    pond.addEdge(park.name, park);
    park.addEdge(pond.name, pond);
    park.addEdge(trash.name, trash);
    trash.addEdge(park.name, park);
    trash.addEdge(city.name, city);
    city.addEdge(trash.name, trash);
    city.addEdge(entry.name, entry);
    
    this.entry = entry;
  }
  
  Space getEntry () {
    return entry;
  }
}

