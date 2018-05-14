package handler;

import model.GameFW;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameChallengeHandler extends ActionHandler{
    GameFW gFW;

    public GameChallengeHandler(GameFW gFW) {
        this.gFW = gFW;
    }

    public void run(String message){

        System.out.println("Running GAME CHALLENGE command handler");
        Pattern pattern = Pattern.compile("SVR GAME CHALLENGE \\{CHALLENGER: \"(.*?)\", CHALLENGENUMBER: \"(.*?)\", GAMETYPE: \"(.*?)\"\\}");
        Matcher matcher = pattern.matcher(message);

        String challenger = null;
        String gameType = null;
        String challengeNumber = null;

        if (matcher.find()){
            challenger = matcher.group(1);
            gameType = matcher.group(3);
            challengeNumber = matcher.group(2);
        }
        System.out.println(challenger + " has challenged you to a game of "+gameType+", the challenge number is "+challengeNumber);
        gFW.pageController().toChallengeChoicePage(challenger, gameType);
    }
}
