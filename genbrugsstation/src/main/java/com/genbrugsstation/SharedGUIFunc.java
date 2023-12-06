package com.genbrugsstation;

import java.io.IOException;
import java.util.Objects;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SharedGUIFunc {
    static String prevView = null;
    static String currentView = null;
    static DomainMain domain = null;
    static Scene scene;
    static Context context;
    static World world;
    static Player player;

    SharedGUIFunc() {

    }

    SharedGUIFunc(DomainMain domain) {
        SharedGUIFunc.domain = domain;
        context = domain.getContext();
        world = domain.world;
        player = context.getPlayer();
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(Game.class.getResource(fxml + ".fxml")));
        return fxmlLoader.load();
    }

    public static void setRoot(String rootNode) {
      prevView = currentView;
      Space[] loc = domain.world.getLocations();
      String title = rootNode.split("-")[0];
      System.out.println("This is title from event: " + title.trim().toLowerCase());
      for(Space s : loc) {
        System.out.println("Space[i]: " + s.getName().toLowerCase());
        if ((s.getName().toLowerCase()).equals(title.trim().toLowerCase())) {
          domain.getContext().setCurrent(s);
          if((s.getName().trim().toLowerCase()).equals("butik") && (title.trim().toLowerCase().equals("opgraderinger"))){
            domain.getContext().setCurrent(s);
          }
          System.out.println("Setting root to: " + domain.getContext().getCurrent().getName());
          currentView = rootNode;
          break;
        }
      }

      try {
          scene = new Scene(loadFXML(rootNode));
          Stagestore.stage.setScene(scene);
          System.out.println(title);
          Stagestore.stage.setTitle(title);
          Stagestore.stage.centerOnScreen();
          Stagestore.stage.show();
      }catch (IOException e){
          System.out.println(e.getMessage());
          e.printStackTrace();
      }

    }


    //From event getId(), all go buttons that change view have id "go_%location%", so take the location and add "-view", to get name of proper .fxml file
    public String getLocationFromEvent(Event event) {
        String id = ((javafx.scene.Node)event.getSource()).getId();
        String location = id.split("_")[1] + "-view";
        return location;
    }

    public void setRootFromEvent(Event event) throws IOException{
        String location = getLocationFromEvent(event);
        setRoot(location);
    }

    public static void setRootFromString(String root) {
        setRoot(root);
    }

    //pickup buttons Id is "pickup_1_%type of trash%", so elm[2] represents type of trash
    //player.pickup returns true if pickup was succesfull and feedback is updated
    public static String pickup(Event event) throws TrashNotFoundException {
        String cmd = ((Button)event.getSource()).getId().replace("_", " ");
        String[] elm = cmd.split(" ");

        boolean didPickup = player.pickup(elm[2], 1, context.getCurrent().getTrash(), context);
        return (didPickup ? "Du har samlet 1 " + elm[2] + " op | " + player.getInventory().getItems().get(elm[2]) + " totalt" : "Ikke mere at samle op");
    }

    //Returns a String of amount of present trash in the order its stored in the room (Space)
    public String[] getTrashUpdate() {
        Trash[] trash = context.getCurrent().getTrash();
        String[] update = new String[trash.length];
        for (int i = 0; i<trash.length;i++) {
            update[i] = Integer.toString(trash[i].getAmount());
        }

        return update;
    }

    public void showInventory() throws IOException {
        setRootFromString("inventory-view");
    }

    public boolean isUpgradeBought(String name) {
        for(String u : Butikdata.getUpgrades()) {
            if (u.equals(name)) {return true;}
        }

        return false;
    }

    //Makes trash label opacity 1 if trashAmount != 0, otherwise opa=0
    public void makeTrashVisible(AnchorPane[] trashGUIelements, Label[] trashGUIlabels) {
        if (trashGUIelements.length != trashGUIlabels.length){
            System.out.println("Not equal amounts of trash and labels");
            return;
        }

        for (int i = 0; i<trashGUIelements.length;i++) {
            trashGUIelements[i].setOpacity((trashGUIlabels[i].getText().equals("0") ? 0 : 1));
        }
    }

    //Makes trash label opacity 1 if trashAmount != 0, otherwise opa=0
    public void setTrashVisibility(AnchorPane[] trashGUIelements, String[] update) {
        for (int i = 0;i<trashGUIelements.length;i++) {
            if (update[i].equals("0")) {
                trashGUIelements[i].setOpacity(0);
            }
        }
    }

    //updates feedback and here feedback style can be set
    public void updateFeedback(String feedback, Text feedback_txtField) {
        feedback_txtField.setText(feedback);
        feedback_txtField.setFill(Color.rgb(84,47,19));
        feedback_txtField.setFont(Font.font("Rockwell", 24));
    }
}
