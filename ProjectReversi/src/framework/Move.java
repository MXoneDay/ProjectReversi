package framework;

import main.Main;

public class Move {
	
	public void move(int hor, int ver) {
		
		if(Main.mode == 't') {
			tictactoe.CheckMove.check(hor, ver);
		}
		else if(Main.mode == 'r') {
			reversi.CheckMove.check(hor, ver);
		}
		else {
			// error
		}
		
		//op eigen bord doen
		
		//versturen naar de server
	}
}
