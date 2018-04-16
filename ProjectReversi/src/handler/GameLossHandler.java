package handler;

import model.GameFW;

public class GameLossHandler extends ActionHandler{
	GameFW gFW;
	
	public GameLossHandler(GameFW gFW) {
		this.gFW = gFW;
	}
    public void run(String message){
        System.out.println("Running GAME LOSS command handler");
    }
}
