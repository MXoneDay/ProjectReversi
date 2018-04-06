package model;

public interface Game {
	public int getHor();
	public int getVer();
	public void move(int hor, int ver);
	public void createAI();
}
