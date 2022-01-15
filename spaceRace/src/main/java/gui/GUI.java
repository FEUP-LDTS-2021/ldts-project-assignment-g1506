package gui;

import model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public interface GUI {

    enum ACTION{
        UP,
        DOWN,
        LEFT,
        RIGHT,
        PAUSE,
        QUIT
    }

    TextGraphics createTextGraphics();

    int getWidth();

    int getHeight();

    void drawBackground(TextGraphics textGraphics, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void addKeyBoardListener(KeyBoardObserver obs);

    boolean isActive();

    void drawObstacle(Position position, String color);

    void drawWall(Position position, String color);

    void drawRocket(Position position, String color);

}
