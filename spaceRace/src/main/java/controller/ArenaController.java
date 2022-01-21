package controller;

import Classes.Game;
import State.State;
import gui.GUI;
import model.Arena.Arena;
import model.Obstacle;
import model.Position;
import view.state.ArenaView;

import java.io.IOException;

public class ArenaController extends GameController{
    private final State state;
    private final ArenaView arenaView;
    private final Arena arena;
    private int aux=1;
    private final Position initialposition1;
    private final Position initialposition2;


    public ArenaController(State state, GUI gui, Arena arena, Position initialposition1,Position initialposition2){
        super(arena);
        this.state = state;
        this.arenaView = new ArenaView(gui, arena);
        this.arena = arena;
        this.initialposition1=initialposition1;
        this.initialposition2=initialposition2;
    }

    @Override
    public void step(Game game, long time) throws IOException {
        removeWall(game,time);
        moveObstacles();
        checkColisions();
        arenaView.draw();
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
        if (x<-1){
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

        if(((time-game.initialTime)/900) > aux){
            aux++;
            if(arena.getWalls().isEmpty()==false)
                arena.getWalls().remove(arena.getWalls().size()-1);
        }
    }

    //CHECK COLISIONS
    public void checkColisions(){

        for (Obstacle obstacles: arena.getObstacles()){
            if((obstacles.getPosition().getX()==arena.getRocket1().getPosition().getX() && obstacles.getPosition().getY()==arena.getRocket1().getPosition().getY())
                    || (obstacles.getPosition().getX()==arena.getRocket1().getPosition().getX() && obstacles.getPosition().getY()==arena.getRocket1().getPosition().getY()+1)
                    || (obstacles.getPosition().getX()==arena.getRocket1().getPosition().getX() && obstacles.getPosition().getY()==arena.getRocket1().getPosition().getY()+2))
            {
                arena.getRocket1().setPosition(initialposition1);
            }

            if((obstacles.getPosition().getX()==arena.getRocket2().getPosition().getX() && obstacles.getPosition().getY()==arena.getRocket2().getPosition().getY())
                    || (obstacles.getPosition().getX()==arena.getRocket2().getPosition().getX() && obstacles.getPosition().getY()==arena.getRocket2().getPosition().getY()+1)
                    || (obstacles.getPosition().getX()==arena.getRocket2().getPosition().getX() && obstacles.getPosition().getY()==arena.getRocket2().getPosition().getY()+2))
            {
                arena.getRocket2().setPosition(initialposition2);
            }
        }
    }
}
