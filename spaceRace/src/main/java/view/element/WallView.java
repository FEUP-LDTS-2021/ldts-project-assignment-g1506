package view.element;

import gui.GUI;
import model.Wall;

public class WallView implements ElementView<Wall>{
    @Override
    public void drawElement(Wall element, GUI gui) {
        gui.drawWall(element.getPosition(), "#FFFAFA");
    }
}
