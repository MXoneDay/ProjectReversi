package model;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.CellPane;

public class Reversi implements Game {
	private final static int hor = 8, ver = 8;
	private ArrayList<int[]> toConvert;
	private int player;
	
	@Override
	public ImageView getImage(boolean turn) {
		Image img;
		if(turn){
			img = new Image("pictures/blackpiece.png",60, 60, false, false);
		}else{
			img = new Image("pictures/whitepiece.png",60, 60, false, false);
		}
		return new ImageView(img);
	}

	@Override
	public boolean isValid(boolean turn, CellPane cp, CellPane[][] board) {
		System.out.println("Move: " + cp.hor + "-" + cp.ver + " " + cp.filled);
		/*System.out.println(board.get(loc));
		//System.out.println("Base: " + board.get(loc).hor + board.get(loc).ver + loc);
		//System.out.println("Above: " + board.get(loc-hor).hor + board.get(loc-ver).ver + (loc-hor));
		//checkUp(loc, board);
		//board.get(loc).filled = 1;
		//System.out.println(board[cp.ver][cp.hor-8].filled);*/
		player = turn ? 1 : 2;
		toConvert = new ArrayList<int[]>();
		if(board[cp.ver][cp.hor].filled == 0) {
			try {
				checkUp(turn, cp, board);
			}
			catch(Exception ex) {}
			board[cp.ver][cp.hor].filled = turn ? 1 : 2;
			return true;
		}
		return false;
	}
	
	public void check(CellPane cp, CellPane[][] board, int v, int h) throws Exception {
		int round = 0;
		
		while(true) {
			if(board[cp.ver-v][cp.hor-h].filled == player) {
				toConvert.add(new int[] {cp.ver-v, cp.hor-h});
			}
		}
	}
	
	public void checkUp(boolean turn, CellPane cp, CellPane[][] board) throws Exception {
		int round = 0;
		while(true) {
			if(board[cp.ver-round][cp.hor].filled == player) {
				toConvert.add(new int[] {cp.ver-round, cp.hor});
			}
			if(board[cp.ver+round][cp.hor].filled == player) {
				toConvert.add(new int[] {cp.ver-round, cp.hor});
			}
			if(board[cp.ver][cp.hor-round].filled == player) {
				toConvert.add(new int[] {cp.ver, cp.hor-round});
			}
			if(board[cp.ver][cp.hor+round].filled == player) {
				toConvert.add(new int[] {cp.ver-round, cp.hor});
			}
				
			if(board[cp.ver-round][cp.hor+1].filled == player) {
				toConvert.add(new int[] {cp.ver-round, cp.hor});
			}
			if(board[cp.ver-round][cp.hor-1].filled == player) {
				toConvert.add(new int[] {cp.ver-round, cp.hor});
			}
			if(board[cp.ver+round][cp.hor+1].filled == player) {
				toConvert.add(new int[] {cp.ver-round, cp.hor});
			}
			if(board[cp.ver+round][cp.hor-1].filled == player) {
				toConvert.add(new int[] {cp.ver-round, cp.hor});
			}
				
			//System.out.println(cp.hor-round + " " + cp.ver);
			round++;
			for(int[] s : toConvert) {
				System.out.println(Arrays.toString(s));
			}
		}
	}
	
	public void check(CellPane cp, CellPane[][] board, int round, ArrayList<int[]> convert, int player) {
		if(board[cp.ver-round][cp.hor].filled == player) {
			convert.add(new int[] {cp.ver-round, cp.hor});
		}
	}

	@Override
	public void createAI() {
	}
	
	@Override
	public int getHor() {
		return hor;
	}

	@Override
	public int getVer() {
		return ver;
	}

}

