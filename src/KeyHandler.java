
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{
    
    Demo dm;
    public KeyHandler(Demo dm){
        this.dm = dm;
    }
    public void keyTyped(KeyEvent e){
        
    }
     public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_ENTER){
//            dm.search();
                dm.Autosearch();
        }
    }
      public void keyReleased(KeyEvent e){
        
    }
}
