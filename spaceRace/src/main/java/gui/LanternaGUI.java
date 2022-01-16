package gui;

import model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

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
        this.width = 120;
        this.height = 60;
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
        URL resource = getClass().getClassLoader().getResource("Space2.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 15);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public boolean isActive() {
        return ((AWTTerminalFrame) screen.getTerminal()).isDisplayable();
    }

    public void drawMenu(){
        String color = "#FFFAFA";

        drawTitle(color);

        String name =  "SPACE RACE";

        int x = (width/2) - (name.length()/2), y = height/3;

        drawText(screen.newTextGraphics(), new Position(x,y),"SPACE RACE", "#FFFAFA");
        drawText(screen.newTextGraphics(), new Position(x-6,y+3),"Play", "#FFFAFA");
        drawText(screen.newTextGraphics(), new Position(x-6,y+5),"Instructions", "#FFFAFA");
        drawText(screen.newTextGraphics(), new Position(x-6,y+7),"Exit", "#FFFAFA");


    }

    @Override
    public void drawObstacle(Position position, String color) {
        drawText( screen.newTextGraphics(), position, "-" ,color);
    }

    @Override
    public void drawWall(Position position, String color) {
        drawText( screen.newTextGraphics(), position, "$", color);
    }

    @Override
    public void drawRocket(Position position, String color) {
        Position p1 = new Position(position.getX(), position.getY()+1);
        Position p2 = new Position(position.getX(), position.getY()+2);
        Position p3 = new Position(position.getX()-1, position.getY()+2);
        Position p4 = new Position(position.getX()+1, position.getY()+2);
        drawText( screen.newTextGraphics(), position, "w", color);
        drawText( screen.newTextGraphics(), p1, "$", color);
        drawText( screen.newTextGraphics(), p2, "'", color);
        drawText( screen.newTextGraphics(), p3, "%", color);
        drawText( screen.newTextGraphics(), p4, "&", color);
    }

    @Override
    public void drawArrow(Position position, String color){
        drawText(screen.newTextGraphics(), position, "*", color);
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

    public void drawText(TextGraphics textGraphics, Position position, String text, String color) {
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

    public void drawTitle(String color){
        drawText(screen.newTextGraphics(), new Position(34, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(35, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(36, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(37, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(38, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(39, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(40, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(34, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(35, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(33, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(34, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(35, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(33, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(34, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(35, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(33, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(34, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(35, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(36, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(37, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(38, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(33, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(34, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(35, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(36, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(37, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(38, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(39, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(37, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(38, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(39, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(40, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(38, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(39, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(38, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(39, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(37, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(38, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(39, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(32, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(33, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(34, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(35, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(36, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(37, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(38, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(32, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(33, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(34, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(35, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(36, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(37, 14),"$", color);

        drawText(screen.newTextGraphics(), new Position(46, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(47, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(48, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(49, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(50, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(51, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(52, 3),"$", color);

        drawText(screen.newTextGraphics(), new Position(45, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(46, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(47, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(51, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(52, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(53, 4),"$", color);

        drawText(screen.newTextGraphics(), new Position(45, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(46, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(47, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(51, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(52, 5),"$", color);

        drawText(screen.newTextGraphics(), new Position(45, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(46, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(47, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(51, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(52, 6),"$", color);

        drawText(screen.newTextGraphics(), new Position(45, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(46, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(51, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(52, 7),"$", color);

        drawText(screen.newTextGraphics(), new Position(45, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(46, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(47, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(48, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(49, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(50, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(51, 8),"$", color);

        drawText(screen.newTextGraphics(), new Position(44, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(45, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(46, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(47, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(48, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(49, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(50, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(51, 9),"$", color);

        drawText(screen.newTextGraphics(), new Position(44, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(45, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(46, 10),"$", color);

        drawText(screen.newTextGraphics(), new Position(44, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(45, 11),"$", color);

        drawText(screen.newTextGraphics(), new Position(44, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(45, 12),"$", color);

        drawText(screen.newTextGraphics(), new Position(44, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(45, 13),"$", color);

        drawText(screen.newTextGraphics(), new Position(43, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(44, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(45, 14),"$", color);



        drawText(screen.newTextGraphics(), new Position(59, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(60, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 3),"$", color);

        drawText(screen.newTextGraphics(), new Position(58, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(59, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 4),"$", color);

        drawText(screen.newTextGraphics(), new Position(58, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(59, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 5),"$", color);

        drawText(screen.newTextGraphics(), new Position(58, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(59, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 6),"$", color);

        drawText(screen.newTextGraphics(), new Position(57, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(58, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 7),"$", color);

        drawText(screen.newTextGraphics(), new Position(57, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(58, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 8),"$", color);

        drawText(screen.newTextGraphics(), new Position(56, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(57, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(58, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 9),"$", color);

        drawText(screen.newTextGraphics(), new Position(56, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(57, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(58, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(60, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 10),"$", color);

        drawText(screen.newTextGraphics(), new Position(56, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(57, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(58, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(59, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(60, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 11),"$", color);

        drawText(screen.newTextGraphics(), new Position(55, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(56, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(57, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(60, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 12),"$", color);

        drawText(screen.newTextGraphics(), new Position(55, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(56, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(60, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 13),"$", color);

        drawText(screen.newTextGraphics(), new Position(54, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(55, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(56, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(60, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(61, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(62, 14),"$", color);



        drawText(screen.newTextGraphics(), new Position(68, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(69, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(70, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(71, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(72, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(73, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(74, 3),"$", color);

        drawText(screen.newTextGraphics(), new Position(68, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(69, 4),"$", color);

        drawText(screen.newTextGraphics(), new Position(68, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(69, 5),"$", color);

        drawText(screen.newTextGraphics(), new Position(67, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(68, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(69, 6),"$", color);

        drawText(screen.newTextGraphics(), new Position(67, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(68, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(69, 7),"$", color);

        drawText(screen.newTextGraphics(), new Position(67, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(68, 8),"$", color);

        drawText(screen.newTextGraphics(), new Position(67, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(68, 9),"$", color);

        drawText(screen.newTextGraphics(), new Position(67, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(68, 10),"$", color);

        drawText(screen.newTextGraphics(), new Position(66, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(67, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(68, 11),"$", color);

        drawText(screen.newTextGraphics(), new Position(66, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(67, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(68, 12),"$", color);

        drawText(screen.newTextGraphics(), new Position(66, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(67, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(68, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(69, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(70, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(71, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(72, 13),"$", color);

        drawText(screen.newTextGraphics(), new Position(67, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(68, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(69, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(70, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(71, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(72, 14),"$", color);


        drawText(screen.newTextGraphics(), new Position(80, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(81, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(82, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(83, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(84, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(85, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(86, 3),"$", color);
        drawText(screen.newTextGraphics(), new Position(87, 3),"$", color);

        drawText(screen.newTextGraphics(), new Position(80, 4),"$", color);
        drawText(screen.newTextGraphics(), new Position(81, 4),"$", color);

        drawText(screen.newTextGraphics(), new Position(79, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(80, 5),"$", color);
        drawText(screen.newTextGraphics(), new Position(81, 5),"$", color);

        drawText(screen.newTextGraphics(), new Position(79, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(80, 6),"$", color);
        drawText(screen.newTextGraphics(), new Position(81, 6),"$", color);

        drawText(screen.newTextGraphics(), new Position(79, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(80, 7),"$", color);
        drawText(screen.newTextGraphics(), new Position(81, 7),"$", color);

        drawText(screen.newTextGraphics(), new Position(79, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(80, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(81, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(82, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(83, 8),"$", color);
        drawText(screen.newTextGraphics(), new Position(84, 8),"$", color);

        drawText(screen.newTextGraphics(), new Position(79, 9),"$", color);
        drawText(screen.newTextGraphics(), new Position(80, 9),"$", color);

        drawText(screen.newTextGraphics(), new Position(78, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(79, 10),"$", color);
        drawText(screen.newTextGraphics(), new Position(80, 10),"$", color);

        drawText(screen.newTextGraphics(), new Position(78, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(79, 11),"$", color);
        drawText(screen.newTextGraphics(), new Position(80, 11),"$", color);

        drawText(screen.newTextGraphics(), new Position(78, 12),"$", color);
        drawText(screen.newTextGraphics(), new Position(79, 12),"$", color);

        drawText(screen.newTextGraphics(), new Position(78, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(79, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(80, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(81, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(82, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(83, 13),"$", color);
        drawText(screen.newTextGraphics(), new Position(84, 13),"$", color);

        drawText(screen.newTextGraphics(), new Position(78, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(79, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(80, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(81, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(82, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(83, 14),"$", color);
        drawText(screen.newTextGraphics(), new Position(84, 14),"$", color);

    }

}
