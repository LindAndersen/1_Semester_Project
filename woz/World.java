/* World class for modeling the entire in-game world
 */
import java.util.*;

class World {
  Space entry;
  List<Space> locations = new ArrayList<Space>();
  
  World () {
    entry           = new Space("kontor");
    Space rp        = new Space("raedhusplads");
    Space trash     = new Space("genbrugsstation");
    Space park      = new Space("park");
    Space shop      = new Space("butik");
    Space homes     = new Space("roekkehuse");

    Space[] spaces = new Space[] {entry, rp, trash, park, shop, homes};
    locations.addAll(Arrays.asList(spaces));
    
    entry.addEdge(rp.name, rp);
    entry.addEdge(shop.name, shop);
    shop.addEdge(entry.name, entry);
    shop.addEdge(rp.name, rp);
    shop.addEdge(park.name, park);
    shop.addEdge(trash.name, trash);
    trash.addEdge(shop.name, shop);
    rp.addEdge(entry.name, entry);
    rp.addEdge(shop.name, shop);
    rp.addEdge(park.name, park);
    park.addEdge(rp.name, rp);
    park.addEdge(shop.name, shop);
    park.addEdge(homes.name, homes);
    homes.addEdge(park.name, park);
    
    this.entry = entry;

    for (Space location : locations) {
      if (location.name.equals(entry.name)) {
        location.addCommand("status");
      } else if (location.name.equals(shop.name)) {
        location.addCommand("sell");
        location.addCommand("buy");
      }
      location.addCommand("pickup");
      location.addCommand("hint");
  }

  //Build spaces with SpaceBuilder()
}
  
  Space getEntry () {
    return entry;
  }
}

