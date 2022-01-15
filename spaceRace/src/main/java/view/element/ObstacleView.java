package view.element;

import gui.GUI;
import model.Obstacle;

public class ObstacleView implements ElementView<Obstacle>{
    @Override
    public void drawElement(Obstacle element, GUI gui) {
        gui.drawObstacle(element.getPosition(),"#FFFAFA");
    }
}
