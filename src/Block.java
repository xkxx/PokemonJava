import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Block extends Rectangle {

	int type;
	static int size = 32;
	Image image;
	
	// all images for the blocks go here
	static Image brick = new ImageIcon("../images/brick.png").getImage();
	static Image grass = new ImageIcon("../images/grass.png").getImage();
	static Image grassp = new ImageIcon("../images/tile1.png").getImage();
	static Image grassw = new ImageIcon("../images/tile2.png").getImage();
	static Image tree = new ImageIcon("../images/tile3.png").getImage();
	static Image treet = new ImageIcon("../images/tile4.png").getImage();
	
	public Block(int xpos, int ypos, int t){
		type = t;
		x = xpos;
		y = ypos;
		width = height = size;
		
		// set the image of the block depending on its type
		switch(type){
		case 1: image = brick; break;
		case 2: image = grass; break;
		case 3: image= grassp; break;
		case 4: image= grassw; break;
		case 5: image= tree; break;
		case 6: image= treet; break;
		
		}
		
	}
	
	// draw the blocks image if it is on screen
	public void paintBlock(Graphics g){
		if(x>-45 && x<805){
			g.drawImage(image, x, y, null);
		}
	}
}
