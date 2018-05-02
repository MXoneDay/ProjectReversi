package model;

public class Player {
    boolean isTurn = false;
    String image;
    String username;

    public Player(String username){
        this.username = username;
    }
    public void setTurn(){
        this.isTurn = true;
    }

     public void endTurn(){
        this.isTurn = false;
     }

     public void setImage(String image){
        this.image = image;
     }

    public String getUsername() {
        return username;
    }
}
