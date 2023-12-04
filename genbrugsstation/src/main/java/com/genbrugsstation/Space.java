package com.genbrugsstation;

/* Space class for modeling spaces (rooms, caves, ...)
 */ 

 abstract class Space extends Node {
  private boolean isHandled;
  private Trash[] trash;

  Space (String name) {
    super(name);
    isHandled = false;
    trash = new Trash[] {new Trash("flasker"), new Trash("aviser")};
  }
  
  public void welcome () {
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
