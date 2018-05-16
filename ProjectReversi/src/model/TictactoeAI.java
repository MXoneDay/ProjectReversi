package model;

import view.CellPane;
import java.util.Random;

public class TictactoeAI implements User, AI {
	GameFW fw;
	private Tictactoe ttt;
	private Board board;
	private String name;
	private CellPane[] validMoves = new CellPane[fw.getHor()*fw.getVer()];
	private Random rand = new Random();
	private int arrLoc = 0;
	private int turn;

	TictactoeAI(GameFW gFW, Tictactoe ttt){
		this.fw = gFW;
		this.ttt = ttt;
		System.out.println("made it");
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
	public String getName() {
		return name;
	}

	// Genarates a array with validMoves
	public CellPane[] possibleMoves() {
		for (int i = 0; i < fw.getVer(); i++) {
			for (int j = 0; j < fw.getHor(); j++) {
				if (ttt.isValid(fw.getUsers(), turn, j, i, board, false)) {
					validMoves[arrLoc] = board.getCell(j, i);
					arrLoc++;
				}
			}
		}
		return validMoves;
	}

	// Picks a random int from the possible moves
	public CellPane getRandomMove(){
		CellPane[] validMoves = possibleMoves();
		int randomMove = rand.nextInt(validMoves.length);
		return validMoves[randomMove];
	}

	public void doMove() {
		CellPane move = getRandomMove();
		int hor = move.hor ;
		int ver = move.ver ;
		fw.move(hor, ver, this);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
