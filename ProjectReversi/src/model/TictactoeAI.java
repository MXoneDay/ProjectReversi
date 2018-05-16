package model;

import view.CellPane;

import java.util.ArrayList;
import java.util.Random;

public class TictactoeAI implements AI {
	private GameFW fw;
	private Tictactoe ttt;
	private String name;
	private ArrayList<CellPane> validMoves = new ArrayList<CellPane>();
	private Random rand = new Random();
	private int turn;

	TictactoeAI(GameFW gFW, Tictactoe ttt){
		this.fw = gFW;
		this.ttt = ttt;
		System.out.println("made it");
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setTurn(int turn) {
		this.turn = turn;
		System.out.println("turn: " + turn);
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
	public void possibleMoves() {
		for (int i = 0; i < fw.getVer(); i++) {
			for (int j = 0; j < fw.getHor(); j++) {
				if (ttt.isValid(fw.getUsers(), turn, i, j, fw.getBoard(), true)) {
					validMoves.add(fw.getBoard().getCell(i, j));
				}
			}
		}
	}

	// Picks a random int from the possible moves
	public CellPane getRandomMove(){
		validMoves = new ArrayList<CellPane>();
		possibleMoves();
		int randomMove = rand.nextInt(validMoves.size() -  1);
		return validMoves.get(randomMove);
	}

	public void doMove() {
		CellPane move = getRandomMove();
		int hor = move.hor ;
		int ver = move.ver ;
		fw.move(hor, ver, this);
	}
}
