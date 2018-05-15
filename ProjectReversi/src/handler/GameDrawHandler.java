package handler;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import model.GameFW;

public class GameDrawHandler extends ActionHandler {
	GameFW gFW;
	
	public GameDrawHandler(GameFW gFW) {
		this.gFW = gFW;
	}
    public void run(String message){
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				gFW.pageController().getAlertView().setAlert(Alert.AlertType.INFORMATION);
				Alert alert = gFW.pageController().getAlertView().getAlert();
				alert.setHeaderText(null);
				alert.setTitle("GAME OVER");
				alert.setContentText("It's a draw!");
				alert.show();
			}

		});
    }
}
