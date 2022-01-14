package State;

import Classes.Game;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class MenuState implements State {
    boolean active = false;


    @Override
    public void open() {
        setStateTrue();
    }

    @Override
    public void close() {
        setStateFalse();
    }

    @Override
    public boolean getState() {
        return active;
    }

    @Override
    public void setStateTrue() {
        this.active = true;
    }

    @Override
    public void setStateFalse() {
        this.active = false;
    }

    @Override
    public void keyboardRead() {

    }

    @Override
    public void draw(TextGraphics graphics) {
    }
}
