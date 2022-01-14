package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import gui.LanternaGUI;
import model.Display;
import model.Wall;

import java.io.IOException;

public class WallView extends StateView{
    Display display;

    public WallView(Display display, LanternaGUI gui) throws IOException {
        super(gui);
        this.display = display;
    }

    @Override
    public void draw() throws IOException {
        for(Wall wall: display.walls){
            drawText(wall.getPosition(), "|", "#FFFAFA");
        }
    }
        //graphics.setForegroundColor(TextColor.Factory.fromString("#FFFAFA"));
        //graphics.enableModifiers(SGR.BOLD);
        //graphics.putString(new TerminalPosition(position.getX(), position.getY()), "|");
}
