package Classes;

import model.Display;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import gui.GUI;
import gui.KeyBoardObserver;
import gui.LanternaGUI;
import view.MenuView;
import view.ObstacleView;
import view.RocketView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Game {
    private final int width;
    private final int height;
    private final int fps;
    private final LanternaGUI gui;
    private final KeyBoardObserver keyBoardObserver;

    public Display display;
    public Menu menu;

    private static Game singleton = null;

    public Game(int x, int y, int fps) throws IOException, URISyntaxException, FontFormatException {
        width = x;
        height = y;
        this.fps = fps;
        this.gui = new LanternaGUI(width, height);
        this.keyBoardObserver = new KeyBoardObserver();

        menu = new Menu(x, y, gui);
        display = new Display(x, y);

    }

    public static Game getInstance() throws IOException, URISyntaxException, FontFormatException {
        if (singleton == null) {
            singleton = new Game(100, 40, 30);
        }
        return singleton;
    }

    //mudar
    public void processKey (KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> display.moveRocket2(display.moveUp2());
            case ArrowDown -> display.moveRocket2(display.moveDown2());
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'w') {
            display.moveRocket1(display.moveUp1());
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 's') {
            display.moveRocket1(display.moveDown1());
        }
    }

    public void processKeyy (KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_UP){
            display.moveRocket2(display.moveUp2());
        }
    }

    public int getWidth(){
            return width;
        }

    public int getHeight(){
            return height;
        }


    public KeyBoardObserver getKeyBoardObserver(){ return keyBoardObserver;}

    public void start() throws IOException, URISyntaxException, FontFormatException {
        int frameTime = 1000 / this.fps;

        gui.addKeyBoardListener(keyBoardObserver);

        // NÃO APAGAR!!!!!!!!
        //MenuView menuView= new MenuView(menu, gui);
        //menuView.draw();
        ObstacleView obstacleView = new ObstacleView(display, gui);
        obstacleView.draw();
        //RocketView rocketView = new RocketView(display, gui);
        //rocketView.draw();

        while ( true ) {
            long startTime = System.currentTimeMillis();

            obstacleView.draw();
            MoveObstacles move = new MoveObstacles(display);
            //rocketView.draw();

            //menu.draw(screen.newTextGraphics());
            //menu.keyboardRead()    // aqui vai ler a opção, se for a primeira entra no play

            //MoveObstacles move = new MoveObstacles(display);
            //display.draw(screen.newTextGraphics());

            //KeyListener listener = new KeyL();
            //((AWTTerminalFrame) screen.getTerminal()).getComponent(0).addKeyListener(listener);

            //screen.refresh();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {

            }
        }
    }


}
