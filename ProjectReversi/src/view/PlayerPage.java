package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import controller.PageController;

public class PlayerPage implements Page{
    private final PageController pc;
    private GridPane gp = new GridPane();
    private String selectedOpponent;
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
                if (selectedOpponent != null){
                	Alert alert = pc.getAlertView().getAlert();
                	Timeline tl = new Timeline(new KeyFrame(Duration.seconds(10), (aEvent) -> {pc.getAlertView().hideAlert();}));
                	alert.setTitle("Challenging Player...");
                	alert.setContentText("Player: " + selectedOpponent);
                	pc.startChallenge(selectedOpponent, "Reversi");
                	alert.show();
                	tl.play();
                }
            }
        });

        // challenge Tic-tac-toe
        TictactoeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                if (selectedOpponent != null){
                	Alert alert = pc.getAlertView().getAlert();
                	Timeline tl = new Timeline(new KeyFrame(Duration.seconds(10), (aEvent) -> {pc.getAlertView().hideAlert();}));
                	alert.setTitle("Challenging Player...");
                	alert.setContentText("Player: " + selectedOpponent);
                	pc.startChallenge(selectedOpponent, "Tic-tac-toe");
                	alert.show();
                	tl.play();
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
			}
		});
    	gp.add(players, 0, 0);
    	gp.add(b1, 0, 1);
    	gp.add(refreshButton, 0, 2);
        gp.add(reversiButton, 1, 2);
        gp.add(TictactoeButton, 2, 2);
    }

    @Override
    public GridPane getPane() {
        return gp;
    }
}
