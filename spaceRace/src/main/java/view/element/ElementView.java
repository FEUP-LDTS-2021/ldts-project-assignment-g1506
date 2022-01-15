package view.element;

import gui.GUI;
import model.Element;

public interface ElementView<T extends Element> {
    void drawElement(T element, GUI gui);
}
