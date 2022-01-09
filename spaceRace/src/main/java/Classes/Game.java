package Classes;

import Classes.Display;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Screen screen = null;
    int width;
    int height;
    public Display display;

    public Game(int x, int y) {
        width = x;
        height = y;
        display = new Display(x, y);

        try {
            TerminalSize terminalSize = new TerminalSize(width, height);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

        public int getWidth(){
            return width;
        }

        public int getHeight(){
            return height;
        }

        private void draw () throws IOException {
            screen.clear();
            display.draw(screen.newTextGraphics());
            screen.refresh();
        }

        public void run () throws IOException {
            while (true) {
                draw();
                KeyStroke key = screen.readInput();

                processKey(key);

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                    screen.close();
                }
                if (key.getKeyType() == KeyType.EOF)
                    break;
            }
        }
}
