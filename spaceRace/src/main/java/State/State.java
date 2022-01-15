package State;

import Classes.Game;

import java.io.IOException;

public abstract class State {
    protected final Game game;

    public State(Game game){
        this.game = game;
    }

    public abstract void start();

    public abstract void step(Game game, long time) throws IOException;

    public void changeState(State state1) {this.game.setGameState(state1);}

}
