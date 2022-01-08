import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ObstaclesTest {

    @Test
    public void numberObstacles1(){
        int x = 100;
        int y = 30;
        Game game1 = new Game(x, y);
        List<Obstacle> obstacles1 = game1.display.createObstacles();
        Assertions.assertEquals(y-8, obstacles1.size());

    }

    @Test
    public void numberObstacles2(){
        int x = 120;
        int y = 40;
        Game game1 = new Game(x, y);
        List<Obstacle> obstacles1 = game1.display.createObstacles();
        Assertions.assertEquals(y-8, obstacles1.size());

    }

}
