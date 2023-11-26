package com.genbrugsstation;

/* Space class for modeling spaces (rooms, caves, ...)
 */ 

import java.util.Set;

 abstract class Space extends Node implements DefaultSpace {
  private boolean isHandled;
  //private static final long serialVersionUID = 6529685098267757690L;
  private Trash[] trash;

  Space (String name) {
    super(name);
    isHandled = false;
    trash = new Trash[] {new Trash("flasker"), new Trash("aviser")};
  }
  
  public void welcome () {
      System.out.println("\n_______________________________________________________");
      System.out.println("Du er nu ved "+name);
  }

  public void exits() {
    Set<String> exits = edges.keySet();
    System.out.println("\nNuværende udgange fører til");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }
  }
  
  public void goodbye () {
    //Make some logic to know when u should make room handled, if should be handled invoke toggleHandled() method
  }

  public void showTrash(Trash[] trash) {
    System.out.println("\nDu kigger rundt og ser ");
    for (Trash t : trash) {
        System.out.printf("- %d %s%n", t.getAmount(), t.getName());
    }
  }


  public Trash[] getTrash(){
    return trash;
  }

  public void setTrashSpace(Trash[] trash){
    for(Trash t : trash){
      t.setTrash();
    }
  }


  //SubtractTrash subtracts trash from room. Catches InsufficientTrashException 
  public boolean subtractTrash(String name, int amount, Trash[] trash) throws TrashNotFoundException {
    for (Trash t : trash) {
        if (t.getName().equals(name)) {
            try {
                t.subtractTrash(amount);
                return true;
            } catch (InsufficientTrashException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    } throw new TrashNotFoundException(String.format("%s eksisterer ikke i rummet", name));
  }

public boolean isCommandReachable(String name, String[] commands) {
    for (String elm : commands) {
        if (elm.equals(name)) {return true;}
    }
    return false;
  }



  public void makeHandled() {
    isHandled = true;
  }
  public void undoHandled(){
    isHandled = false;
  }

  public boolean getHandled() {
    return isHandled;
  }
}
