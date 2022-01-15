package view.state;

import Classes.Menu;
import gui.LanternaGUI;
import model.Position;

import java.io.IOException;

public class MenuView extends StateView {
    int width;
    int height;

        public MenuView (Menu menu, LanternaGUI gui){
            super(gui);
            this.width = menu.getWidth();
            this.height = menu.getHeight();
        }

    @Override
    public void draw() throws IOException {
        gui.clear();

        drawBackground("#000000");

        String name =  "SPACE RACE";
        int x = (width/2) - (name.length()/2), y = height/3;
        drawText(new Position(x,y),"SPACE RACE", "#FFFAFA");
        drawText(new Position(x-6,y+3),"Play", "#FFFAFA");
        drawText(new Position(x-6,y+5),"Instructions", "#FFFAFA");
        drawText(new Position(x-6,y+7),"Exit", "#FFFAFA");

        gui.refresh();
}
}
