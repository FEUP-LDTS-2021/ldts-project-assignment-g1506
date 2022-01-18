package controller;

import Classes.Game;
import State.KeyBoardListener;
import State.State;
import gui.GUI;
import model.Arrow;
import model.Position;
import view.element.ArrowView;
import view.state.MenuView;
import view.state.StateView;
import State.PlayState;

import java.io.IOException;

public class MenuController implements KeyBoardListener {
    private final State state1;
    private final StateView menuView;
    private final ArrowView arrowView;
    private final GUI gui;
    private final Game game;
    private static int num = 1;
    Arrow arrow;

    public MenuController(State state1, GUI gui){
        this.state1 = state1;
        this.menuView = new MenuView(gui);
        this.arrowView = new ArrowView();
        this.gui = gui;
        this.arrow = new Arrow(gui.getWidth()/2 - 8, (gui.getHeight() * 2) / 3);
        this.game = state1.getGame();
    }

    public void step() throws IOException{
        gui.clear();
        menuView.draw();
        arrowView.drawElement(arrow, gui);
        gui.refresh();
    }

    public void keyPressed(GUI.ACTION action){

        if(action == GUI.ACTION.QUIT){
            state1.changeState(null);
        }

        if(action == GUI.ACTION.UP1 || action == GUI.ACTION.UP2){
            if(num-1 < 1)
                num = 1;
            else {
                num--;
                arrow.setPosition(new Position(arrow.getPosition().getX(), arrow.getPosition().getY() -2));
            }
        }

        if(action == GUI.ACTION.DOWN1 || action == GUI.ACTION.DOWN2){
            if(num+1 > 3)
                num = 3;
            else {
                num++;
                arrow.setPosition(new Position(arrow.getPosition().getX(), arrow.getPosition().getY() +2));
            }
        }

        if(action == GUI.ACTION.ENTER){
            if(num==1){
                state1.changeState(new PlayState(game, gui));  //primeira opção
            }
            else if(num==2){
                state1.changeState(state1);  //segunda opção
            }
            else if(num==3){
                state1.changeState(null);
            }
        }
    }

}