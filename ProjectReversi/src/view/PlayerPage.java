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
    private String selectedOpponent;
    private boolean p1ai, p2ai;
    private ListView<String> players;
    private ObservableList<String> playerList;

    public PlayerPage(PageController pc){
        this.pc = pc;
    }

    public void createPage() {
    	Button b1 = new Button("Back");
        Button reversiButton = new Button("Challenge Reversi");
        Button TictactoeButton = new Button("Challenge Tic-tac-toe");
        Button refreshButton = new Button("Refresh player list");

    	gp.setAlignment(Pos.CENTER);
    	playerList = FXCollections.<String>observableArrayList();
    	playerList.setAll(pc.getPlayers());
    	players = new ListView<String>(playerList);

    	b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				pc.toHome();
			}
		});

    	// challenge Reversi
        reversiButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                System.out.println("debuggignging: "+selectedOpponent);
                if (selectedOpponent != null){
                    System.out.println("Challenging player: "+selectedOpponent+" to Reversi");
                    pc.startChallenge(selectedOpponent, "Reversi");
                    pc.toChallengePage();
                }
            }
        });

        // challenge Tic-tac-toe
        TictactoeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                if (selectedOpponent != null){
                    System.out.println("Challenging player: "+selectedOpponent+" to Tic-tac-toe");
                    pc.startChallenge(selectedOpponent, "Tic-tac-toe");
                    pc.toChallengePage();
                }
            }
        });

        refreshButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playerList.setAll(pc.getPlayers());
                players.refresh();
            }
        });

		players.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
			public void handle(MouseEvent event) {

			    selectedOpponent = players.getSelectionModel().getSelectedItem();
                System.out.println("Selected: "+selectedOpponent);
			}
		});
    	gp.add(players, 0, 0);
    	gp.add(b1, 0, 1);
    	gp.add(refreshButton, 0, 2);
        gp.add(reversiButton, 1, 2);
        gp.add(TictactoeButton, 2, 2);
    }
    
    public void setAIs(boolean p1ai, boolean p2ai) {
    	this.p1ai = p1ai;
    	this.p2ai = p2ai;
    }

    @Override
    public GridPane getPane() {
        return gp;
    }
}
