

import inf101.v20.game.FourInARow;
import inf101.v20.lab4.grid.Grid;
import inf101.v20.objects.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourInARowTest {
    @Test
    public void checkWinTest() {
        FourInARow fourInARow = new FourInARow();
        Player player1 = new Player("X", "playerName");
        Player player2 = new Player("O", "playerName");
        Grid grid = new Grid(7, 6, "*");

        //vertical win
        for (int i = 0; i < 4; i++) {
            player1.makeMoveFourInARow(grid, 1);
        }
        assertEquals(true, fourInARow.checkWin(grid, player1));

        //horizontal win
        grid = new Grid(7, 6, "*");
        for (int i = 0; i < 4; i++) {
            player1.makeMoveFourInARow(grid, i);
        }
        assertEquals(true, fourInARow.checkWin(grid, player1));

        //diagonal to the right win
        grid = new Grid(7, 6, "*");
        for (int i = 0; i < 2; i++) {
            player1.makeMoveFourInARow(grid, 0);
            player2.makeMoveFourInARow(grid, 0);
        }
        player1.makeMoveFourInARow(grid, 2);
        player2.makeMoveFourInARow(grid, 2);
        player1.makeMoveFourInARow(grid, 1);
        player2.makeMoveFourInARow(grid, 3);
        player1.makeMoveFourInARow(grid, 1);
        player2.makeMoveFourInARow(grid, 1);
        assertEquals(true, fourInARow.checkWin(grid, player2));

        //diagonal to the left win
        grid = new Grid(7, 6, "*");
        for (int i = 0; i < 2; i++) {
            player1.makeMoveFourInARow(grid, 3);
            player2.makeMoveFourInARow(grid, 3);
        }
        player1.makeMoveFourInARow(grid, 1);
        player2.makeMoveFourInARow(grid, 1);
        player1.makeMoveFourInARow(grid, 2);
        player2.makeMoveFourInARow(grid, 0);
        player1.makeMoveFourInARow(grid, 2);
        player2.makeMoveFourInARow(grid, 2);
        grid.gridOut();
        assertEquals(true, fourInARow.checkWin(grid, player2));
    }
}
