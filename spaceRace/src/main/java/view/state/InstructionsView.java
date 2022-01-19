package view.state;

import gui.GUI;
import model.Position;

import java.io.IOException;

public class InstructionsView extends StateView{
    public InstructionsView(GUI gui) {
        super(gui);
    }

    @Override
    public void draw() throws IOException {
        gui.clear();
        drawBackground("#000000");
        gui.drawInstructions();
        gui.refresh();
    }
}
