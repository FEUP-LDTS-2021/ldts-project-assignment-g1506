package controller;

import Classes.Game;
import State.State;
import gui.GUI;
import model.Arena;
import State.MenuState;
import State.KeyBoardListener;

import java.io.IOException;

public class PlayController extends GameController implements KeyBoardListener {
    private final State state;
    private ArenaController arenaController;
    private final GUI gui;
    //private final StateView playView;
    private long endTime;
    private final Arena arena;

    public PlayController(State state, GUI gui, Arena arena) {
        super(arena);
        this.state = state;
        this.gui = gui;
        this.arenaController = new ArenaController(state, gui, arena);
        //this.playView = new PlayView(gui);
        this.arena = arena;
        this.endTime = 0;
    }

    @Override
    public void step(Game game, long time) throws IOException {
        if(this.endTime == 0){
            arenaController.step(game, time);
        }
    }

    public void changeState(State state){
        this.state.changeState(state);
    }

    public void endGame(long time) throws IOException{
        if(time - this.endTime >1500){
            changeState(new MenuState(this.state.getGame(), gui));
        }
    }

    @Override
    public void keyPressed(GUI.ACTION action) {
        if(action == GUI.ACTION.QUIT){
            changeState(new MenuState(this.state.getGame(), this.gui));
            return;
        }
        if(action == GUI.ACTION.UP){

        }
    }


}
