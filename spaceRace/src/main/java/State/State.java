package State;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface State {

    void open();
    void close();
    void draw(TextGraphics graphics);
}
