

import inf101.v20.game.TicTac;
import inf101.v20.lab4.grid.Grid;
import inf101.v20.objects.Ai;
import inf101.v20.objects.IObjects;
import inf101.v20.objects.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class AiTest {

    @Test
    public void makesWinningMoveTest() {
        String symbol = "O";
        String name = "aiName";
        Ai ai = new Ai(symbol, name);
        TicTac ticTac = new TicTac();
        IObjects player = new Player("X", "playerName");
        Grid grid = new Grid(3, 3, "*");
        grid.set(0, 0, ai.getSymbol());
        grid.set(0, 1, ai.getSymbol());
        ai.makeMoveTicTac(grid, ticTac, player);
        assertEquals(true, ticTac.checkWin(grid, ai));
    }

    @Test
    public void blocksWinningMoveTest() {
        String symbol = "O";
        String name = "aiName";
        Ai ai = new Ai(symbol, name);
        TicTac ticTac = new TicTac();
        IObjects player = new Player("X", "playerName");
        Grid<String> grid = new Grid<>(3, 3, "*");
        grid.set(0, 0, player.getSymbol());
        grid.set(0, 1, player.getSymbol());
        ai.makeMoveTicTac(grid, ticTac, player);
        assertEquals(grid.get(0, 2), ai.getSymbol());
    }

}
