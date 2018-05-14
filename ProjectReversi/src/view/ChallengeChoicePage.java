package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import controller.PageController;

public class ChallengeChoicePage implements Page{
    private final PageController pc;
    private GridPane gp = new GridPane();

    public ChallengeChoicePage(PageController pc){
        this.pc = pc;
    }

    public void createPage() {
        Button b1 = new Button("Back");
        Button acceptButton = new Button("Accept");
        Button denyButton = new Button("Deny");
        Label label = new Label("X has challenged you to a game of Y.");
        gp.setAlignment(Pos.CENTER);

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                try {
                    pc.backToPlayerPage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        gp.add(b1, 0, 2);
        gp.add(label, 0, 1);
        gp.add(acceptButton, 1, 2);
        gp.add(denyButton, 0, 2);
    }

    @Override
    public GridPane getPane() {
        return gp;
    }
}
