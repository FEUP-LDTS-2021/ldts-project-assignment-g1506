package gui;

import State.KeyBoardListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyBoardObserver extends KeyAdapter {
    private KeyBoardListener listener;
    HashMap<Integer, GUI.ACTION> keys;

    public KeyBoardObserver(){
        keys = new HashMap<>();
        keys.put(KeyEvent.VK_ESCAPE, GUI.ACTION.QUIT);
        keys.put(KeyEvent.VK_UP, GUI.ACTION.UP2);
        keys.put(KeyEvent.VK_DOWN, GUI.ACTION.DOWN2);
        keys.put(KeyEvent.VK_W, GUI.ACTION.UP1);
        keys.put(KeyEvent.VK_S, GUI.ACTION.DOWN1);
        keys.put(KeyEvent.VK_ENTER, GUI.ACTION.ENTER);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        listener.keyPressed(keys.get(e.getKeyCode()));
    }
    
    public void setListener(KeyBoardListener listener){ this.listener = listener;}
}
