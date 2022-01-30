package model;

public class Obstacle extends Element {
    boolean direction = true; // true obstacle move to right direction

    public Obstacle(int x, int y){
        super(x,y);
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }
}
