package handler;

import model.GameFW;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerListHandler extends ActionHandler{
    GameFW gf;

    public PlayerListHandler(GameFW gf){
        this.gf = gf;
    }

    public void run(String message){
        Pattern pattern = Pattern.compile("SVR PLAYERLIST \\[(.*?)\\]");
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            String players = matcher.group(1);
            System.out.println("DEBUG: "+players);
            players = players.replace("\"", "");
            String[] playersArray = players.split(", ");
            gf.setPlayers(playersArray);
        }
    }
}
