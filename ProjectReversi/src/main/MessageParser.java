package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class MessageParser {
    Map<String, Class> messages = new HashMap<String, Class>();

    public MessageParser(){
        messages.put("OK", OkHandler.class);
        messages.put("ERR (.*?)+", ErrHandler.class);
        messages.put("SVR GAMELIST \\[(.*?)\\]", GameListHandler.class);
        messages.put("SVR PLAYERLIST \\[(.*?)\\]", PlayerListHandler.class);
        messages.put("SVR GAME MATCH \\{(.*?)\\}", GameMatchHandler.class);
        messages.put("SVR GAME YOURTURN \\{(.*?)\\}", GameYourTurnHandler.class);
        messages.put("SVR GAME MOVE \\{(.*?)\\}", GameMoveHanlder.class);
        messages.put("SVR GAME WIN \\{(.*?)\\}", GameWinHandler.class);
        messages.put("SVR GAME LOSS \\{(.*?)\\}", GameLossHandler.class);
        messages.put("SVR GAME DRAW \\{(.*?)\\}", GameDrawHandler.class);
        messages.put("SVR GAME CHALLENGE \\{(.*?)\\}", GameChallengeHandler.class);
        messages.put("SVR GAME CHALLENGE CANCELLED \\{(.*?)\\}", GameChallengeCancelledHandler.class);
    }

    public void parse(String message){
        for (Map.Entry<String, Class> item : messages.entrySet()) {
            String regex = item.getKey();
            Class handler = item.getValue();

            if (message.matches(regex)) {
                try {
                    handler.getMethod("run").invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("message not found: " + message);
    }
}

