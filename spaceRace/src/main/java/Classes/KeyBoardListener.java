package Classes;

import gui.GUI;

public interface KeyBoardListener {
    default void keyPressed(GUI.ACTION action){
        
        System.out.println("pressed");
    }
}
