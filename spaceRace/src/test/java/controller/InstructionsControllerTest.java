package controller;

import Classes.Game;
import State.InstructionsState;
import gui.GUI;
import gui.LanternaGUI;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.io.IOException;

public class InstructionsControllerTest {
    InstructionsController instructionsController;
    InstructionsState instructionsState;

    @BeforeEach
    void setUp() throws IOException {
        Game game = Mockito.mock(Game.class);
        Mockito.when(game.getHeight()).thenReturn(1);
        Mockito.when(game.getWidth()).thenReturn(1);
        GUI gui = Mockito.mock(LanternaGUI.class);
        this.instructionsState = new InstructionsState(game, gui);
        this.instructionsController = new InstructionsController(instructionsState,gui);
    }
}
