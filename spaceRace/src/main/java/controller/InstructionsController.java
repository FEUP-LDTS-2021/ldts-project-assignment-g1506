package controller;

import State.KeyBoardListener;
import State.State;
import State.MenuState;
import gui.GUI;
import view.state.InstructionsView;
import view.state.StateView;

import java.io.IOException;

public class InstructionsController implements KeyBoardListener {
    private final State state;
    private final StateView instructionsView;
    private final GUI gui;

    public InstructionsController(State state, GUI gui) {
        this.state = state;
        this.instructionsView = new InstructionsView(gui);
        this.gui = gui;
    }

    public void step() throws IOException{
        instructionsView.draw();
    }

    @Override
    public void keyPressed(GUI.ACTION action) {
        if(action == GUI.ACTION.QUIT){
            state.changeState(new MenuState(this.state.getGame(), gui));
        }
        if(action == GUI.ACTION.ENTER){
            state.changeState(new MenuState(this.state.getGame(), gui));
        }
    }
}
