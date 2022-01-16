package view.state;

import gui.GUI;

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
