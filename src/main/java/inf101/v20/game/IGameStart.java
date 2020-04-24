package inf101.v20.game;

import inf101.v20.objects.IObjects;

public interface IGameStart {

    /**
     * The function lets me use the same code for initial setup, due to both games letting the
     * user choose player name, and if they want to play against AI or another player.
     */
    void start();

}
