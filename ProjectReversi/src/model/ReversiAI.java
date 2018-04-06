package model;

public class ReversiAI implements AI {
	Reversi rev;
	
	ReversiAI(Reversi rev){
		this.rev = rev;
		System.out.println(rev.getVer());
	}
}
