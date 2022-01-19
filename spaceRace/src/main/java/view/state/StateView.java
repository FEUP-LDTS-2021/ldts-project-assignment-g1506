package view.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import gui.GUI;
import gui.LanternaGUI;
import model.Position;

import java.io.IOException;

public abstract class StateView {
    protected final GUI gui;
    private final TextGraphics textGraphics;

    public StateView(GUI gui){
        this.gui = gui;
        this.textGraphics = gui.createTextGraphics();
    }

    public abstract void draw() throws IOException;

    protected void drawBackground(String color){
        gui.drawBackground(textGraphics, color);
    }

}
