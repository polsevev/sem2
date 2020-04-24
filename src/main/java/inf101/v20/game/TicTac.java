package inf101.v20.game;
import inf101.v20.lab4.grid.Grid;
import inf101.v20.objects.Ai;
import inf101.v20.objects.IObjects;
import inf101.v20.objects.Player;
import java.util.Scanner;

public class TicTac implements IGame {

    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;


    private boolean player1Turn = true;


    //winConditions for ticTacToe
     public static int[][][] winCordinates= {
            {
                    {0, 0}, {1, 1},{2, 2}
            },{
            {0, 0}, {1, 0}, {2, 0}
    },{
            {0, 0}, {0, 1}, {0, 2}
    },{
            {0, 1}, {1, 1}, {2, 1}
    },{
            {0, 2}, {1, 2}, {2, 2}
    },{
            {2, 0}, {2, 1}, {2,2}
    },{
            {1, 0}, {1, 1}, {1, 2}
    },{
            {2, 0}, {1, 1}, {0, 2}
    }
    };


    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public void playMultiplayer(Player player1, Player player2, Grid grid) {
        boolean gameOver = false;
        while (!gameOver){
            if(checkTie(grid)){
                System.out.println("Game ended in a tie");
                gameOver = true;
                continue;
            }
            if(player1Turn){
                playerTurn(grid, player1);
                boolean won = checkWin(grid, player1);
                if(won){
                    System.out.println("Congratulations " + player1.getName() + " has won!");
                    gameOver = true;
                }
                if(player1.madeMove)
                    player1Turn = false;
            }else{
                playerTurn(grid, player2);
                boolean won = checkWin(grid, player2);
                if(won){
                    System.out.println("Congratulations " + player2.getName() + " has won!");
                    gameOver = true;
                }
                if(player2.madeMove)
                    player1Turn = true;
            }
        }

    }

    @Override
    public void playSingleplayer(Player player1, Ai ai, Grid grid) {
        boolean gameOver = false;
        while (!gameOver){
            if(checkTie(grid)){
                System.out.println("Game ended in a tie");
                gameOver = true;
                continue;
            }

            if(player1Turn){
                playerTurn(grid, player1);
                boolean won = checkWin(grid, player1);
                if(won){
                    System.out.println("Congratulations " + player1.getName() + " has won!");
                    gameOver = true;
                }
                if(player1.madeMove)
                    player1Turn = false;
            }
            else{
                ai.makeMoveTicTac(grid, this, player1);
                boolean won = checkWin(grid, ai);
                if(won){
                    System.out.println("Ai has won");
                    gameOver = true;
                }
                player1Turn = true;
            }
        }
    }

    @Override
    public boolean checkWin(Grid grid, IObjects actor) {
        for (int i = 0; i < winCordinates.length; i++) {
            int[][] cordinatesToCheck = winCordinates[i];
            boolean currentRowWin = true;
            for (int j = 0; j < cordinatesToCheck.length; j++) {
                if(grid.get(cordinatesToCheck[j][0], cordinatesToCheck[j][1]) != actor.getSymbol())
                    currentRowWin = false;
            }
            if(currentRowWin)
                return true;

        }
        return false;
    }

    @Override
    public void playerTurn(Grid grid, Player player) {
        Scanner userIN = new Scanner(System.in);
        System.out.println("Current board:");
        grid.gridOut();

        //check for wrong inputs
        int userX;
        int userY;
        do{
            System.out.println("Please choose cordinate for " + player.getName());
            while (!userIN.hasNextInt()){
                System.out.println("That is not an integer, please only input integers you silly dog");
                userIN.next();
            }
            userX = userIN.nextInt();
            while (!userIN.hasNextInt()){
                System.out.println("Something is wrong with your Y cordinate, please choose another");
                System.out.println("You only need to write the Y cordinate here to fix your mistake: ");
                userIN.next();
            }
            userY = userIN.nextInt();
        }while(userX <= 0 || userX >3 || userY <= 0 || userY >3);
        userX = userX- 1;
        userY = userY- 1;
        player.makeMoveTicTac(grid, userX, userY);
    }

    @Override
    public boolean checkTie(Grid grid) {
        //checks for open cells in grid
        for (int X = 0; X < grid.getWidth(); X++) {
            for (int Y = 0; Y < grid.getHeight(); Y++) {
                if(grid.get(X, Y) == grid.getEmptySymbol())
                    return false;
            }
        }
        return true;
    }

}
