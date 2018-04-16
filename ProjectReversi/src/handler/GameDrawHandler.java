package handler;

import model.GameFW;

public class GameDrawHandler extends ActionHandler {
	GameFW gFW;
	
	public GameDrawHandler(GameFW gFW) {
		this.gFW = gFW;
	}
    public void run(String message){
        System.out.println("Running GAME DRAW command handler");
        gFW.setTurn(0);
    }
}
