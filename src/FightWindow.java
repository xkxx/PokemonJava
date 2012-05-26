
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class FightWindow extends java.applet.Applet implements Runnable, KeyListener{
	
	Image buffer;
	Graphics gBuffer;
	Thread t;
	
	Player player;
	
	public void run(){
		while(true){
			repaint();
			try{
				Thread.sleep(10);
			}catch(Exception e){}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
