package inf101.v20.game;

interface IGameFactory {

    /**
     * So i am able to call the same object no matter what game the used chooses
     */
    public IGame chooseGame(int gameChoice);

}
