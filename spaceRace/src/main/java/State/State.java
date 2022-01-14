package State;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public interface State {

    void open();
    void close();
    boolean getState();
    void setStateTrue();
    void setStateFalse();
    void keyboardRead();
    void draw(TextGraphics graphics) throws IOException;
}
