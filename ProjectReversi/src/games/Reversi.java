package games;

import design.GridFrame;
import main.Main;
import javafx.scene.layout.*;

public class Reversi {
	private static int hor = 8, ver = 8;
	
	public static GridPane setup() {
		System.out.println("Rev: " + Main.usernm + " : " + Main.mode);
		// midden wit zwart, daaronder zwart wit
		return new GridFrame().start(hor, ver);
	}
	
	public static void check(int hor, int ver) {
		System.out.println("reversi: " + hor + ver);
		// check if the move is valid
		// check if move is within board
		if(hor > Reversi.hor) {
			
		}
		if(ver > Reversi.ver) {
			
		}
		
		// controleren of de plek leeg is 
		// controleren of de ander ernaast zit
		// controleren of diagonaal of horizontaal of verticaal iets van jou zit
	}
}
