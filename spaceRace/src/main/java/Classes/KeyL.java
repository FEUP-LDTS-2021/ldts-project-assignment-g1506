package Classes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyL extends Frame implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("Tecla");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tecla");
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
