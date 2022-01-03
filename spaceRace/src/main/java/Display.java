import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Display {
    private int width;
    private int height;
    private Rocket rocket1;
    private Rocket rocket2;

    public Display(int width, int height){
        this.width = width;
        this.height = height;
        rocket1 = new Rocket(width/3,height-1);
        rocket2 = new Rocket((width/3)*2,height-1);

    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void draw(TextGraphics graphics) {
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        rocket1.draw(graphics);
        rocket2.draw(graphics);
    }
}
