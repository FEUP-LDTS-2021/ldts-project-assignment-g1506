package view.element;

import gui.GUI;
import model.Element;

import java.io.IOException;

public interface ElementView<T extends Element> {
    void drawElement(T element, GUI gui) throws IOException;
}
