package model;

public class Position {
    private int x;
    private int y;

    public Position(){}

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    @SuppressWarnings("EqualsHashCode")
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if (!(o instanceof Position)) return false;

        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}
}