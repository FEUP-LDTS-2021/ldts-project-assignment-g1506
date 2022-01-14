package Classes;

import Classes.Display;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import gui.GUI;
import gui.KeyBoardObserver;
import gui.LanternaGUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Game {
    private final int width;
    private final int height;
    private final int fps;
    private final GUI gui;
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

        menu = new Menu(x, y);
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

    /*private void draw () throws IOException {

        //screen.clear();
        menu.draw(screen.newTextGraphics());
        //display.draw(screen.newTextGraphics());
        screen.refresh();
    }*/

    public void run () throws IOException, FontFormatException, URISyntaxException {

        URL resource = getClass().getClassLoader().getResource("fonttt.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        Font loadedFont = font.deriveFont(Font.PLAIN, 17);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(width, height));

        Terminal terminal = factory.createTerminal();

        TerminalScreen screen = new TerminalScreen(terminal);
        screen.getTerminal();
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        screen.refresh();

        while (true) {

            //display.draw(screen.newTextGraphics());
            screen.refresh();
            start(screen);

            KeyStroke key = screen.pollInput();

            processKey(key);

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
            }
            if (key.getKeyType() == KeyType.EOF)
                break;
        }


    }
    public void start(TerminalScreen screen) throws IOException {
        int frameTime = 1000 / this.fps;

        gui.addKeyBoardListener(keyBoardObserver);

        //menu.open();

        while ( true ) {
            long startTime = System.currentTimeMillis();

            menu.draw(screen.newTextGraphics());
            //menu.keyboardRead()    // aqui vai ler a opção, se for a primeira entra no play

            MoveObstacles move = new MoveObstacles(display);
            //display.draw(screen.newTextGraphics());

            KeyListener listener = new KeyL();
            ((AWTTerminalFrame) screen.getTerminal()).getComponent(0).addKeyListener(listener);


            screen.refresh();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {

            }
        }
    }


}
