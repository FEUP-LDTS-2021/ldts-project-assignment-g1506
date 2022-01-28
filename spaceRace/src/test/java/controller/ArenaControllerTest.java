package controller;

import Classes.Game;
import State.PlayState;
import gui.LanternaGUI;
import model.Arena.Arena;
import model.Rocket;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ArenaControllerTest {
    LanternaGUI gui;
    Arena arena;
    ArenaController arenaController;

    @BeforeEach
    void setUp() throws IOException {
        this.gui = Mockito.mock(LanternaGUI.class);
        this.arena = new Arena();

        Rocket rocket1 = new Rocket(gui.getWidth()/3, gui.getHeight()-2);
        Rocket rocket2 = new Rocket((gui.getWidth()/3)*2, gui.getHeight()-2);
        arena.setRocket1(rocket1);
        arena.setRocket2(rocket2);

        Game game = Mockito.mock(Game.class);
        //this.arenaController = new arenaController(new PlayState(game,gui), gui, arena, );
        //new arenaController()
    }
}
