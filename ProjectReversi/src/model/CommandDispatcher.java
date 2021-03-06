package model;

public class CommandDispatcher {
    Connection connection;
    public CommandDispatcher(Connection connection){
        this.connection = connection;
    }

    public void login(String username){
        connection.send("login "+username);
    }

    public void subscribe(String game){
        connection.send("subscribe "+game);
    }

    public void move(Integer position){
        connection.send("move "+position);
    }

    public void disconnect(){
        connection.send("disconnect");
    }

    public void getPlayers(){
        connection.send("get playerlist");
    }

    public void challenge(String username, String game){
        connection.send("challenge " + '"'+username+ "\" " + '"'+game+'"');
    }

    public void acceptChallenge(String challengeNumber){
        connection.send("challenge accept "+challengeNumber);
    }
}
