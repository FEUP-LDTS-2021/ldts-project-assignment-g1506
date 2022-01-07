import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Display {
    private int width; // largura
    private int height; //altura
    private Rocket rocket1;
    private Rocket rocket2;
    private List<Obstacle> obstacles;

    public Display(int width, int height){
        this.width = width;
        this.height = height;
        rocket1 = new Rocket(width/3,height-1);
        rocket2 = new Rocket((width/3)*2,height-1);
        obstacles = createObstacles();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Position moveUp1(){
        Position pos = new Position(rocket1.getPosition().getX(), rocket1.getPosition().getY()-1);
        rocket1.setPosition(pos);
        return pos;
    }
    public Position moveDown1(){
        Position pos = new Position(rocket1.getPosition().getX(), rocket1.getPosition().getY()+1);
        rocket1.setPosition(pos);
        return pos;
    }

    public Position moveUp2(){
        return new Position(rocket2.getPosition().getX(), rocket2.getPosition().getY()-1);
    }
    public Position moveDown2(){
        return new Position(rocket2.getPosition().getX(), rocket2.getPosition().getY()+1);
    }

    public void moveRocket1(Position position){
        rocket1.setPosition(position);
    }

    public void moveRocket2(Position position){
        rocket2.setPosition(position);
    }

    public List<Obstacle> createObstacles(){
        List<Obstacle> obstacles = new ArrayList<>();

        for(int i = 0; i< height - 8 ; i++){
            Random rand = new Random();
            Obstacle obs = new Obstacle(rand.nextInt(width), i);
            obstacles.add(obs);
        }

        return obstacles;
    }

    public void draw(TextGraphics graphics) {
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        rocket1.draw(graphics);
        rocket2.draw(graphics);

        for(Obstacle obstacle: obstacles) {
            obstacle.draw(graphics);
        }
    }
}
