package model;

import javafx.scene.image.ImageView;

public class Player {
	private String name;
	private ImageView iv;
	
	Player(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setImageView(ImageView iv) {
		this.iv = iv;
	}
	
	public ImageView getImageView() {
		return iv;
	}
}
