package view.state;

import gui.GUI;
import model.Position;
import model.Rocket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EndGameView extends StateView{
    private final Rocket rocket1;
    private final Rocket rocket2;

    public EndGameView(GUI gui, Rocket rocket1, Rocket rocket2) {
        super(gui);
        this.rocket1 = rocket1;
        this.rocket2 = rocket2;
    }

    @Override
    public void draw() throws IOException {
        if (rocket1.getScore() == rocket2.getScore()-10) {
            int x = 20;
            gui.drawText(gui.createTextGraphics(), new Position(x, 10), " $$$$$$   $$$$$$  $$$   $$$$$          $$$      $$$$$$    $$$$$$    $$$$$$", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 11), "   $$       $$    $$    $$            $ $$        $$        $$      $$    ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 12), "   $        $     $    $$$            $ $$        $         $      $$$    ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 13), "   $        $          $$$$$         $$ $$        $         $      $$$    ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 14), "  $$       $$           $$$$$        $$ $$       $$        $$      $$$$   ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 15), "  $$       $$              $$       $$$ $$       $$        $$      $$     ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 16), "  $        $               $$       $$$$$$       $         $       $$     ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 17), "$$$$       $           $$$$$        $$ $$$       $       $$$$      $$$$   ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 18), "$$$$$     $$           $$$$        $$  $$$      $$       $$$$$     $$$$$  ", "#FFFAFA");

        }

        else{
            int x = 20;

            gui.drawText(gui.createTextGraphics(), new Position(x, 10), "  $$$$$$     $$          $$$   $$  $$    $$$$$$     $$$$$$", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 11), " $$$  $$    $$$         $ $$   $$  $     $$        $$$  $$", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 12), " $$$  $     $$$         $ $$   $$ $$    $$$        $$$  $ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 13), " $$   $     $$         $$ $$    $$$     $$$        $$$ $$ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 14), " $$$$$$     $$         $$ $$    $$$     $$$$       $$$$$$ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 15), " $$         $$        $$$ $$    $$      $$         $$  $$ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 16), " $          $         $$$$$$    $       $$         $   $$ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 17), " $          $$$$      $$ $$$    $       $$$$       $   $$ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x, 18), "$$         $$$$$$$   $$  $$$   $$       $$$$$     $$  $$$ ", "#FFFAFA");

            gui.drawText(gui.createTextGraphics(), new Position(x+25, 21), " $    $    $$$$$$     $$   $", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x+25, 22), "$$    $   $$$  $$    $$$   $", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x+25, 23), "$$ $ $$   $$   $$    $$$  $$", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x+25, 24), "$$ $ $    $$   $     $$$$ $ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x+25, 25), "$$$$$$    $$   $     $$$$ $ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x+25, 26), "$$$$$$    $   $$     $  $ $ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x+25, 27), "$$$$$$    $   $$     $  $$$ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x+25, 28), "$$ $$     $$$$$$     $  $$$ ", "#FFFAFA");
            gui.drawText(gui.createTextGraphics(), new Position(x+25, 29), "$$ $$     $$$$$     $$  $$$ ", "#FFFAFA");

            if(rocket1.getScore() > rocket2.getScore()-10){
                gui.winner1();
            }

            if(rocket1.getScore() < rocket2.getScore()-10){
                gui.winner2();
            }

        }
        gui.refresh();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
