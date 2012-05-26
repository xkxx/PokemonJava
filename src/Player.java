import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class Player extends Rectangle {


	// variables for controlling the players movement
	int xSpeed, ySpeed;
	boolean movingUp, movingDown;
	boolean movingLeft, movingRight;
	Image player_image;	// players image

	
	ArrayList<PokemonFrame> playerspokemon = new ArrayList<PokemonFrame>();

	
	public Player(){
		// initial values
		x = 380;
		y = 280;
		width = 40;
		height = 40;
		playerspokemon.add(new PokemonFrame(1));
		xSpeed = 2;
		ySpeed = 2;
		player_image=new ImageIcon("../images/Down.png").getImage();
		movingUp = movingDown = false;
		movingLeft = movingRight = false;
	}

	public void paintPlayer(Graphics g){
		if(movingUp){
			player_image=new ImageIcon("../images/Up.png").getImage();
		}
		if(movingDown){
			player_image=new ImageIcon("../images/Down.png").getImage();
		}
		if(movingRight){
			player_image=new ImageIcon("../images/Right.png").getImage();
		}
		if(movingLeft){
			player_image=new ImageIcon("../images/Left.png").getImage();
		}
		//g.setColor(Color.blue);
		//g.fillRect(x, y, width, height);
		g.drawImage(player_image, x, y, null);
	}

	public int leftX()  { return x; }
	public int rightX() { return x+width; }
	public int topY()   { return y; }
	public int bottomY(){ return y+height; }

	// player movement
	public void move(ArrayList<Block> blocks){
		// check for block collisions
		for(int i=0; i<blocks.size(); i++){
			// stop moving up
			if(blocks.get(i).intersects(x, y-ySpeed, width, height)&&blocks.get(i).type!=3&&blocks.get(i).type!=4){
				movingUp = false;
			}
			// stop moving down
			if(blocks.get(i).intersects(x, y+ySpeed, width, height)&&blocks.get(i).type!=3&&blocks.get(i).type!=4){
				movingDown = false;
			}
			// stop moving left
			if(blocks.get(i).intersects(x-xSpeed, y, width, height)&&blocks.get(i).type!=3&&blocks.get(i).type!=4){
				movingLeft = false;
			}
			// stop moving right
			if(blocks.get(i).intersects(x+xSpeed, y, width, height)&&blocks.get(i).type!=3&&blocks.get(i).type!=4){
				movingRight = false;
			}
		}
		// move the player
		for(int i=0; i<blocks.size(); i++){
			if(movingUp){
				blocks.get(i).y += ySpeed;
			}
			if(movingDown){
				blocks.get(i).y -= ySpeed;
			}
			if(movingLeft){
				blocks.get(i).x += xSpeed;
			}
			if(movingRight){
				blocks.get(i).x -= xSpeed;
			}
		}

	}
}
