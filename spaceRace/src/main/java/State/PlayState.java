package State;

import Classes.Game;
import controller.PlayController;
import gui.GUI;
import model.Arena;
import model.ArenaLoader;

import java.io.IOException;

public class PlayState extends State{
    private PlayController playController;
    private Arena arena;
    private boolean aux = true;


    public PlayState(Game game, GUI gui) {
        super(game);
        this.arena = new ArenaLoader().createArena(game.getWidth(), game.getHeight());
        this.playController = new PlayController(this, gui, arena);
    }

    @Override
    public void start() {
        game.getKeyBoardObserver().setListener(playController);
    }

    @Override
    public void step(Game game, long time) throws IOException {
        if(firstTime()) game.setInitialTime(System.currentTimeMillis());
        playController.step(game, time);
    }

    public PlayController getPlayController() {
        return playController;
    }

    public void setPlayController(PlayController playController){
        this.playController = playController;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena){
        this.arena = arena;
    }

    public boolean firstTime(){
        if (aux == true){
            aux=false;
            return true;
        }
        else return false;
    }
}
