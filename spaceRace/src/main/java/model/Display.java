package model;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.Obstacle;
import model.Position;
import model.Rocket;
import model.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Display {
    private int width;
    private int height;
    public Rocket rocket1;
    public Rocket rocket2;
    public List<Obstacle> obstacles;
    private List<Wall> walls;

    public Display(int width, int height){
        this.width = width;
        this.height = height;
        rocket1 = new Rocket(width/3,height-1);
        rocket2 = new Rocket((width/3)*2,height-1);
        obstacles = createObstacles();
        walls = createWalls();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Position moveUp1(){return new Position(rocket1.getPosition().getX(), rocket1.getPosition().getY()-1);}
    public Position moveDown1(){return new Position(rocket1.getPosition().getX(), rocket1.getPosition().getY()+1);}
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
        boolean aux=true;
        for(int i = 0; i< height - 8 ; i++){
            Random rand = new Random();
            Obstacle obs = new Obstacle(rand.nextInt(width), i);
            obs.setDirection(aux);

            if(aux==true) aux = false;

            else aux = true;

            obstacles.add(obs);
        }
        return obstacles;
    }


    public List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for(int i = height-1;  i > 0 ; i--){
            Wall wall = new Wall(width/2,i);
            walls.add(wall);
        }
        return walls;
    }

    public void draw(TextGraphics graphics) {
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        rocket1.draw(graphics);
        rocket2.draw(graphics);

        for(Obstacle obstacle: obstacles) {
            obstacle.draw(graphics);
        }

        for(Wall wall: walls) {
            wall.draw(graphics);
        }

    }
}
