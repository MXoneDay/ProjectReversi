package handler;

import model.GameFW;

public class GameYourTurnHandler extends ActionHandler{
	GameFW gFW;
	
	public GameYourTurnHandler(GameFW gFW) {
		this.gFW = gFW;
	}
	
    public void run(String message){
        System.out.println("Running GAME YOUR TURN  command handler");
        gFW.setTurn(1);
    }
}
