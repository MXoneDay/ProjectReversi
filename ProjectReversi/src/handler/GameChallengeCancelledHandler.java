package handler;

import javafx.application.Platform;
import model.GameFW;

public class GameChallengeCancelledHandler extends ActionHandler {
	GameFW gFW;
	
	public GameChallengeCancelledHandler(GameFW gFW){
		this.gFW = gFW;
	}
	
    public void run(String message){
        Platform.runLater(new Runnable() {

			@Override
			public void run() {
				gFW.pageController().getAlertView().hideAlert();
			}
        });
    }
}
