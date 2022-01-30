import Classes.Game;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameTest {

    @Test
    public void getInstanceTest() throws IOException, URISyntaxException, FontFormatException {
        int x = 120;
        int y = 45;
        int z = 25;

        Game game = Game.getInstance();

        int a = game.getWidth();
        int b = game.getHeight();
        int fps = game.getFps();

        Assertions.assertEquals(a, x);
        Assertions.assertEquals(b, y);
        Assertions.assertEquals(fps, z);
    }

    //Tests if game is created with the right size
    /*@Test
    public void sizeGame1() {
        int x=120;
        int y=40;
        int fps = 30;
        Game game = new Game(x,y, fps);

        Assertions.assertEquals(x, game.getWidth());
        Assertions.assertEquals(y, game.getHeight());
    }
    @Test
    public void sizeGame2() {
        int x=100;
        int y=30;
        int fps = 30;
        Game game = new Game(x,y, fps);

        Assertions.assertEquals(x, game.getWidth());
        Assertions.assertEquals(y, game.getHeight());
    }
    @Test
    public void sizeGame3() {
        int x=90;
        int y=20;
        int fps = 30;
        Game game = new Game(x,y, fps);

        Assertions.assertEquals(x, game.getWidth());
        Assertions.assertEquals(y, game.getHeight());
    }

    @Test
    public void sizeDisplay1(){
        int x=120;
        int y=40;
        int fps = 30;
        Game game = new Game(x,y, fps);

        Assertions.assertEquals(x, game.display.getWidth());
        Assertions.assertEquals(y, game.display.getHeight());
    }

     */

}
