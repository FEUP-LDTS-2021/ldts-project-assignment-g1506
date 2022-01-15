package view.state;

import Classes.Menu;
import gui.GUI;
import gui.LanternaGUI;

import java.io.IOException;

public class MenuView extends StateView {

    public MenuView (GUI gui){
        super(gui);
    }

    @Override
    public void draw() throws IOException {
        drawBackground("#000000");
        gui.drawMenu();
    }
}
