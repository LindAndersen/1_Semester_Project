/* Node class for modeling graphs
 */

import java.util.HashMap;
import java.util.Map;

class Node {
  String name;
  Map<String, Node> edges = new HashMap<String, Node>();
  
  Node (String name) {
    this.name = name;
  }
  
  public String getName () {
    return name;
  }
  
  public void addEdge (String name, Node node) {
    edges.put(name, node);
  }
  
  public Node followEdge (String direction) {
    return edges.get(direction);
  }
}

