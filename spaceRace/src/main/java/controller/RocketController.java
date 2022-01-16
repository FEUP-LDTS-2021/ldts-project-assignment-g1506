package controller;

import Classes.Game;
import gui.GUI;
import model.Display;
import model.Position;
import model.Rocket;

import java.io.IOException;

public class RocketController {
    private Rocket rocket;
    private Display display;

    public RocketController(Display display,Rocket rocket) {
        this.rocket = rocket;
        this.display = display;
    }

    public Position moveUp(){return new Position(rocket.getPosition().getX(), rocket.getPosition().getY()-1);}
    public Position moveDown(){return new Position(rocket.getPosition().getX(), rocket.getPosition().getY()+1);}

    public Position initialPosition(){
        rocket.getPosition().setY(display.getHeight()-1);
        return new Position(rocket.getPosition().getX(),rocket.getPosition().getY());
    }
    public Position doAction(GUI.ACTION action) {

        if (rocket.getPosition().getY()==0) {
            return initialPosition();
        }

        if (action == GUI.ACTION.UP && rocket.getPosition().getY()>0){
            return moveUp();
        }

        if (action == GUI.ACTION.DOWN)
            return moveDown();

        //display.rocket2.setPosition(rocket.getPosition());
        return null;
    }

    //public Position moveUp(){return}
}
