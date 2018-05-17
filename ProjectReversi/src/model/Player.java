package model;

public class Player implements User {
	private String name;
	private int turn;
	
	Player(String name){
		this.name = name;
	}
	
	@Override
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	@Override
	public int getTurn() {
		return turn;
	}
	
	@Override
	public String getName(){
		return name;
	}
}
