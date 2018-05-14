package handler;

import model.GameFW;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class GameChallengeHandler extends ActionHandler{
    GameFW gFW;

    public GameChallengeHandler(GameFW gFW) {
        this.gFW = gFW;
    }

    public void run(String message){
    	

        System.out.println("Running GAME CHALLENGE command handler");
        Pattern pattern = Pattern.compile("SVR GAME CHALLENGE \\{CHALLENGER: \"(.*?)\", CHALLENGENUMBER: \"(.*?)\", GAMETYPE: \"(.*?)\"\\}");
        Matcher matcher = pattern.matcher(message);

        String challenger;
        String gameType;
        String challengeNumber;

        if (matcher.find()){
             challenger = matcher.group(1);
             gameType = matcher.group(3);
             challengeNumber = matcher.group(2);
        }
        else {
        	 challenger = null;
        	 gameType = null;
        	 challengeNumber = null;
        }
        System.out.println(challenger + " has challenged you to a game of "+gameType+", the challenge number is "+challengeNumber);
        
        Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("Challenge recieved!");
				alert.setContentText(challenger + " has challenged you to a game of "+gameType+", the challenge number is "+challengeNumber);    
				ButtonType bt1 = new ButtonType("Accept");
				ButtonType bt2 = new ButtonType("Deny");
				alert.getButtonTypes().setAll(bt1, bt2);
				
				Optional<ButtonType> result = alert.showAndWait();
				if(result.get() == bt1) {
					// accept
				}else if(result.get() == bt2) {
					// cancel
				}
			}
        	
        });
    }
}
