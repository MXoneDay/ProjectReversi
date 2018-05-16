package model;

import java.util.ArrayList;
import view.CellPane;

public interface AI extends User{
    public void possibleMoves();
    public CellPane getRandomMove();
    public void doMove();
    public void setName(String name);
}