package com.genbrugsstation;

/* Node class for modeling graphs
 */

import java.util.TreeMap;
import java.io.Serializable;
import java.util.Map;

class Node implements Serializable {
  private String name;
  //We want to be able to use whatever case to call on the key, therefore we use TreeMap which has the comparator CASE_INSENSITIVE_ORDER to fix this problem
  private Map<String, Node> edges = new TreeMap<String, Node>(String.CASE_INSENSITIVE_ORDER);
  
  Node (String name) {
    this.name = name;
  }
  
  public String getName () {
    return name;
  }
  public Map<String, Node> getEdges(){
    return edges;
  }
  
  void addEdge (String name, Node node) {
    edges.put(name, node);
  }
  
  private Node followEdge (String direction) {
    return edges.get(direction);
  }
}

