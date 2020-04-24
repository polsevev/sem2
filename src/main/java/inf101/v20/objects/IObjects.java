package inf101.v20.objects;

import inf101.v20.lab4.grid.Grid;

public interface IObjects {
    /**
     * returns name of Object (either name of player og name of AI)
     * @return
     */
    String getName();

    /**
     * returns the symbol of the given object
     * @return
     */
    String getSymbol();


    /**
     * checks if cordinates X,Y are a free cell or not, also checks for outOfBounds
     * @param grid
     * @param X
     * @param Y
     * @return
     * returns true if the move is legal
     */
    public boolean legalMoveTicTac(Grid grid, int X, int Y);

    /**
     * Finds the lowest Y position to simulate gravity. Returns -1 if the column is full
     * @param grid
     * @param X
     * @return
     * -1 if it is not legal or the lowest Y position for a given column.
     */
    int checkLowestY(Grid grid, int X);
}
