package handler;

import model.GameFW;

public class GameWinHandler extends ActionHandler {
	GameFW gFW;
	
	public GameWinHandler(GameFW gFW) {
		this.gFW = gFW;
	}
    public void run(String message){
        System.out.println("Running GAME WIN command handler");
        gFW.setTurn(0);
    }
}
