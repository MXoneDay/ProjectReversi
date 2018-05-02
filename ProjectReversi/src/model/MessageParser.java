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
    OkHandler okHandler;
    ErrHandler errHandler;
    GameListHandler gameListHandler;
    PlayerListHandler playerListHandler;
    GameMatchHandler gameMatchHandler;
    GameYourTurnHandler gameYourTurnHandler;
    GameMoveHanlder gameMoveHanlder;
    GameWinHandler gameWinHandler;
    GameLossHandler gameLossHandler;
    GameDrawHandler gameDrawHandler;
    GameChallengeHandler gameChallengeHandler;
    GameChallengeCancelledHandler gameChallengeCancelledHandler;

    public MessageParser(GameFW gFW){
        //System.out.println("DEBUG 2 : "+this.gf.toString());
        // initialize handlers
        this.okHandler = new OkHandler();
        this.errHandler = new ErrHandler();
        this.gameListHandler = new GameListHandler();
        this.playerListHandler = new PlayerListHandler(gFW);
        this.gameMatchHandler = new GameMatchHandler();
        this.gameYourTurnHandler = new GameYourTurnHandler(gFW);
        this.gameMoveHanlder = new GameMoveHanlder(gFW);
        this.gameWinHandler = new GameWinHandler(gFW);
        this.gameLossHandler = new GameLossHandler(gFW);
        this.gameDrawHandler = new GameDrawHandler(gFW);
        this.gameChallengeHandler = new GameChallengeHandler();
        this.gameChallengeCancelledHandler = new GameChallengeCancelledHandler();

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

