package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import controller.PageController;

public class PlayerPage implements Page{
    private final PageController pc;
    private GridPane gp = new GridPane();

    public PlayerPage(PageController pc){
        this.pc = pc;
    }

    public void createPage() {
    	System.out.println("sofar5");
    	gp.setAlignment(Pos.CENTER);
    	 System.out.println("sofar6");
    	 ObservableList<String> playerList = FXCollections.<String>observableArrayList();
    	 System.out.println("sofar7");
    	 String[] pl = pc.getPlayers();
    	 System.out.println("sofar10");
    	 for(String s : pl) {
    		 playerList.add(s);
    	 }
    	 System.out.println("sofar8");
    	ListView<String> players = new ListView<String>(playerList);
    	 System.out.println("sofar9");
    	gp.add(players, 0, 0);
    	System.out.println("sofar4");
    }

    @Override
    public GridPane getPane() {
        return gp;
    }
}
