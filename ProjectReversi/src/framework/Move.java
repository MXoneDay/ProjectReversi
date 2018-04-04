package framework;

import main.Main;
import games.*;

public class Move {
	
	public static void move(int hor, int ver) {
		
		if(Main.mode == 't') {
			Tictactoe.check(hor, ver);
			//tictactoe.CheckMove.check(hor, ver);
		}
		else if(Main.mode == 'r') {
			Reversi.check(hor, ver);
			//reversi.CheckMove.check(hor, ver);
		}
		else {
			// error
		}
		
		//op eigen bord doen
		
		//versturen naar de server
	}
}
