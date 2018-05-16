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
        //System.out.println("Running GAME MOVE command handler");
		Pattern pattern = Pattern.compile("SVR GAME MOVE \\{PLAYER: \"(.*?)\", MOVE: \"(.*?)\", DETAILS: \"(.*?)\"\\}");
		Matcher matcher = pattern.matcher(message);

		String player = null;
		Integer move = null;
		String details;

		if (matcher.find()){
			player = matcher.group(1);
			move = Integer.parseInt(matcher.group(2));
			details = matcher.group(3);
		}
		//System.out.println("drawMove: "+move);
		gFW.drawMove(move, player);
    }
}
