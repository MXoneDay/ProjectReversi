package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import controller.PageController;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class PlayerPage implements Page{
    private final PageController pc;
    private GridPane gp = new GridPane();

    public PlayerPage(PageController pc){
        this.pc = pc;
    }

    public void createPage() {
        try {
            TextField text = new TextField();
            gp.setAlignment(Pos.CENTER);
            text.setText("TEST TEST TEST");
            ObservableList<String> seasonList = FXCollections.<String>observableArrayList();

            pc.setGameFW('t');
            pc.getgFW().getDispatcher().getPlayers();
            Thread.sleep(100);
            String[] players = pc.getgFW().getPlayers();
            for (String player : players) {
                seasonList.add(player);
            }
            ListView<String> seasons = new ListView<String>((ObservableList<String>) seasonList);
            gp.add(seasons, 0, 0);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public GridPane getPane() {
        return gp;
    }
}
