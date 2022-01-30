package model.Arena;

import model.Obstacle;
import model.Rocket;
import model.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaLoader extends ArenaBuilder {
    public ArenaLoader() {
    }

    @Override
    protected Rocket createRocket1(int width, int height) {
        Rocket rocket1 = new Rocket(width/3,height-2);
        rocket1.setScore(0);
        rocket1.setColor("#FF6A6A");
        return rocket1;
    }

    @Override
    protected Rocket createRocket2(int width, int height) {
        Rocket rocket2 = new Rocket((width/3)*2,height-2);
        rocket2.setScore(10);
        rocket2.setColor("#B0E2FF");
        return rocket2;
    }

    @Override
    protected List<Wall> createWalls(int width, int height) {

        List<Wall> walls = new ArrayList<>();

        for(int i = height;  i > 0 ; i--){
            Wall wall = new Wall(width/2,i);
            walls.add(wall);
        }
        return walls;
    }

    @Override
    protected List<Obstacle> createObstacles(int width, int height) {

        List<Obstacle> obstacles = new ArrayList<>();

        boolean aux=true;
        for(int i = 0; i< height - 8 ; i++){
            Random rand = new Random();
            Obstacle obs = new Obstacle(rand.nextInt(width), i);
            obs.setDirection(aux);

            if(aux==true) aux = false;

            else aux = true;

            obstacles.add(obs);
        }
        return obstacles;
    }
}
