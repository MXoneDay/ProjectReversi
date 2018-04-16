package handler;

import model.GameFW;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMoveHanlder extends ActionHandler {
	GameFW gFW;
	
	public GameMoveHanlder(GameFW gFW) {
		this.gFW = gFW;
	}
	
    public void run(String message){
        System.out.println("Running GAME MOVE command handler");
		Pattern pattern = Pattern.compile("SVR GAME MOVE \\{PLAYER: \"(.*?)\", DETAILS: \"(.*?)\", MOVE: \"(.*?)\"\\}");
		Matcher matcher = pattern.matcher(message);

		System.out.println("debugging:" + matcher.matches());
//
//		gFW.drawMove(move);
    }
}
