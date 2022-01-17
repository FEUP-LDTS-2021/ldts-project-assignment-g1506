package controller;

import Classes.Game;
import State.State;
import gui.GUI;
import model.Arena;
import model.Obstacle;
import view.state.ArenaView;

import java.io.IOException;

public class ArenaController extends GameController{
    private final State state;
    private final ArenaView arenaView;
    private final Arena arena;
    private int aux=1;
    //private final RocketController rocketController;

    public ArenaController(State state, GUI gui, Arena arena){
        super(arena);
        this.state = state;
        this.arenaView = new ArenaView(gui, arena);
        this.arena = arena;
        //this.rocketController = new RocketController();
    }

    @Override
    public void step(Game game, long time) throws IOException {

        removeWall(game,time);
        moveObstacles();
        arenaView.draw();

    }

    public void doAction(GUI.ACTION action){


    }

    public void moveObstacles(){
        for (Obstacle obstacle: arena.getObstacles()) {
            if(colisionWall(obstacle.position.getX(),obstacle)==true)
                continue;
            else{
                if(obstacle.getDirection()==true)
                    moveRight(obstacle);
                else
                    moveLeft(obstacle);
            }
        }
    }

    public boolean colisionWall(int x, Obstacle obstacle){
        if (x<0){
            obstacle.setDirection(true);
            moveRight(obstacle);
            return true;
        }
        if(x>state.getGame().getWidth()){
            obstacle.setDirection(false);
            moveLeft(obstacle);
            return true;
        }
        return false;
    }

    public void moveRight(Obstacle obstacle)
    {
        obstacle.position.setX(obstacle.position.getX()+1);
    }

    public void moveLeft(Obstacle obstacle){
        obstacle.position.setX(obstacle.position.getX()-1);
    }

    public void removeWall(Game game , long time){

        if(((time-game.initialTime)/500) > aux){
            aux++;
            if(arena.getWalls().isEmpty()==false)
                arena.getWalls().remove(arena.getWalls().size()-1);
        }
    }
    //CHECK COLISIONS
}
