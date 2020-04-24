package inf101.v20.game;

import inf101.v20.lab4.grid.Grid;
import inf101.v20.objects.Ai;
import inf101.v20.objects.Player;

import java.util.Scanner;

public class GameStart implements IGameStart {

    @Override
    public void start() {
        IGameFactory gameFactory = new GameFactory();

        Scanner userIn = new Scanner(System.in);

        int gameChoice;
        //checking for wrong inputs
        do{
            System.out.println("Choose game, 1 for TicTac and 2 for Four in a row");
            while (!userIn.hasNextInt()){
                System.out.println("That's not a number, please choose either 1 or 2");
                userIn.next();
            }
            gameChoice = userIn.nextInt();
        }while (gameChoice <= 0 || gameChoice >2);


        IGame game = gameFactory.chooseGame(gameChoice);

        //choose vs player or computer
        Scanner userIN = new Scanner(System.in);
        Grid grid = new Grid<>(game.getWidth(), game.getHeight(), "*");


        int numberOfPlayer;
        do{
            System.out.println("2 player or one player? (1 for 1 player, 2 for 2 player)");
            while(!userIN.hasNextInt()){
                System.out.println("That's not a number, please choose either 1 or 2 players");
                userIN.next();
            }
            numberOfPlayer = userIN.nextInt();
        }while(numberOfPlayer <= 0 || numberOfPlayer >2);

        //setup for player one
        Scanner userIN1 = new Scanner(System.in);
        System.out.println("Player 1 please choose name");
        String player1Name = userIN1.nextLine();
        Player player1 = new Player("X", player1Name);

        if(numberOfPlayer == 2){
            //setup for player 2
            System.out.println("Player 2 please choose name");
            String player2Name = userIN1.nextLine();
            Player player2 = new Player("O", player2Name);
            game.playMultiplayer(player1, player2, grid);
        }else if(numberOfPlayer == 1){
            //setup for AI
            System.out.println("Please choose Ai name");
            String aiName = userIN1.nextLine();
            Ai ai = new Ai("O", aiName);
            game.playSingleplayer(player1, ai, grid);
        }


    }


}
