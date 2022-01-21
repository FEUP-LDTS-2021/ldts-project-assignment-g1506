package state;

import Classes.Game;
import State.PlayState;
import controller.ArenaController;
import controller.PlayController;
import gui.GUI;
import gui.KeyBoardObserver;
import gui.LanternaGUI;
import model.Arena.Arena;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class PlayStateTest {
    private PlayState state;
    private Game game;
    private GUI gui;
    private PlayController playController;
    private KeyBoardObserver keyBoardObserver;
    private ArenaController arenaController;

    @BeforeEach
    void build() throws IOException {
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(LanternaGUI.class);
        this.keyBoardObserver = Mockito.mock(KeyBoardObserver.class);
        this.playController = Mockito.mock(PlayController.class);
        this.arenaController = Mockito.mock(ArenaController.class);

        this.state = new PlayState(game, gui);
        this.state.setPlayController(playController);

        Mockito.when(game.getKeyBoardObserver()).thenReturn(keyBoardObserver);

        Mockito.when(playController.getArenaController()).thenReturn(arenaController);
    }

    @Test
    void testStart() {
        state.start();

        Mockito.verify(keyBoardObserver, Mockito.times(1)).setListener(playController);
    }

    @Test
    void testStep() throws IOException {
        state.step(game, 10);

        Mockito.verify(playController, Mockito.times(1)).step(game, 10);
    }

    @Test
    void testGetPlayController() {
        PlayController newPlayingController = state.getPlayController();

        Assertions.assertEquals(newPlayingController, playController);
    }

    @Test
    void testSetPlayController() {
        PlayController newPlayingController = new PlayController(state, gui, Mockito.mock(Arena.class));
        state.setPlayController(newPlayingController);

        Assertions.assertEquals(state.getPlayController(), newPlayingController);
    }
    
}
