package inf101.v20.objects;

import inf101.v20.lab4.grid.Grid;
import inf101.v20.game.TicTac;

import java.util.Random;

public class Ai implements IAi {
    public String SYMBOL = " ";
    public String name = "";

    public Ai(String symbol, String name){
        this.name = name;
        SYMBOL = symbol;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean legalMoveTicTac(Grid grid, int X, int Y) {
        if(grid.get(X, Y) == grid.getEmptySymbol())
            return true;
        return false;
    }

    @Override
    public void makeMoveTicTac(Grid grid, TicTac ticTac, IObjects player1) {
        int[] move = bestMove(grid, ticTac, player1);
        grid.set(move[0], move[1], this.getSymbol());
    }

    @Override
    public int[] bestMove(Grid grid, TicTac ticTac, IObjects player1) {
        double bestScore = Double.NEGATIVE_INFINITY;
        int[] move = new int[2];
        for (int X = 0; X < grid.getWidth(); X++) {
            for (int Y = 0; Y < grid.getWidth(); Y++) {
                if(legalMoveTicTac(grid, X, Y)){
                    grid.set(X, Y, this.getSymbol());
                    double score = miniMax(grid, 0, false, ticTac, player1);
                    grid.set(X, Y, grid.getEmptySymbol());
                    if(score > bestScore){
                        bestScore = score;
                        move[0] = X;
                        move[1] = Y;
                    }
                }
            }
        }
        return move;
    }

    @Override
    public int miniMax(Grid grid, int depth, boolean isMaximising, TicTac ticTac, IObjects player1) {


        if(ticTac.checkWin(grid, this)){
            return 1;
        }else if(ticTac.checkWin(grid, player1)){
            return -1;
        }else if(ticTac.checkTie(grid)){
            return 0;
        }
        if(isMaximising){
            double bestScore = Double.NEGATIVE_INFINITY;
            for (int X = 0; X < grid.getWidth(); X++) {
                for (int Y = 0; Y < grid.getHeight(); Y++) {
                    if(legalMoveTicTac(grid, X, Y)){
                        grid.set(X, Y, this.getSymbol());
                        int score = miniMax(grid, depth +1, false, ticTac, player1);
                        grid.set(X, Y, grid.getEmptySymbol());
                        if(score > bestScore){
                            bestScore = score;
                        }
                    }
                }

            }
            return (int) bestScore;
        }else{
            double bestScore = Double.POSITIVE_INFINITY;
            for (int X = 0; X < grid.getWidth(); X++) {
                for (int Y = 0; Y < grid.getHeight(); Y++) {
                    if(legalMoveTicTac(grid, X, Y)){
                        grid.set(X, Y, "X");
                        int score = miniMax(grid, depth +1, true, ticTac, player1);
                        grid.set(X, Y, grid.getEmptySymbol());
                        if(score < bestScore){
                            bestScore = score;
                        }
                    }
                }

            }return (int) bestScore;
        }
    }

    @Override
    public void makeMoveFourInARow(Grid grid) {
        Random random = new Random();
        int X = random.nextInt(7);
        int yPos = checkLowestY(grid, X);
        if(yPos < 0){
            makeMoveFourInARow(grid);
        }else{
            grid.set(X, yPos, this.getSymbol());
        }
    }

    @Override
    public int checkLowestY(Grid grid, int X) {
        int getBottomYPos = -1;
        for (int Y = 0; Y < grid.getHeight(); Y++) {
            if(grid.get(X, Y) == grid.getEmptySymbol())
                getBottomYPos = Y;
        }
        return getBottomYPos;
    }


}
