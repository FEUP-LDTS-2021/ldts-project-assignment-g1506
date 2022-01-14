package Classes;

import model.Display;
import model.Obstacle;

public class MoveObstacles {
    private int width;

    public MoveObstacles(Display display){

        this.width=display.getWidth();

        for (Obstacle obstacle: display.obstacles) {
            if(colisionWall(obstacle.position.getX(),obstacle)==true)
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
}
