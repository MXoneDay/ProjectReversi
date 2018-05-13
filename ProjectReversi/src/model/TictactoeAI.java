package model;

import view.CellPane;

import java.util.Arrays;
import java.util.Random;

public class TictactoeAI implements AI {
	private Tictactoe ttt;
	private Board board;
	private Random rand = new Random();
	private int[] validMoves = new int[9];
	public boolean waitForMove;
	int turn;
	int hor;
	int ver;
	int loc;


	TictactoeAI(Tictactoe ttt) {
		this.ttt = ttt;
	}

	// Te doen goede aanroep / implementatie van de variablen
	// --> getValidMoves loopt door het bord heen alle vakjes worden dus in het bord gezet tenzij deze al bezet is dan wordt deze niet toe gevoegd
	// --> GetRandomMove is een werkende functie deze pakt een int uit de array willekeurig en plaats deze
	// --> huidige plaatsings probleem is we zitten met Loc maar ook met hor en ver
	// --> TryMove komt uit de game zelf de AI moet mee krijgen welke speler hij is zodat deze een int uit de array kan plaatsen
	}

	public int[] getValidMoves() {

		for (int i = 0; i < board ; i++) {
			if(ttt.isValid(turn, hor, ver, board)) {
				if (board.checkFilled(hor, ver) = false) { // check filled is nog geen goede functie
					Arrays.fill(validMoves, i);
				}
			}
			return validMoves;
		}
	}

	// Picks a random int from the possible moves
	public int getRandomMove(){
		int[] validMoves = getValidMoves();
		int randomMove = rand.nextInt(validMoves.length);
		return validMoves[randomMove];
	}

	// Tries to place the random move by waiting for its turn
	public void tryMove(int hor, int ver) {
			if(waitForMove) {
				return move(hor, ver);
			}else if(!waitForMove) {
				return move(hor, ver);
			}
	}
}

/* First attempt to loop throught the board
		for (int i = 0; i < ttt.getVer(); i++) {
			for (int j = 0; j < ttt.getHor(); j++) {
				if (ttt.isValid(turn, j, i, board)) {
					CellPane cp = board.getCell(ttt.getHor(), ttt.getVer()); // hor en ver
					cp.filled = turn;
					loc++;
				}
			}
			return validMoves[];
		}
 */