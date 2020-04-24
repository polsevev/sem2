package inf101.v20.objects;

import inf101.v20.lab4.grid.Grid;


public class Player implements IPlayer {
    public String SYMBOL = " ";
    public String name;

    public boolean madeMove = true;

    public Player(String symbol, String name) {
        SYMBOL = symbol;
        this.name = name;
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
    public void makeMoveTicTac(Grid grid, int X, int Y) {
        if(legalMoveTicTac(grid, X, Y)){
            grid.set(X, Y, this.getSymbol());
            madeMove = true;
        }else{
            System.out.println("Please stay inside the grid and choose and empty cell");
            madeMove = false;
        }

    }


    @Override
    public boolean legalMoveTicTac(Grid grid, int X, int Y) {
        if(X < 0 || X >= grid.getWidth() || Y < 0 || Y >= grid.getHeight())
            return false;
        return grid.get(X, Y) == grid.getEmptySymbol();
    }

    @Override
    public void makeMoveFourInARow(Grid grid, int X) {
        //finds Y pos if available
        int yPos = checkLowestY(grid, X);
        if(yPos < 0){
            //changes madeMove to make sure a player isn't skipped
            System.out.println("Please choose a column with empty spaces");
            madeMove = false;
        }
        else{
            //makes the move the player wanted
            grid.set(X, yPos, this.getSymbol());
            madeMove = true;
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
