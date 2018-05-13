package model;

public class CommandDispatcher {
    Connection connection;
    public CommandDispatcher(Connection connection){
        this.connection = connection;
    }

    public void login(String username){
        System.out.println(username);
        connection.send("login "+username);
    }

    public void subscribe(String game){
        connection.send("subscribe "+game);
    }

    public void move(Integer position){
        connection.send("move "+position);
    }

    public void disconnect(){
        connection.send("exit");
    }

    public void getPlayers(){
        connection.send("get playerlist");
    }

    public void challenge(String username, String game){
        System.out.println(("challenge " + '"'+username+ "\" " + '"'+game+'"'));
        connection.send("challenge " + '"'+username+ "\" " + '"'+game+'"');
    }
}
