package com.example.butikui;/* Node class for modeling graphs
 */

import java.util.Map;
import java.util.TreeMap;

class Node {
  String name;
  //We want to be able to use whatever case to call on the key, therefore we use TreeMap which has a neat function CASE_INSENSITIVE_ORDER to fix this problem
  Map<String, Node> edges = new TreeMap<String, Node>(String.CASE_INSENSITIVE_ORDER);
  
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

