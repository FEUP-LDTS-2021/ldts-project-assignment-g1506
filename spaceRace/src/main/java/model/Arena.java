package model;

import java.util.List;

public class Arena {
    private Rocket rocket1;
    private Rocket rocket2;
    private List<Obstacle> obstacles;
    private List<Wall> walls;

    public void setRocket1(Rocket rocket1) {
        this.rocket1 = rocket1;
    }

    public void setRocket2(Rocket rocket2) {
        this.rocket2 = rocket2;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public Rocket getRocket1() {
        return rocket1;
    }

    public Rocket getRocket2() {
        return rocket2;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<Wall> getWalls() {
        return walls;
    }
}
