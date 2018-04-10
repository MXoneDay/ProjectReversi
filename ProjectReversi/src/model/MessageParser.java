package model;

import java.util.HashMap;
import java.util.Map;

import handler.ActionHandler;
import handler.ErrHandler;
import handler.GameChallengeCancelledHandler;
import handler.GameChallengeHandler;
import handler.GameDrawHandler;
import handler.GameListHandler;
import handler.GameLossHandler;
import handler.GameMatchHandler;
import handler.GameMoveHanlder;
import handler.GameWinHandler;
import handler.GameYourTurnHandler;
import handler.OkHandler;
import handler.PlayerListHandler;

public class MessageParser {
    Map<String, ActionHandler> messages = new HashMap<String, ActionHandler>();

    // initialize handlers
    OkHandler okHandler = new OkHandler();
    ErrHandler errHandler = new ErrHandler();
    GameListHandler gameListHandler = new GameListHandler();
    PlayerListHandler playerListHandler = new PlayerListHandler();
    GameMatchHandler gameMatchHandler = new GameMatchHandler();
    GameYourTurnHandler gameYourTurnHandler = new GameYourTurnHandler();
    GameMoveHanlder gameMoveHanlder = new GameMoveHanlder();
    GameWinHandler gameWinHandler = new GameWinHandler();
    GameLossHandler gameLossHandler = new GameLossHandler();
    GameDrawHandler gameDrawHandler = new GameDrawHandler();
    GameChallengeHandler gameChallengeHandler = new GameChallengeHandler();
    GameChallengeCancelledHandler gameChallengeCancelledHandler = new GameChallengeCancelledHandler();


    public MessageParser(){
        messages.put("OK", this.okHandler);
        messages.put("ERR (.*?)+", this.errHandler);
        messages.put("SVR GAMELIST \\[(.*?)\\]", this.gameListHandler);
        messages.put("SVR PLAYERLIST \\[(.*?)\\]", this.playerListHandler);
        messages.put("SVR GAME MATCH \\{(.*?)\\}", this.gameMatchHandler);
        messages.put("SVR GAME YOURTURN \\{(.*?)\\}", this.gameYourTurnHandler);
        messages.put("SVR GAME MOVE \\{(.*?)\\}", this.gameMoveHanlder);
        messages.put("SVR GAME WIN \\{(.*?)\\}", this.gameWinHandler);
        messages.put("SVR GAME LOSS \\{(.*?)\\}", this.gameLossHandler);
        messages.put("SVR GAME DRAW \\{(.*?)\\}", this.gameDrawHandler);
        messages.put("SVR GAME CHALLENGE \\{(.*?)\\}", this.gameChallengeHandler);
        messages.put("SVR GAME CHALLENGE CANCELLED \\{(.*?)\\}", this.gameChallengeCancelledHandler);

    }

    public void parse(String message){
        boolean messageFound = false;

        for (Map.Entry<String, ActionHandler> item : messages.entrySet()) {
            String regex = item.getKey();
            ActionHandler handler = item.getValue();

            if (message.matches(regex)) {
                messageFound = true;
                handler.run(message);
            }
        }

        if (!messageFound){
            System.out.println("Message not found: " + message);
        }
    }
}

