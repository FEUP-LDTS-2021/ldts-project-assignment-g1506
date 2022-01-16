package controller;

import Classes.Game;
import State.State;
import gui.GUI;
import model.Arena;
import view.element.ArenaView;

import java.io.IOException;

public class ArenaController extends GameController{
    private final State state;
    private final ArenaView arenaView;
    //private final RocketController rocketController;

    public ArenaController(State state, GUI gui, Arena arena){
        super(arena);
        this.state = state;
        this.arenaView = new ArenaView(gui, arena);
        //this.rocketController = new RocketController();
    }

    @Override
    public void step(Game game, long time) throws IOException {
        //mover os obstáculos antes de desenhar
        arenaView.draw();
    }

    public void doAction(GUI.ACTION action){

    }


    //CHECK COLISIONS
}
