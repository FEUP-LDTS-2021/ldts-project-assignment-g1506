package State;

import Classes.Game;
import controller.InstructionsController;
import gui.GUI;

import java.io.IOException;

public class InstructionsState extends State{
    private InstructionsController instructionsController;

    public InstructionsState(Game game, GUI gui) throws IOException {
        super(game);

        this.instructionsController = new InstructionsController(this,gui);
    }

    @Override
    public void start() {
        game.getKeyBoardObserver().setListener(instructionsController);
    }

    @Override
    public void step(Game game, long time) throws IOException {
        instructionsController.step();
    }

    public InstructionsController getInstructionsController() {
        return instructionsController;
    }

    public void setInstructionsController(InstructionsController instructionsController) {
        this.instructionsController = instructionsController;
    }
}
