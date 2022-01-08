import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ObstaclesTest {

    @Test
    public void numberObstacles(){
        Game game1 = new Game();
        List<Obstacle> obstacles1 = game1.display.createObstacles();
        Assertions.assertEquals(game1.getHeight()-8, obstacles1.size());
    }

}
