package Classes;

import State.State;
import controller.RocketController;

import State.MenuState;
import gui.GUI;
import model.Arrow;
import model.Display;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import gui.KeyBoardObserver;
import gui.LanternaGUI;
import view.element.ArrowView;
import view.state.MenuView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final int width;
    private final int height;
    private final int fps;
    private final LanternaGUI gui;
    private final KeyBoardObserver keyBoardObserver;
    private State state;
    public Display display;
    public Menu menu;

    private static Game singleton = null;

    public Game(int x, int y, int fps) throws IOException, URISyntaxException, FontFormatException {
        width = x;
        height = y;
        this.fps = fps;
        this.gui = new LanternaGUI(width, height);
        this.keyBoardObserver = new KeyBoardObserver();
        this.state = new MenuState(this, gui);

        //menu = new Menu(x, y, gui);
        display = new Display(x, y, gui);

    }

    public static Game getInstance() throws IOException, URISyntaxException, FontFormatException {
        if (singleton == null) {
            singleton = new Game(120, 50, 30);
        }
        return singleton;
    }

    public int getWidth(){
            return width;
    }

    public int getHeight(){
            return height;
    }

    public void setGameState(State state) {
        this.state= state;
        if (state != null)
            this.state.start();
    }


    public KeyBoardObserver getKeyBoardObserver(){ return keyBoardObserver;}

    public void start() throws IOException, URISyntaxException, FontFormatException {
        int frameTime = 1000 / this.fps;

        gui.addKeyBoardListener(getKeyBoardObserver());

        // NÃO APAGAR!!!!!!!!
        //MenuView menuView= new MenuView(gui);
        //Arrow arrow = new Arrow(2,2);
        //ArrowView arrowView = new ArrowView();

        //menuView.draw();
        //arrowView.drawElement(arrow, gui);

        RocketController rocketC1 = new RocketController(display,display.rocket1);
        RocketController rocketC2 = new RocketController(display,display.rocket2);

        //this.state.start();

        while ( state != null ) {
            long startTime = System.currentTimeMillis();

            //state.step(this, startTime);

            display.draw();
            display.rocket1.setPosition(rocketC1.doAction(GUI.ACTION.UP));
            display.rocket2.setPosition(rocketC2.doAction(GUI.ACTION.UP));
            //rocketC.doAction();

            //keyBoardObserver.keyPressed(rocketC.doAction());

            //KeyListener listener = new KeyL();
            //((AWTTerminalFrame) screen.getTerminal()).getComponent(0).addKeyListener(listener);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {

            }
        }
    }


}
