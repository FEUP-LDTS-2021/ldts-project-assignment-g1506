package state;

import Classes.Game;
import State.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;


public class StateTest {
    private State state;
    private Game game;

    @BeforeEach
    void build() {
        this.game = Mockito.mock(Game.class);
        this.state = Mockito.mock(State.class);
        Mockito.when(state.getGame()).thenReturn(game);
    }

    @Test
    void changeStateTest() {

        State newState = new State(game) {
            @Override
            public void start() {}

            @Override
            public void step(Game game, long time) throws IOException {}
        };
        newState.changeState(state);

        Mockito.verify(game,Mockito.times(1)).setGameState(state);
    }

    @Test
    void GetGameTest() {
        Game newGame = state.getGame();
        Assertions.assertEquals(newGame, game);
    }
}
