package inf101.v20.game;

import inf101.v20.lab4.grid.Grid;
import inf101.v20.objects.Ai;
import inf101.v20.objects.IObjects;
import inf101.v20.objects.Player;

public interface IGame {

    int getWidth();
    int getHeight();

    /**
     * Does a turn when multiplayer mode is chosen. Alternates between players based on if a move was made
     * the previous turn, also checks for win after move and tie before new move.
     *
     * @param player1
     * instance of player1
     * @param player2
     * instance of player2
     * @param grid
     * the current grid
     */
    void playMultiplayer(Player player1, Player player2, Grid grid);

    /**
     *Singleplayer turn with AI, does the same as above but player 2 is swapped with instance of AI
     * @param player1
     * instance of player1
     * @param ai
     * instance of Ai
     * @param grid
     * current grid
     */
    void playSingleplayer(Player player1, Ai ai, Grid grid);


    /**
     * loops through a list of win conditions to check if a winner exists
     * @param grid
     * current grid
     * @return
     * returns the symbol of the winner, or null if there is no winner
     */
    public boolean checkWin(Grid grid, IObjects currentPlayer);

    /**
     * Takes input of the cell the player wants to place their symbol in
     * @param grid
     * current grid
     * @param player
     * the instance of player making the move
     */
    void playerTurn(Grid grid, Player player);

    /**
     * Checks if the board is full ( tie exists)
     * @param grid
     * @return
     * true if it is a tie, false if there is space on the board
     */
    boolean checkTie(Grid grid);

}
