package view;

import com.googlecode.lanterna.graphics.TextGraphics;
import gui.GUI;
import gui.LanternaGUI;
import model.Position;

import java.io.IOException;

public abstract class StateView {
    protected final LanternaGUI gui;
    private final TextGraphics textGraphics;

    public StateView(LanternaGUI gui){
        this.gui = gui;
        this.textGraphics = gui.createTextGraphics();
    }

    public abstract void draw() throws IOException;

    protected void drawText(Position position, String text,String color){
        gui.drawText(textGraphics, position, text,color);

    }

    protected void drawBackground(String color){
        gui.drawBackground(textGraphics, color);
    }
}
