package view.state;

import gui.LanternaGUI;
import model.Rocket;

import java.io.IOException;

public class PlayView extends StateView{
    private final Rocket rocket1;
    private final Rocket rocket2;

    public PlayView(LanternaGUI gui, Rocket rocket1, Rocket rocket2){
        super(gui);
        this.rocket1 = rocket1;
        this.rocket2 = rocket2;
    }

    @Override
    public void draw() throws IOException {

    }
}
