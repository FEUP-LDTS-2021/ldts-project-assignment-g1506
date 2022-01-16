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
        String color = "#E6E6FA";
        String color2 = "#E6E6FA";
        String play = "PLAY";
        String inst = "INSTRUCTIONS";
        String exit = "EXIT";

        drawTitle(color, color2);

        int x = width/2;
        int y = (height/3)*2;

        drawText(screen.newTextGraphics(), new Position(x - play.length()/2,y+1),play, "#FFFAFA");
        drawText(screen.newTextGraphics(), new Position(x - inst.length()/2,y+3),inst, "#FFFAFA");
        drawText(screen.newTextGraphics(), new Position(x - exit.length()/2,y+5),exit, "#FFFAFA");


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

    public void drawTitle(String color, String color2){

        int x = 35;

        drawText(screen.newTextGraphics(), new Position(34, 3),"$$$$$$$      $$$$$$$        $$$$     $$$$$$$     $$$$$$$$", color);
        drawText(screen.newTextGraphics(), new Position(34, 4),"$$          $$$   $$$      $$ $$     $$          $$", color);
        drawText(screen.newTextGraphics(), new Position(33, 5),"$$$          $$$   $$       $$ $$     $$         $$$", color);
        drawText(screen.newTextGraphics(), new Position(33, 6),"$$$          $$$   $$       $$ $$    $$$         $$$", color);
        drawText(screen.newTextGraphics(), new Position(33, 7),"$$$$$$       $$    $$      $$  $$    $$$         $$$", color);
        drawText(screen.newTextGraphics(), new Position(33, 8),"$$$$$$$      $$$$$$$       $$  $$    $$          $$$$$$", color);
        drawText(screen.newTextGraphics(), new Position(37, 9),"$$$$    $$$$$$$$      $$$  $$    $$          $$", color);
        drawText(screen.newTextGraphics(), new Position(38, 10),"$$     $$$           $$$ $$$    $$         $$$", color);
        drawText(screen.newTextGraphics(), new Position(38, 11),"$$     $$            $$$$$$$   $$$         $$$", color);
        drawText(screen.newTextGraphics(), new Position(37, 12),"$$$     $$           $$$  $$$   $$$         $$", color);
        drawText(screen.newTextGraphics(), new Position(32, 13),"$$$$$$$      $$           $$   $$$   $$$$$$$     $$$$$$$", color);
        drawText(screen.newTextGraphics(), new Position(32, 14),"$$$$$$      $$$          $$$   $$$    $$$$$$     $$$$$$$", color);

        drawText(screen.newTextGraphics(), new Position(x, 17),"   $$$$$$$$        $$$$      $$$$$$$      $$$$$$$$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 18),"  $$$   $$$       $$ $$      $$           $$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 19),"  $$$   $$        $$ $$      $$          $$$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 20),"  $$$   $$        $$ $$     $$$          $$$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 21),"  $$$  $$$       $$  $$     $$$          $$$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 22),"  $$$$$$$        $$  $$     $$           $$$$$$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 23)," $$$  $$$       $$$  $$     $$           $$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 24)," $$$   $$       $$$ $$$     $$          $$$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 25)," $$    $$       $$$$$$$    $$$          $$$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 26)," $$    $$      $$$  $$$    $$$          $$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 27)," $$   $$$      $$   $$$    $$$$$$$      $$$$$$$", color2);
        drawText(screen.newTextGraphics(), new Position(x, 28),"$$$   $$$     $$$   $$$     $$$$$$      $$$$$$$", color2);

    }

}
