package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import gui.LanternaGUI;
import model.Display;
import model.Obstacle;

import java.io.IOException;

public class ObstacleView extends StateView{
    Display display;

    public ObstacleView(Display display, LanternaGUI gui) throws IOException {
        super(gui);
        this.display = display;
    }

    @Override
    public void draw() throws IOException {
        //gui.clear();
        for(Obstacle obstacle: display.obstacles){
            drawText(obstacle.getPosition(), "O", "#FFFAFA");
        }
        //gui.refresh();
    }
}
