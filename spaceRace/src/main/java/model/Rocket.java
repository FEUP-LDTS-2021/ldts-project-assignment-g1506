package model;

public class Rocket extends Element {
    private int score;
    private String color;

    public Rocket(int x, int y){
        super(x,y);
    }

    @Override
    public Position getPosition(){
        return super.getPosition();
    }

    @Override
    public void setPosition(Position position){
        super.setPosition(position);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
