import Classes.Game;
import State.MenuState;
import controller.MenuController;
import gui.GUI;
import gui.KeyBoardObserver;
import gui.LanternaGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuStateTest {
    private MenuState state;
    private Game game;
    private GUI gui;
    private MenuController menuController;
    private KeyBoardObserver keyBoardObserver;

    @BeforeEach
    public void build() {
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(LanternaGUI.class);
        this.keyBoardObserver = Mockito.mock(KeyBoardObserver.class);

        this.state = new MenuState(game, gui);
        this.menuController = Mockito.mock(MenuController.class);
        this.state.setMenuController(menuController);

        Mockito.when(game.getKeyBoardObserver()).thenReturn(keyBoardObserver);
    }

    @Test
    void startTest(){
        state.start();

        Mockito.verify(keyBoardObserver, Mockito.times(1)).setListener(menuController);
    }

    @Test
    void stepTest() throws IOException {
        state.step(game, 10);

        Mockito.verify(menuController, Mockito.times(1)).step();
    }

    @Test
    void setControllerTest() {
        MenuController newMenuController = new MenuController(state, gui);
        state.setMenuController(newMenuController);

        Assertions.assertEquals(state.getMenuController(), newMenuController);
    }

    @Test
    void getControllerTest() {
        MenuController newMenuController = state.getMenuController();

        Assertions.assertEquals(newMenuController, menuController);
    }
}
