package State;

import com.googlecode.lanterna.graphics.TextGraphics;

public class PlayState implements State {
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
        active = true;
    }

    @Override
    public void setStateFalse() {
        active = false;
    }

    @Override
    public void keyboardRead() {

    }

    @Override
    public void draw(TextGraphics graphics) {
    }
}
