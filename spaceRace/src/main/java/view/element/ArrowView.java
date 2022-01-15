package view.element;

import gui.GUI;
import model.Arrow;

import java.io.IOException;

public class ArrowView implements ElementView<Arrow> {
    @Override
    public void drawElement(Arrow element, GUI gui) throws IOException {
        gui.drawArrow(element.position, "#FFFAFA");
    }
}
