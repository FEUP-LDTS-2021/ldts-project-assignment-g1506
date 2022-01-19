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
        String color = "#FF6A6A";
        String color2 = "#EEDD82";
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
    public void drawRocket(Position position, String color, int score) {
        Position p1 = new Position(position.getX(), position.getY()+1);
        Position p2 = new Position(position.getX(), position.getY()+2);
        Position p3 = new Position(position.getX()-1, position.getY()+2);
        Position p4 = new Position(position.getX()+1, position.getY()+2);
        drawText( screen.newTextGraphics(), position, "w", color);
        drawText( screen.newTextGraphics(), p1, "$", color);
        drawText( screen.newTextGraphics(), p2, "'", color);
        drawText( screen.newTextGraphics(), p3, "%", color);
        drawText( screen.newTextGraphics(), p4, "&", color);

        drawScore(color, score);
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

    public void drawInstructions(){
        int x = width/2 - 108/2;
        int y = 4;
        String color = "#FFFAFA";

        drawText(screen.newTextGraphics(), new Position(x,y+0), "   $$$$$    $$$$$    $$$$$     $$$$$$    $$   $    $$$$$$    $$$$$     $$$$$    $$$$$$     $$$  $    $$$$$",color);
        drawText(screen.newTextGraphics(), new Position(x,y+1), "    $$      $$        $$      $$$  $$   $$$  $$    $$         $$        $$     $$$  $$    $$$$  $    $$   ",color);
        drawText(screen.newTextGraphics(), new Position(x,y+2), "    $      $$$        $       $$$  $$   $$   $$   $$$         $         $      $$   $$    $$$$ $$   $$$   ",color);
        drawText(screen.newTextGraphics(), new Position(x,y+3), "    $      $$$$$      $       $$$ $$    $$   $$   $$$         $         $      $$   $$    $$$$ $$   $$$$$ ",color);
        drawText(screen.newTextGraphics(), new Position(x,y+4), "   $$         $$$    $$       $$ $$$    $$   $$   $$         $$        $$      $$   $$    $$$$ $$      $$$",color);
        drawText(screen.newTextGraphics(), new Position(x,y+5), "   $$          $$    $$       $$  $$    $$  $$$   $$         $$        $$      $   $$$    $  $ $        $$",color);
        drawText(screen.newTextGraphics(), new Position(x,y+6), "   $$          $$    $$       $   $$    $   $$    $$         $$        $$      $   $$     $  $$$        $$",color);
        drawText(screen.newTextGraphics(), new Position(x,y+7), "$$$$$$     $$$$$     $$       $   $$    $$$$$     $$$$$      $$      $$$$$     $$$$$$     $  $$$    $$$$$ ",color);
        drawText(screen.newTextGraphics(), new Position(x,y+8), "$$$$$$     $$$$     $$$      $$  $$$    $$$$$     $$$$$     $$$      $$$$$     $$$$$     $$  $$$    $$$$  ",color);

        String i1 = "USE W AND S TO MOVE FIRST ROCKET";
        String i2 = "USE ARROW UP AND ARROW DOWN TO MOVE SECOND ROCKET";

        drawText(screen.newTextGraphics(), new Position(width/2 - i1.length()/2,height/2), i1,color);
        drawText(screen.newTextGraphics(), new Position(width/2 - i2.length()/2,height/2 +2), i2,color);
        //drawText(screen.newTextGraphics(), new Position(x,height/2 +2), "USE W AND S TO MOVE FIRST ROCKET",color);

    }

    public void drawScore(String color, int number){
        int x = 15;
        if(number >= 10)  x = width-16;
        if(number == 0 || number == 10){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"$$$$", color);
        }

        if(number == 1 || number == 11){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"   $", color);
        }

        if(number == 2 || number == 12){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"$   ", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"$   ", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"$$$$", color);
        }

        if(number == 3 || number == 13){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"$$$$", color);
        }

        if(number == 4 || number == 14){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"   $", color);
        }

        if(number == 5 || number == 15){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"$   ", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"$   ", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"$$$$", color);
        }

        if(number == 6 || number == 16){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"$   ", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"$   ", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"$$$$", color);
        }

        if(number == 7 || number == 17){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"   $", color);
        }

        if(number == 8 || number == 18){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"$$$$", color);
        }

        if(number == 9 || number == 19){
            drawText(screen.newTextGraphics(), new Position(x, height-6),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-5),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-4),"$  $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-3),"$$$$", color);
            drawText(screen.newTextGraphics(), new Position(x, height-2),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height-1),"   $", color);
            drawText(screen.newTextGraphics(), new Position(x, height),"   $", color);
        }
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
