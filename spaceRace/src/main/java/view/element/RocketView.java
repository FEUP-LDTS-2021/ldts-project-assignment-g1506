package view.element;

import gui.GUI;
import model.Rocket;

public class RocketView implements ElementView<Rocket>{
    @Override
    public void drawElement(Rocket element, GUI gui) {
        gui.drawRocket(element.getPosition(), "#00B2EE");
    }
}
