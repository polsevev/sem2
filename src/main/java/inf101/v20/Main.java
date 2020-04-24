package inf101.v20;

import inf101.v20.game.GameFactory;
import inf101.v20.game.GameStart;
import inf101.v20.game.IGameStart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IGameStart gameStart = new GameStart();
        gameStart.start();

    }

}
