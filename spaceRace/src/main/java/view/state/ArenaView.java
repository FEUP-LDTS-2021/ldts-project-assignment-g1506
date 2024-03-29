package view.state;

import gui.GUI;
import model.Arena.Arena;
import model.Element;
import model.Obstacle;
import model.Wall;
import view.element.*;

import java.io.IOException;
import java.util.List;

public class ArenaView {
    private final GUI gui;
    private final Arena arena;
    RocketView rocketView;
    ObstacleView obstacleView;
    WallView wallView;

    public ArenaView(GUI gui, Arena arena){
        this.gui = gui;
        this.arena = arena;
        this.rocketView = new RocketView();
        this.obstacleView = new ObstacleView();
        this.wallView = new WallView();
    }

    public void draw() throws IOException {
        gui.clear();

        rocketView.drawElement(arena.getRocket1(), gui);
        rocketView.drawElement(arena.getRocket2(), gui);

        for(Obstacle obstacle : arena.getObstacles()){
            obstacleView.drawElement(obstacle, gui);
        }

        for(Wall wall : arena.getWalls()){
            wallView.drawElement(wall, gui);
        }

        gui.refresh();

    }
}
