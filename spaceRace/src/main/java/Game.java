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
    int width = 120;
    int height = 35;
    Display display = new Display(width, height);

    public Game() {

        try {
            TerminalSize terminalSize = new TerminalSize(width, height);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void processKey (KeyStroke key){
            switch (key.getKeyType()) {
                //case ArrowUp -> arena.moveHero(arena.moveUp());
                //case ArrowDown -> arena.moveHero(arena.moveDown());
                //case ArrowLeft -> arena.moveHero(arena.moveLeft());
                //case ArrowRight -> arena.moveHero(arena.moveRight());
            }

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
