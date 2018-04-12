package model;


import java.util.ArrayList;

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
}
