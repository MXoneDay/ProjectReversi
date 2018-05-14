package model;

import java.util.HashMap;
import java.util.Map;
import handler.*;

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
        // initialize handlers
        this.okHandler = new OkHandler();
        this.errHandler = new ErrHandler(gFW);
        this.gameListHandler = new GameListHandler();
        this.playerListHandler = new PlayerListHandler(gFW);
        this.gameMatchHandler = new GameMatchHandler(gFW);
        this.gameYourTurnHandler = new GameYourTurnHandler(gFW);
        this.gameMoveHanlder = new GameMoveHanlder(gFW);
        this.gameWinHandler = new GameWinHandler(gFW);
        this.gameLossHandler = new GameLossHandler(gFW);
        this.gameDrawHandler = new GameDrawHandler(gFW);
        this.gameChallengeHandler = new GameChallengeHandler(gFW);
        this.gameChallengeCancelledHandler = new GameChallengeCancelledHandler(gFW);

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
                System.out.println(message);
                handler.run(message);
            }
        }

        if (!messageFound){
            System.out.println("Message not found: " + message);
        }
    }
}

