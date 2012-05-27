import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


public class MovementTest extends java.applet.Applet implements Runnable,MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;
	Image buffer;
	Graphics gBuffer;
	Thread t;

	// player and level object
	Player player;
	Level currentLevel;
	boolean gameover, gamestart, battlescene;
	BattleScene b =new BattleScene();

	public void init(){
		setSize(800, 600);
		addKeyListener(this);
		addMouseListener(this);
		// setup player and current level
		for(int i=0;i<b.playerspokemon.size();i++){
			b.playerspokemon.get(i).healPokemon();
			//b.enemypokemon.get(i).healPokemon();
		}
		player = new Player();
		currentLevel = new Level("level1", player);
		buffer = createImage(this.getWidth(), this.getHeight());
		gBuffer = buffer.getGraphics();
		t = new Thread(this);
		t.start();
	}

	public void run(){
		while(true){
			if(battlescene==false){
				currentLevel.play();
			}
			else{
				if(b.enemypokemon.get(0).fainted==true||b.playerspokemon.get(0).fainted==true){
					battlescene=false;

				}
				if(b.enemypokemon.get(0).fainted==true){
					b.enemypokemon.remove(0);
					Random rgen=new Random( );
					int i=rgen.nextInt(12);
					b.enemypokemon.add(new PokemonFrame(i));
				}
				else{
					b.play();
				}
				//b.play();
			}
			repaint();
			try{
				Thread.sleep(10);
			}catch(Exception e){}
		}
	}
	public void update(Graphics g){ paint(g); } 

	public void paint(Graphics g){
		gBuffer.setColor(Color.black);		// draw a black background
		gBuffer.fillRect(0, 0, 800, 600);
		// paint the level
		if(battlescene){
			gBuffer.setColor(Color.black);
			gBuffer.fillRect(0,0,800,600);
			b.paint(gBuffer);
		}
		else{
			currentLevel.paintLevel(gBuffer);
		}
		g.drawImage(buffer, 0, 0, this);
	}

	// keyboard movement controls for player
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyChar();
		switch(key){
		case 'd': player.movingRight = true; break;
		case 'a': player.movingLeft = true; break;
		case 'w': player.movingUp = true; break;
		case 's': player.movingDown = true; break;
		//case 't': battlescene=true;break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyChar();
		switch(key){
		case 'd': player.movingRight = false;break;
		case 'a': player.movingLeft = false; break;
		case 'w': player.movingUp = false; break;
		case 's': player.movingDown = false; break;
		case 't': battlescene=!battlescene;break;
		case 'h':b.playerspokemon.get(0).healPokemon(); break;
		case 'p':System.out.println(b.enemypokemon.size());break;
		}
	}

	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		b.mouseClicked=true;
		b.mouse=e;
		System.out.println("Here I am at MouseClicked");		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
