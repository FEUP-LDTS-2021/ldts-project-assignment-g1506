package State;

import Classes.Game;
import controller.MenuController;
import gui.GUI;

import java.io.IOException;

public class MenuState extends State {
    private MenuController menuController;

    public MenuState(Game game, GUI gui) {
        super(game);
        menuController =  new MenuController(this, gui);
    }

    @Override
    public void start() {
        game.getKeyBoardObserver().setListener(menuController);
    }

    @Override
    public void step(Game game, long time) throws IOException {
        this.menuController.step();
    }

    public MenuController getMenuController(){return menuController;}

    public void setMenuController(MenuController menuController){
        this.menuController = menuController;
    }
}
