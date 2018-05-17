package handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            String username = gFW.getUsername();
            players = players.replace("\"", "");
            String[] playersArray = players.split(", ");
            List<String> list = new ArrayList<String>(Arrays.asList(playersArray));
            list.remove(username);
            playersArray = list.toArray(new String[0]);
            gFW.setPlayers(playersArray);
        }
    }
}
