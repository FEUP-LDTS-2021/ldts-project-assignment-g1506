package Classes;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String args[]) throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game(120,40);
        game.run();
    }
}
