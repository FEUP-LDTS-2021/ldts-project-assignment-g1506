package view;

import gui.LanternaGUI;
import model.Display;

import java.io.IOException;

public class RocketView extends StateView{

    Display display;

    public RocketView(Display display, LanternaGUI gui) {
        super(gui);
        this.display = display;
    }

    @Override
    public void draw() throws IOException {
        gui.clear();

        drawText(display.rocket1.getPosition(), "R", "#FFFF33");
        
        gui.refresh();

    }
}
