package controller;

import Classes.Game;
import State.State;
import State.PlayState;
import gui.GUI;
import gui.LanternaGUI;
import model.Arena.Arena;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PlayControllerTest {
    PlayController playController;
    State playState;

    @BeforeEach
    void setUp(){
        Game game = Mockito.mock(Game.class);
        Mockito.when(game.getHeight()).thenReturn(1);
        Mockito.when(game.getWidth()).thenReturn(1);
        GUI gui = Mockito.mock(LanternaGUI.class);
        this.playState = new PlayState(game, gui);
        this.playController = new PlayController(playState, gui, new Arena());
    }


}
