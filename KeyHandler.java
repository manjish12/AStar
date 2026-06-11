import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    Demo dm;

    public KeyHandler(Demo dm) {
        this.dm = dm;
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            dm.autoSearch(); // ENTER still triggers search
        }
    }

    public void keyReleased(KeyEvent e) {}
}