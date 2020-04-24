package inf101.v20.objects;

import inf101.v20.lab4.grid.Grid;

public interface IPlayer extends IObjects {

    /**
     * Makes a move if legal, if not edits the variable made move to make the player doesn't skip a turn
     * if the cell is not available
     * @param grid
     * @param X
     * @param Y
     */
    void makeMoveTicTac(Grid grid, int X, int Y);


    /**
     * checks if the move is legal
     * @param grid
     * @param X
     * @param Y
     * @return true if legal move, false if not
     */
    boolean legalMoveTicTac(Grid grid, int X, int Y);

    /**
     * Uses checkLowestY to get Y position, if there is no Y position it changes madeMove to make sure player doesn't
     * skip a move. Else it changes the cell to the players symbol
     * @param grid
     * @param X
     */
    void makeMoveFourInARow(Grid grid, int X);



}
