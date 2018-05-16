package model;

import view.CellPane;

public interface AI {
    public CellPane[] possibleMoves();
    public CellPane getRandomMove();
    public void doMove();
}