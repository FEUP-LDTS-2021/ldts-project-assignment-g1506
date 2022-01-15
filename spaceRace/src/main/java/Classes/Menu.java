package Classes;

import State.MenuState;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import gui.GUI;
import gui.LanternaGUI;
import view.state.MenuView;

import java.io.IOException;

public class Menu extends MenuState{
    private int width;
    private int height;
    private GUI gui;

    public Menu(Game game, LanternaGUI gui, int width) {
        super(game, gui);
        this.width = width;
    }

    /*public Menu(int width, int height, GUI gui){
        super();
        this.width = width;
        this.height = height;
        this.gui = gui;
    }

     */

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(TextGraphics graphics) throws IOException {

    }

}
