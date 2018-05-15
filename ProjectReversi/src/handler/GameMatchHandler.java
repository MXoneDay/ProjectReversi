package handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import model.GameFW;

public class GameMatchHandler extends ActionHandler{
    GameFW gFW;

    public GameMatchHandler(GameFW gFW) {
        this.gFW = gFW;
    }

    public void run(String message){
        System.out.println("Running GAME MATCH command handler");
        Pattern pattern = Pattern.compile("SVR GAME MATCH \\{PLAYERTOMOVE: \"(.*?)\", GAMETYPE: \"(.*?)\", OPPONENT: \"(.*?)\"\\}");
        Matcher matcher = pattern.matcher(message);

        String playerToMove;
        String gameType;
        String opponent;

        if (matcher.find()){
            playerToMove = matcher.group(1);
            gameType = matcher.group(2);
            opponent = matcher.group(3);
        }
        else{
        	playerToMove = null;
            gameType = null;
            opponent = null;
        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    gFW.pageController().setGame(Class.forName("model." + gameType).getConstructor().newInstance(), playerToMove, opponent);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Unknown game");
                    alert.setContentText("Can not find game: " +gameType);
                    alert.show();
                }
            }
        });
    }
}
