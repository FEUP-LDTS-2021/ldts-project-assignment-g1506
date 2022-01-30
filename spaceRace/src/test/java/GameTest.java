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

}
