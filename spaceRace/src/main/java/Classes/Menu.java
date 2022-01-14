package Classes;

import State.MenuState;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import gui.GUI;
import gui.LanternaGUI;

import java.io.IOException;

public class Menu extends MenuState{
    private int width;
    private int height;
    private LanternaGUI gui;

    public Menu(int width, int height, LanternaGUI gui){
        this.width = width;
        this.height = height;
        this.gui = gui;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(TextGraphics graphics) throws IOException {
        //drawBackground(graphics, "#FFFAFA");
        gui.refresh();

        //gui.drawText(graphics, );

        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0,0), graphics.getSize(),' ');

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFAFA"));

        String name =  "SPACE RACE";
        int x = (width/2) - (name.length()/2), y = height/3;

        graphics.putString(x , y, name);
        graphics.putString(width/3, y+3, "Play");
        graphics.putString(width/3, y+5, "Instructions");
        graphics.putString(width/3, y+7, "Exit");
    }

}
