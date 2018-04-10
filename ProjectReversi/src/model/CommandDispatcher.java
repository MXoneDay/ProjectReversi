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
}
