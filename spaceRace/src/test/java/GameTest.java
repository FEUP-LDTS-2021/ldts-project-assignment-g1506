import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void widthGame(){
        Game game = new Game();

        Assertions.assertEquals(120, game.getWidth());
    }

    @Test
    public void heightGame(){
        Game game = new Game();

        Assertions.assertEquals(40, game.getHeight());
    }
}
