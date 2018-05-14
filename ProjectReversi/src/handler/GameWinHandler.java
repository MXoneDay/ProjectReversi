package handler;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import model.GameFW;

public class GameWinHandler extends ActionHandler {
	GameFW gFW;
	
	public GameWinHandler(GameFW gFW) {
		this.gFW = gFW;
	}
    public void run(String message){
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Alert alert = gFW.pageController().getAlertView().getAlert();
				alert.setAlertType(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("GAME OVER");
				alert.setContentText("You have won the game!");
				alert.show();
			}

		});
    }
}
