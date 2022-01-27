package gui;

import State.KeyBoardListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;

public class KeyBoardObserver extends KeyAdapter {
    private KeyBoardListener listener;

    public KeyBoardObserver(){
        //keys = new HashMap<>();
        //keys.put(KeyEvent.VK_ESCAPE, GUI.ACTION.QUIT);
    }
/*
    HashMap<Integer, GUI.ACTION> keys;

    public void keyPressed1(KeyEvent e) {
        listener.keyPressed(keys.get(e));
    }
  */

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                listener.keyPressed(GUI.ACTION.QUIT);
                break;
            case KeyEvent.VK_UP:
                listener.keyPressed(GUI.ACTION.UP2);
                break;
            case KeyEvent.VK_DOWN:
                listener.keyPressed(GUI.ACTION.DOWN2);
                break;
            case KeyEvent.VK_W:
                listener.keyPressed(GUI.ACTION.UP1);
                break;
            case KeyEvent.VK_S:
                listener.keyPressed(GUI.ACTION.DOWN1);
                break;
            case KeyEvent.VK_P:
                listener.keyPressed(GUI.ACTION.PAUSE);
                break;
            case KeyEvent.VK_ENTER:
                listener.keyPressed(GUI.ACTION.ENTER);
                break;
            case KeyEvent.VK_SPACE:
                listener.keyPressed(GUI.ACTION.ENTER);
                break;
        }
    }
    public void setListener(KeyBoardListener listener){ this.listener = listener;}
}
