package view.state;

import gui.GUI;
import model.Arena;
import model.Element;
import model.Obstacle;
import model.Wall;
import view.element.ElementView;
import view.element.ObstacleView;
import view.element.RocketView;
import view.element.WallView;

import java.io.IOException;
import java.util.List;

public class ArenaView {
    private final GUI gui;
    private final Arena arena;
    RocketView rocketView = new RocketView();
    ObstacleView obstacleView = new ObstacleView();
    WallView wallView = new WallView();

    public ArenaView(GUI gui, Arena arena){
        this.gui = gui;
        this.arena = arena;
        this.rocketView = new RocketView();
        this.obstacleView = new ObstacleView();
        this.wallView = new WallView();
    }

    public void draw() throws IOException {
        gui.clear();

        drawBackground();

        rocketView.drawElement(arena.getRocket1(), gui);
        rocketView.drawElement(arena.getRocket2(), gui);

        for(Obstacle obstacle : arena.getObstacles()){
            obstacleView.drawElement(obstacle, gui);
        }

        //MoveObstacles();

        for(Wall wall : arena.getWalls()){
            wallView.drawElement(wall, gui);
        }

        gui.refresh();

    }

    private void drawBackground(){
    }

    private <T extends Element> void drawElements(List<T> elements, ElementView<T> view) throws IOException {
        for(T element : elements)
            drawElement(element, view);
    }

    private <T extends Element> void drawElement(T element, ElementView<T> view) throws IOException {
        view.drawElement(element, gui);
    }
}
