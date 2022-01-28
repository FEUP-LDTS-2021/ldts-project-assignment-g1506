package controller;

import Classes.Game;
import State.MenuState;
import gui.GUI;
import gui.LanternaGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControllerTest {
    MenuController menuController;
    MenuState menuState;

    @BeforeEach
    void setUp() throws IOException {
        Game game = Mockito.mock(Game.class);
        Mockito.when(game.getHeight()).thenReturn(1);
        Mockito.when(game.getWidth()).thenReturn(1);
        GUI gui = Mockito.mock(LanternaGUI.class);
        this.menuState = new MenuState(game, gui);
        this.menuController = new MenuController(menuState,gui);
    }

}
