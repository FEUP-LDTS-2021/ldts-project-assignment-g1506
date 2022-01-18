package controller;

import Classes.Game;
import State.State;
import gui.GUI;
import model.Arena;
import State.MenuState;
import State.KeyBoardListener;
import model.Position;
import model.Rocket;

import java.io.IOException;

public class PlayController extends GameController implements KeyBoardListener {
    private final State state;
    private ArenaController arenaController;
    private final GUI gui;
    //private final StateView playView;
    private long endTime;
    private final Arena arena;
    private final Position initialPos1;
    private final Position initialPos2;

    public PlayController(State state, GUI gui, Arena arena) {
        super(arena);
        this.state = state;
        this.gui = gui;
        this.arenaController = new ArenaController(state, gui, arena);
        //this.playView = new PlayView(gui);
        this.arena = arena;
        this.endTime = 0;
        this.initialPos1 = new Position(state.getGame().getWidth()/3,state.getGame().getHeight()-2);
        this.initialPos2 = new Position((state.getGame().getWidth()/3)*2,state.getGame().getHeight()-2);
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

        if(action == GUI.ACTION.UP1){
            if(arena.getRocket1().getPosition().getY() == 0){
                arena.getRocket1().setPosition(initialPos1);
                return;
            }
            if(arena.getRocket1().getPosition().getY()>0) {
                arena.getRocket1().setPosition(moveUp1());
                return;
            }
        }
        if (action == GUI.ACTION.DOWN1 && arena.getRocket1().getPosition().getY()<state.getGame().getHeight()-2) {
            arena.getRocket1().setPosition(moveDown1());
            return;
        }

        if(action == GUI.ACTION.UP2){
            if(arena.getRocket2().getPosition().getY() == 0){
                arena.getRocket2().setPosition(initialPos2);
                return;
            }
            if(arena.getRocket2().getPosition().getY()>0){
                arena.getRocket2().setPosition(moveUp2());
                return;
            }
        }
        if (action == GUI.ACTION.DOWN2 && arena.getRocket2().getPosition().getY()<state.getGame().getHeight()-2) {
            arena.getRocket2().setPosition(moveDown2());
            return;
        }
    }

    public Position moveUp1(){return new Position(arena.getRocket1().getPosition().getX(), arena.getRocket1().getPosition().getY()-1);}
    public Position moveUp2(){return new Position(arena.getRocket2().getPosition().getX(), arena.getRocket2().getPosition().getY()-1);}
    public Position moveDown1(){return new Position(arena.getRocket1().getPosition().getX(), arena.getRocket1().getPosition().getY()+1);}
    public Position moveDown2(){return new Position(arena.getRocket2().getPosition().getX(), arena.getRocket2().getPosition().getY()+1);}

}