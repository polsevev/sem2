package inf101.v20.objects;

import inf101.v20.game.TicTac;
import inf101.v20.lab4.grid.Grid;

public interface IAi extends IObjects {

    /**
     * Finds the best possible move using miniMax
     * @param grid
     * @param ticTac
     * @param player1
     * @return
     * returns the move in an array. X is the 0 element and Y is 1.
     */
    int[] bestMove(Grid grid, TicTac ticTac, IObjects player1);

    /**
     * calls the bestMove method and places symbol in the best possible place based on bestMove
     * @param grid
     * @param ticTac
     * @param player1
     */
    void makeMoveTicTac(Grid grid, TicTac ticTac, IObjects player1);

    /**
     * Uses recursion to check all possible outcomes from a given move. returns the score of the current move based
     * on if it is a wining, losing og tieing move.
     * @param grid
     * @param depth
     * @param isMaximising
     * @param ticTac
     * @param player1
     * @return
     * either 1 for winning, -1 for losing and 0 for tieing.
     */
    int miniMax(Grid grid, int depth, boolean isMaximising, TicTac ticTac, IObjects player1);


    /**
     * chooses a random column, if it is not available it chooses again until it finds an available one. .
     * @param grid
     */
    void makeMoveFourInARow(Grid grid);


}
