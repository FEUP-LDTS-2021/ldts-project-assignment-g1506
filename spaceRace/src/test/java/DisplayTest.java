import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DisplayTest {

    //Tests if the rockets are in the right initial position
    @Test
    public void RocketInitialPosition(){
        int x = 120;
        int y = 40;
        Game game = new Game(x,y);
        int width1 = game.display.rocket1.getPosition().getX();
        int height1 = game.display.rocket1.getPosition().getY();
        int width2 = game.display.rocket2.getPosition().getX();
        int height2 = game.display.rocket2.getPosition().getY();

        Assertions.assertEquals(x/3, width1);
        Assertions.assertEquals((x/3)*2, width2);
        Assertions.assertEquals(y-1, height1);
        Assertions.assertEquals(y-1, height2);
    }

    //Tests if both rockets move up
    @Test
    public void moveUp(){
        int x = 120;
        int y = 40;
        Game game1 = new Game(x, y);
        Position pos1 = game1.display.rocket1.position;
        Position pos2 = game1.display.rocket2.position;

        game1.display.moveRocket1(game1.display.moveUp1());
        game1.display.moveRocket2(game1.display.moveUp2());

        Assertions.assertEquals(pos1.getY()-1, game1.display.rocket1.position.getY());
        Assertions.assertEquals(pos2.getY()-1, game1.display.rocket2.position.getY());

        game1.display.moveRocket1(game1.display.moveUp1());
        game1.display.moveRocket2(game1.display.moveUp2());

        Assertions.assertEquals(pos1.getY()-2, game1.display.rocket1.position.getY());
        Assertions.assertEquals(pos2.getY()-2, game1.display.rocket2.position.getY());

    }

    //Tests if both rockets move down
    @Test
    public void moveDown(){
        int x = 120;
        int y = 40;
        Game game1 = new Game(x, y);
        Position pos1 = game1.display.rocket1.position;
        Position pos2 = game1.display.rocket2.position;

        game1.display.moveRocket1(game1.display.moveDown1());
        game1.display.moveRocket2(game1.display.moveDown2());

        Assertions.assertEquals(pos1.getY()+1, game1.display.rocket1.position.getY());
        Assertions.assertEquals(pos2.getY()+1, game1.display.rocket2.position.getY());

        game1.display.moveRocket1(game1.display.moveDown1());
        game1.display.moveRocket2(game1.display.moveDown2());

        Assertions.assertEquals(pos1.getY()+2, game1.display.rocket1.position.getY());
        Assertions.assertEquals(pos2.getY()+2, game1.display.rocket2.position.getY());

    }

    //Tests if the number of obstacles is right
    @Test
    public void numberObstacles1(){
        int x = 120;
        int y = 40;
        Game game1 = new Game(x, y);
        List<Obstacle> obstacles = game1.display.createObstacles();
        Assertions.assertEquals(y-8, obstacles.size());

    }
    @Test
    public void numberObstacles2(){
        int x = 100;
        int y = 30;
        Game game1 = new Game(x, y);
        List<Obstacle> obstacles = game1.display.createObstacles();
        Assertions.assertEquals(y-8, obstacles.size());

    }
    @Test
    public void numberObstacles3(){
        int x = 90;
        int y = 20;
        Game game1 = new Game(x, y);
        List<Obstacle> obstacles = game1.display.createObstacles();
        Assertions.assertEquals(y-8, obstacles.size());

    }

    //Tests if the number of walls is right
    @Test
    public void numberWalls1(){
        int x = 120;
        int y = 40;

        Game game1 = new Game(x, y);
        List<Wall> walls = game1.display.createWalls();
        Assertions.assertEquals(y-1, walls.size());
    }
    @Test
    public void numberWalls2(){
        int x = 100;
        int y = 30;

        Game game1 = new Game(x, y);

        List<Wall> walls = game1.display.createWalls();
        Assertions.assertEquals(y-1, walls.size());
    }

    //Tests if walls are in the right position
    @Test
    public void wallPosition(){
        int x = 100;
        int y = 30;
        boolean aux=true;

        Game game1 =new Game(x,y);
        List<Wall> walls = game1.display.createWalls();
        int width = walls.get(0).position.getX();
        Assertions.assertEquals(x/2, width);

        for(Wall wall: walls) {
            if(wall.getPosition().getX() != x/2)
                aux=false;
        }
        Assertions.assertEquals(true, aux);
    }

}
