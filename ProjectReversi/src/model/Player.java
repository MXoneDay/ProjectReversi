package model;

public class Player {
	private String name;
	private int turn;
	
	Player(String name){
		this.name = name;
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public String getName(){
		return name;
	}
	
	/*
	public String getPiece() {
		return img.split(".")[0];
	}
	
	public void setImageView(String loc) {
		img = loc.split("-")[0];
		size = Integer.parseInt(loc.split("-")[1]);

	}
	
	public ImageView getImageView() {
		return new ImageView(new Image(img, size, size, true, true));
	}*/
}
