package handler;

import model.GameFW;

public class GameYourTurnHandler extends ActionHandler{
	GameFW gFW;
	
	public GameYourTurnHandler(GameFW gFW) {
		this.gFW = gFW;
	}
	
    public void run(String message){
        gFW.setTurn();
    }
}
