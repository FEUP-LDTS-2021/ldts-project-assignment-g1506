package gui;

import model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public interface GUI {

    enum ACTION{
        UP1,
        UP2,
        DOWN1,
        DOWN2,
        PAUSE,
        QUIT,
        ENTER
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

    void drawMenu();

    void drawInstructions();

    void drawObstacle(Position position, String color);

    void drawWall(Position position, String color);

    void drawRocket(Position position, String color, int score);

    void drawArrow(Position position, String color);

}
