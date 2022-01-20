package model.Arena;

import model.Arena.Arena;
import model.Obstacle;
import model.Rocket;
import model.Wall;

import java.util.List;

public abstract class ArenaBuilder {

    public Arena createArena(int width, int height){
        Arena arena = new Arena();
        arena.setRocket1(createRocket1(width, height));
        arena.setRocket2(createRocket2(width, height));
        arena.setWalls(createWalls(width, height));
        arena.setObstacles(createObstacles(width, height));
        return arena;
    }

    protected abstract Rocket createRocket1(int width, int height);

    protected abstract Rocket createRocket2(int width, int height);

    protected abstract List<Wall> createWalls(int width, int height);

    protected abstract List<Obstacle> createObstacles(int width, int height);


}
