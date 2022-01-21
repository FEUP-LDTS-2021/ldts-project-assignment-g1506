package state;

import Classes.Game;
import State.InstructionsState;
import controller.InstructionsController;
import gui.GUI;
import gui.KeyBoardObserver;
import gui.LanternaGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class InstructionsStateTest {
    private InstructionsState state;
    private Game game;
    private GUI gui;
    private InstructionsController instructionsController;
    private KeyBoardObserver keyBoardObserver;

    @BeforeEach
    void build() throws IOException {
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(LanternaGUI.class);
        this.keyBoardObserver = Mockito.mock(KeyBoardObserver.class);

        this.state = new InstructionsState(game, gui);
        this.instructionsController = Mockito.mock(InstructionsController.class);
        this.state.setInstructionsController(instructionsController);

        Mockito.when(game.getKeyBoardObserver()).thenReturn(keyBoardObserver);
    }


    @Test
    void testStart() {
        state.start();

        Mockito.verify(keyBoardObserver, Mockito.times(1)).setListener(instructionsController);
    }

    @Test
    void testStep() throws IOException {
        state.step(game, 10);

        Mockito.verify(instructionsController, Mockito.times(1)).step();
    }

    @Test
    void testGetInstructionsController() {
        InstructionsController newInstructionsController = state.getInstructionsController();

        Assertions.assertEquals(newInstructionsController, instructionsController);
    }

    @Test
    void testSetInstructionsController() {
        InstructionsController newInstructionsController = new InstructionsController(state, gui);
        state.setInstructionsController(newInstructionsController);

        Assertions.assertEquals(state.getInstructionsController(), newInstructionsController);
    }
}