package gui;

import Classes.KeyBoardListener;
import Classes.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI{
    private final TerminalScreen screen;
    private final int width;
    private final int height;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);

        this.width = width;
        this.height = height;
    }

    public LanternaGUI(TerminalScreen screen){
        this.screen = screen;
        this.width = 100;
        this.height = 40;
    }

    public TerminalScreen createScreen(Terminal terminal) throws IOException{
        final TerminalScreen terminalScreen;
        terminalScreen = new TerminalScreen(terminal);

        terminalScreen.getTerminal();
        terminalScreen.setCursorPosition(null);   // we don't need a cursor
        terminalScreen.startScreen();             // screens must be started
        terminalScreen.doResizeIfNecessary();     // resize screen if necessary
        return terminalScreen;
    }

    public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height+1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();

        terminalFactory.setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    public AWTTerminalFontConfiguration loadFont() throws FontFormatException, IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("fonttt.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 17);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public boolean isActive() {
        return ((AWTTerminalFrame) screen.getTerminal()).isDisplayable();
    }

    @Override
    public void drawObstacle(Position position, String color) {
        drawText( screen.newTextGraphics(), position, "O" ,color);
    }

    @Override
    public void drawWall(Position position, String color) {
        drawText( screen.newTextGraphics(), position, "|", color);
    }

    @Override
    public void drawRocket1(Position position, String color) {
        drawText( screen.newTextGraphics(), position, "R", color);
    }

    @Override
    public void drawRocket2(Position position, String color) {
        drawText( screen.newTextGraphics(), position, "R", color);
    }

    @Override
    public void addKeyBoardListener(KeyBoardObserver obs) {
        ((AWTTerminalFrame) screen.getTerminal()).getComponent(0).addKeyListener(obs);
    }

    @Override
    public TextGraphics createTextGraphics() {
        return screen.newTextGraphics();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void drawBackground(TextGraphics textGraphics, String color){
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');
    }

    private void drawText(TextGraphics textGraphics, Position position, String text, String color) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(),position.getY(),text);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
