package State;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface State {

    void open();
    void close();
    boolean getState();
    void setStateTrue();
    void setStateFalse();
    void keyboardRead();
    void draw(TextGraphics graphics);
}
