
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class PokemonandCharTest extends java.applet.Applet implements Runnable, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image buffer;
	Graphics gBuffer;
	Thread t;

	MouseEvent mouse;
	boolean mouseClicked=false;

	ArrayList<PokemonFrame> playerspokemon = new ArrayList<PokemonFrame>();
	ArrayList<PokemonFrame> enemypokemon =new ArrayList<PokemonFrame>();
	public void init(){
		setSize(600,300);
		addMouseListener(this);
		//charmander=new Charmander(5);
		mouseClicked=false;
		playerspokemon.add(new PokemonFrame(000));
		playerspokemon.add(new PokemonFrame(004));
		enemypokemon.add(new PokemonFrame(004));
		playerspokemon.get(0).healPokemon();
		enemypokemon.get(0).healPokemon();

		//playerspokemon.get(0).attacks(enemypokemon.get(0),1);
		//enemypokemon.get(0).attacks(playerspokemon.get(0),0);
		//playerspokemon.get(0).addExp(enemypokemon.get(0));
		for(int i=0;i<playerspokemon.size();i++){
			System.out.println(playerspokemon.get(i).getName());
		}
		buffer = createImage(this.getWidth(), this.getHeight());
		gBuffer = buffer.getGraphics();
		t = new Thread(this);
		t.start();
	}
	public void run() {
		while(true){
			if(mouseClicked){
				mouseClicked=false;
				if(mouse.getY()>=200&&mouse.getY()<=250&&mouse.getX()>=300&&mouse.getX()<=400){
					playerspokemon.get(0).attacks(enemypokemon.get(0),0, null);
					enemypokemon.get(0).attacks(playerspokemon.get(0),99, null);
				}
				else if(mouse.getY()>=200&&mouse.getY()<=250&&mouse.getX()>=400&&mouse.getX()<=500){
					playerspokemon.get(0).attacks(enemypokemon.get(0),1, null);
					enemypokemon.get(0).attacks(playerspokemon.get(0),99, null);
				}
			}
			repaint();
			try{
				Thread.sleep(10);
			}catch(Exception e){}
		}
	}

	public void update(Graphics g){paint(g);}
	public void paint(Graphics g){
		gBuffer.setColor(Color.black);
		gBuffer.fillRect(0,0,600,300);

		gBuffer.drawImage(playerspokemon.get(0).getBack(), 10, 200, null);
		gBuffer.drawImage(enemypokemon.get(0).getFront(), 400, 10, null);
		gBuffer.setColor(Color.blue);
		gBuffer.fillRect(300, 200, 200, 200);
		gBuffer.setColor(Color.green);
		gBuffer.drawRect(300, 200, 100, 50);
		gBuffer.setColor(Color.green);
		gBuffer.drawRect(400, 200, 100, 50);
		gBuffer.drawRect(400, 250, 100, 50);
		gBuffer.drawRect(300, 250, 100, 50);
		gBuffer.drawString("Attack-1", 320, 225);
		gBuffer.drawString("Attack-2", 320, 275);
		gBuffer.drawString("Attack-3", 420, 275);
		gBuffer.drawString("Attack-4", 420, 225);
		gBuffer.drawString("Enemy HP: "+enemypokemon.get(0).getHP(), 250, 50);
		gBuffer.drawString("Enemy Level: "+enemypokemon.get(0).getLevel(), 250, 70);
		gBuffer.drawString("Enemy Exp: "+enemypokemon.get(0).getLevelEXP(), 250, 90);
		gBuffer.drawString("Enemy Pokedex Number: "+enemypokemon.get(0).getNumber(), 250, 110);
		gBuffer.drawString("Player HP:  "+playerspokemon.get(0).getHP(), 150, 210);
		gBuffer.drawString("Player Level: "+playerspokemon.get(0).getLevel(), 150, 230);
		gBuffer.drawString("Player Exp: "+playerspokemon.get(0).getLevelEXP(), 150, 250);
		//gBuffer.drawString(player_pkmn.name + " HP: "+charmander.HP + " ATT: "+charmander.ATT+ " DEF: "+charmander.DEF+ " SPEED: "+charmander.SPEED+ " SPEC: "+charmander.SPEC,10,10);
		/*
		for(int i=0; i<500; i++){
			if(i%5!=0) gBuffer.setColor(Color.white);
			else gBuffer.setColor(Color.red);

			gBuffer.drawLine(i*5,0,i*5, 5000);
			gBuffer.drawLine(0, i*5, 5000, i*5);
		}
		 */
		g.drawImage(buffer,0,0,this);
	}
	public void mouseClicked(MouseEvent e) {
		mouseClicked=true;
		mouse=e;
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
	public void mouseReleased(MouseEvent arg0) {
		mouseClicked=true;

	}
}
