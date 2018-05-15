package handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.GameFW;

public class PlayerListHandler extends ActionHandler{
	GameFW gFW;
	public PlayerListHandler(GameFW gFW) {
		this.gFW = gFW;
	}

    public void run(String message){
        Pattern pattern = Pattern.compile("SVR PLAYERLIST \\[(.*?)\\]");
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            String players = matcher.group(1);
            //System.out.println("DEBUG: "+players);
            players = players.replace("\"", "");
            String[] playersArray = players.split(", ");
            gFW.setPlayers(playersArray);
        }
    }
}
