import Classes.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    //Tests if game is created with the right size
    @Test
    public void sizeGame1() {
        int x=120;
        int y=40;
        Game game = new Game(x,y);

        Assertions.assertEquals(x, game.getWidth());
        Assertions.assertEquals(y, game.getHeight());
    }
    @Test
    public void sizeGame2() {
        int x=100;
        int y=30;
        Game game = new Game(x,y);

        Assertions.assertEquals(x, game.getWidth());
        Assertions.assertEquals(y, game.getHeight());
    }
    @Test
    public void sizeGame3() {
        int x=90;
        int y=20;
        Game game = new Game(x,y);

        Assertions.assertEquals(x, game.getWidth());
        Assertions.assertEquals(y, game.getHeight());
    }

    @Test
    public void sizeDisplay1(){
        int x=120;
        int y=40;
        Game game = new Game(x,y);

        Assertions.assertEquals(x, game.display.getWidth());
        Assertions.assertEquals(y, game.display.getHeight());
    }

}
