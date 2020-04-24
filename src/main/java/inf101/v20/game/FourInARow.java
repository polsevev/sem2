package inf101.v20.game;

import inf101.v20.lab4.grid.Grid;
import inf101.v20.objects.Ai;
import inf101.v20.objects.IObjects;
import inf101.v20.objects.Player;

import java.util.Scanner;

public class FourInARow implements IGame {

    static final int WIDTH = 7;
    static final int HEIGHT = 6;


    //to keep track of whose turn it is
    public boolean player1Turn = true;

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
        //loops over as long as there is no winner and no tie
        boolean gameOver = false;
        while (!gameOver){
            //checks for tie
            if(checkTie(grid)){
                System.out.println("Game ended in a tie");
                gameOver = true;
                continue;
            }
            if(player1Turn){
                playerTurn(grid, player1);
                //checks for win
                boolean won = checkWin(grid, player1);
                //if win game ends
                if(won){
                    System.out.println("Congratulations " + player1.getName() + " has won!");
                    gameOver = true;
                }
                //checks if player made a move, if not its the same players turn again
                if(player1.madeMove)
                    player1Turn = false;
            }else{
                //same as above just for player 2
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
            //check if its a tie
            if(checkTie(grid)){
                System.out.println("Game ended in a tie");
                gameOver = true;
                continue;
            }
            //does ai or players turn based on previous turn
            if(player1Turn){
                playerTurn(grid, player1);
                //checks win
                boolean won = checkWin(grid, player1);
                //game ends if win state has been reached
                if(won){
                    System.out.println("Congratulations " + player1.getName() + " has won!");
                    gameOver = true;
                }
                //checks if player made a move
                if(player1.madeMove)
                    player1Turn = false;
            }else{
                ai.makeMoveFourInARow(grid);
                //checks for win
                boolean won = checkWin(grid, ai);
                //game over if win
                if(won){
                    System.out.println("Ai has won");
                    gameOver = true;
                }
                //other players turn
                player1Turn = true;
            }
        }
    }

    @Override
    public void playerTurn(Grid grid, Player player) {
        Scanner userIN = new Scanner(System.in);
        System.out.println("Current board:");
        grid.gridOut();

        //check for wrong inputs
        int column;
        do{
            System.out.println("Please choose column for " + player.getName());
            while (!userIN.hasNextInt()){
                System.out.println("That is not an integer you silly dog");
                userIN.next();
            }
            column = userIN.nextInt();
        }while(column <= 0 || column >7);

        column = column- 1;
        player.makeMoveFourInARow(grid, column);
    }


    @Override
    public boolean checkWin(Grid grid, IObjects currentPlayer) {

        String playerSymbol = currentPlayer.getSymbol();


        //check vertical
        for (int Y = 0; Y < grid.getHeight()-3; Y++) {
            for (int X = 0; X < grid.getWidth(); X++) {
                if(grid.get(X, Y) == playerSymbol && grid.get(X, Y +1)== playerSymbol  && grid.get(X, Y+2) == playerSymbol && grid.get(X, Y+3) == playerSymbol)
                    return true;
            }
        }

        //check horizontal

        for (int X = 0; X < grid.getWidth()-3; X++) {
            for (int Y = 0; Y < grid.getHeight(); Y++) {
                if(grid.get(X, Y) == playerSymbol && grid.get(X+1, Y )== playerSymbol  && grid.get(X+2, Y) == playerSymbol && grid.get(X+3, Y) == playerSymbol)
                    return true;
            }

        }

        //Descending diagonal
        for (int X = 3; X < grid.getWidth(); X++) {
            for (int Y = 3; Y < grid.getHeight(); Y++) {
                if(grid.get(X, Y) == playerSymbol && grid.get(X-1, Y-1 )== playerSymbol  && grid.get(X-2, Y-2) == playerSymbol && grid.get(X-3, Y-3) == playerSymbol)
                    return true;
            }
        }

        //ascending diagonal
        for (int i = 3; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight()-3; j++) {
                if(grid.get(i, j) == playerSymbol && grid.get(i-1, j+1 )== playerSymbol  && grid.get(i-2, j+2) == playerSymbol && grid.get(i-3, j+3) == playerSymbol)
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkTie(Grid grid) {
        //tie check
        for (int X = 0; X < grid.getWidth(); X++) {
            for (int Y = 0; Y < grid.getHeight(); Y++) {
                if(grid.get(X, Y) == grid.getEmptySymbol())
                    return false;
            }
        }
        return true;
    }

}
