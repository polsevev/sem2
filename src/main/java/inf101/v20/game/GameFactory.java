package inf101.v20.game;

import java.util.Scanner;

public class GameFactory implements IGameFactory{

    @Override
    public IGame chooseGame(int gameChoice) {
        if(gameChoice == 1){
            IGame ticTac = new TicTac();
            return ticTac;
        }else if(gameChoice == 2){
            IGame fourInARow = new FourInARow();
            return fourInARow;
        }
        return null;
    }
}
