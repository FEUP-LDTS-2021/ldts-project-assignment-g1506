package Classes;

import State.State;


import State.MenuState;
import gui.KeyBoardObserver;
import gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final int width;
    private final int height;
    private final int fps;
    private final LanternaGUI gui;
    private final KeyBoardObserver keyBoardObserver;
    private State state;
    public long initialTime;

    private static Game singleton = null;

    public Game(int x, int y, int fps) throws IOException, URISyntaxException, FontFormatException {
        width = x;
        height = y;
        this.fps = fps;
        this.gui = new LanternaGUI(width, height);
        this.keyBoardObserver = new KeyBoardObserver();
        this.state = new MenuState(this, gui);
    }

    public static Game getInstance() throws IOException, URISyntaxException, FontFormatException {
        if (singleton == null) {
            singleton = new Game(120, 45, 25);
        }
        return singleton;
    }

    public int getWidth(){
            return width;
    }

    public int getHeight(){
            return height;
    }

    public int getFps() {return fps;}

    public void setGameState(State state) {
        this.state= state;
        if (state != null)
            this.state.start();
    }

    public KeyBoardObserver getKeyBoardObserver(){ return keyBoardObserver;}

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public void start() throws IOException{
        int frameTime = 1000 / this.fps;

        gui.addKeyBoardListener(getKeyBoardObserver());

        this.state.start();

        while ( state != null ) {

            long startTime = System.currentTimeMillis();

            state.step(this, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {

            }
        }
        gui.close();
    }
}
