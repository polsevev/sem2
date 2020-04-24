
import inf101.v20.game.TicTac;
import inf101.v20.lab4.grid.Grid;
import inf101.v20.objects.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class PlayerTest {


    @Test
    public void getTest() {
        String symbol = "O";
        String name = "playerName";
        Player player = new Player(symbol, name);
        assertEquals(symbol, player.getSymbol());
        assertEquals(name, player.getName());
    }

    @Test
    public void legalMoveTest() {
        String symbol = "O";
        String name = "playerName";
        Grid grid = new Grid(2, 2, "*");
        Player player = new Player(symbol, name);
        grid.set(0, 0, player.getSymbol());
        assertEquals(false, player.legalMoveTicTac(grid, 0, 0));
        assertEquals(true, player.legalMoveTicTac(grid, 1, 1));

    }

    @Test
    public void checkWinTest() {
        String symbol = "O";
        String name = "playerName";
        Player player = new Player(symbol, name);
        TicTac ticTac = new TicTac();
        Grid grid = new Grid(3, 3, "*");

        for (int i = 0; i < TicTac.winCordinates.length; i++) {
            int[][] currentLine = TicTac.winCordinates[i];
            for (int j = 0; j < 3; j++) {
                grid.set(currentLine[j][0], currentLine[j][1], player.getSymbol());
            }
            assertEquals(true, ticTac.checkWin(grid, player));
            grid = new Grid(3, 3, "*");
        }

    }

    @Test
    public void makeMoveTest() {
        String symbol = "O";
        String name = "playerName";
        Grid grid = new Grid(3, 3, "*");
        Player player = new Player(symbol, name);
        player.makeMoveTicTac(grid, 1, 1);
        assertEquals(grid.get(1, 1), player.getSymbol());
        assertEquals(true, player.madeMove);
        player.makeMoveTicTac(grid, -1, -1);
        assertEquals(false, player.madeMove);


    }
}
