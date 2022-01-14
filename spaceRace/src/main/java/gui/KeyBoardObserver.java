package gui;

import Classes.KeyBoardListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoardObserver extends KeyAdapter {
    private KeyBoardListener listener;

    public KeyBoardObserver(){}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                listener.keyPressed(GUI.ACTION.QUIT);
                break;
            case KeyEvent.VK_A:
                listener.keyPressed(GUI.ACTION.LEFT);
                break;
            case KeyEvent.VK_D:
                listener.keyPressed(GUI.ACTION.RIGHT);
                break;
            case KeyEvent.VK_W:
                listener.keyPressed(GUI.ACTION.UP);
                break;
            case KeyEvent.VK_S:
                listener.keyPressed(GUI.ACTION.DOWN);
                break;
            case KeyEvent.VK_P:
                listener.keyPressed(GUI.ACTION.PAUSE);
                break;
        }
    }
    public void setListener(KeyBoardListener listener){ this.listener = listener;}
}
