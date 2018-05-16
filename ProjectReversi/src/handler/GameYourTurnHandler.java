package handler;

import model.GameFW;

public class GameYourTurnHandler extends ActionHandler{
	GameFW gFW;
	
	public GameYourTurnHandler(GameFW gFW) {
		this.gFW = gFW;
	}
	
    public void run(String message){
        //System.out.println("Running GAME YOUR TURN  command handler");
        synchronized(gFW) {
        	try {
        		System.out.println(Thread.currentThread().getName() + " is waiting");
    			gFW.wait();
    			gFW.setTurn();
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
        }
    }
}
