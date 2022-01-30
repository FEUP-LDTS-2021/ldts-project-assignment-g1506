package controller;

import Classes.Game;

import java.io.IOException;

public abstract class Controller<T> {
    private T model;

    public Controller(T model) {this.model = model;}

    public abstract void step (Game game, long time) throws IOException;

}
