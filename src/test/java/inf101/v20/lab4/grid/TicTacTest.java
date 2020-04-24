

import inf101.v20.game.TicTac;
import inf101.v20.lab4.grid.Grid;
import inf101.v20.objects.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacTest {
    @Test
    public void checkWinTest() {
        String symbol = "O";
        String name = "playerName";
        Player player = new Player(symbol, name);
        TicTac ticTac = new TicTac();
        Grid grid = new Grid(3, 3, "*");
        for (int currentWincondition = 0; currentWincondition < TicTac.winCordinates.length; currentWincondition++) {
            int[][] currentCordinates = TicTac.winCordinates[currentWincondition];
            for (int cordinate = 0; cordinate < currentCordinates.length; cordinate++) {
                grid.set(currentCordinates[cordinate][0], currentCordinates[cordinate][1], player.getSymbol());
            }
            assertEquals(true, ticTac.checkWin(grid, player));
            grid = new Grid(3, 3, "*");
        }
    }
    @Test
    public void checkTie(){
        //filling the board and checking for tie
        Grid grid = new Grid(3, 3, "*");
        TicTac ticTac = new TicTac();
        grid.set(0, 0, "X");
        grid.set(1, 0, "X");
        grid.set(2, 0, "O");
        grid.set(0, 1, "O");
        grid.set(1, 1, "O");
        grid.set(2, 1, "X");
        grid.set(0, 2, "X");
        grid.set(1, 2, "O");
        grid.set(2, 2, "X");
        assertEquals(true, ticTac.checkTie(grid));
    }
}
