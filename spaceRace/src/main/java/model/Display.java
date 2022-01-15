package model;

import Classes.MoveObstacles;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import gui.LanternaGUI;
import model.Obstacle;
import model.Position;
import model.Rocket;
import model.Wall;
import view.element.ArrowView;
import view.element.ObstacleView;
import view.element.RocketView;
import view.element.WallView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Display {
    private int width;
    private int height;
    public Rocket rocket1;
    public Rocket rocket2;
    public List<Obstacle> obstacles;
    public List<Wall> walls;
    private final LanternaGUI gui;
    private RocketView rocketView = new RocketView();
    private WallView wallView = new WallView();
    private ObstacleView obstacleView = new ObstacleView();

    public Display(int width, int height, LanternaGUI gui){
        this.width = width;
        this.height = height;
        rocket1 = new Rocket(width/3,height-3);
        rocket2 = new Rocket((width/3)*2,height-3);
        obstacles = createObstacles();
        walls = createWalls();
        this.gui = gui;
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

    public void MoveObstacles(){

        for (Obstacle obstacle: obstacles) {
            if(colisionWall(obstacle.getPosition().getX(),obstacle)==true)
                continue;
            else{
                if(obstacle.getDirection()==true)
                    moveRight(obstacle);
                else
                    moveLeft(obstacle);
            }
        }
    }

    public boolean colisionWall(int x, Obstacle obstacle){
        if (x<0){
            obstacle.setDirection(true);
            moveRight(obstacle);
            return true;
        }
        if(x>width){
            obstacle.setDirection(false);
            moveLeft(obstacle);
            return true;
        }
        return false;
    }

    public void moveRight(Obstacle obstacle){
        obstacle.position.setX(obstacle.position.getX()+1);
    }

    public void moveLeft(Obstacle obstacle){
        obstacle.position.setX(obstacle.position.getX()-1);
    }

    public void draw() throws IOException {

        gui.clear();

        rocketView.drawElement(rocket1, gui);
        rocketView.drawElement(rocket2, gui);

        for(Wall wall : walls){
            wallView.drawElement(wall, gui);
        }

        for(Obstacle obstacle : obstacles){
            obstacleView.drawElement(obstacle, gui);
        }

        MoveObstacles();

        gui.refresh();
    }
}
