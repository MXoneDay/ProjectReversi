package handler;

import model.GameFW;

public class GameMoveHanlder extends ActionHandler {
	GameFW gFW;
	
	public GameMoveHanlder(GameFW gFW) {
		this.gFW = gFW;
	}
	
    public void run(String message){
        System.out.println("Running GAME MOVE command handler");
        //gFW.move(/*TODO*/);
    }
}
