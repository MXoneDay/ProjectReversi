package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import controller.PageController;

public class PlayerPage implements Page{
    private final PageController pc;
    private GridPane gp = new GridPane();

    public PlayerPage(PageController pc){
        this.pc = pc;
    }

    public void createPage() {
    	Button b1 = new Button("Back");
    	gp.setAlignment(Pos.CENTER);
    	ObservableList<String> playerList = FXCollections.<String>observableArrayList();
    	playerList.addAll(pc.getPlayers());
    	ListView<String> players = new ListView<String>(playerList);
    	
    	b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				pc.toHome();
			}
		});

		players.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    String opponent = players.getSelectionModel().getSelectedItem();
                    System.out.println("clicked on " + opponent);
                }
			}
		});
    	gp.add(players, 0, 0);
    	gp.add(b1, 0, 1);
    }

    @Override
    public GridPane getPane() {
        return gp;
    }
}
