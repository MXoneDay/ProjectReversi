package games;

import main.Main;
import design.GridFrame;
import javafx.scene.layout.*;

public class Tictactoe {
	private static int hor = 3, ver = 3;
	private static int board[][] = new int[hor][ver];
	
	public static GridPane setup() {	
		System.out.println("TTT: " + Main.usernm + " : " + Main.mode);
		return new GridFrame().start(hor, ver);
	}
	
	public static void check(int hor, int ver) {
		System.out.println("tictactoe: " + hor + ver);
		// check if the move is valid
		if(hor <= Tictactoe.hor) {// check if move is within board
			if(ver <= Tictactoe.ver) {// check if move is within board
				if(board[hor][ver] == 0) {// controleren of de plek leeg is
					System.out.println(board[hor][ver]);
					// zet in board
				}
			}
		}
		//versturen
	}
}
