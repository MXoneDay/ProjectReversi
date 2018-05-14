package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import controller.PageController;

public class ChallengePage implements Page{
    private final PageController pc;
    private GridPane gp = new GridPane();

    public ChallengePage(PageController pc){
        this.pc = pc;
    }

    public void createPage() {
        Button b1 = new Button("Back");
        Label label = new Label("Waiting for opponent to respond...");
        gp.setAlignment(Pos.CENTER);

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                try {
                    pc.toPlayerPage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        gp.add(b1, 0, 2);
        gp.add(label, 0, 1);
    }

    @Override
    public GridPane getPane() {
        return gp;
    }
}
