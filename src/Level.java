import java.awt.*;
import java.io.*;
import java.util.*;


public class Level {

	// array for the block collisions
	ArrayList<Block> blocks;
	ArrayList<Block> walkable;
	// player object
	Player player;

	public Level(String filename, Player p){
		// set up initial variables
		player = p;
		int height = 15;
		blocks = new ArrayList<Block>();
		walkable =new ArrayList<Block>();
		// read in the given map file
		File f = new File("../maps/" + filename);	
		try{
			Scanner input = new Scanner(f);	
			for(int l=0; l<height; l++){	
				String line = input.nextLine();		
				for(int c=0; c<line.length(); c++){
					char ch = line.charAt(c);
					// type of blocks listed here with there map keys
					switch(ch){
					case 'w':  blocks.add(new Block(c*Block.size, l*Block.size, 3)); break;
					case 'g':  blocks.add(new Block(c*Block.size, l*Block.size, 4)); break;
					case 't':  blocks.add(new Block(c*Block.size, l*Block.size, 6)); break;
					case 'b':  blocks.add(new Block(c*Block.size, l*Block.size, 5)); break;
					
					}
				}
			}
		}catch(Exception e) { e.printStackTrace(); }
	}

	// play function
	// enemies and other things would go here
	public void play(){
		player.move(blocks);
	}
	
	// paint the level
	public void paintLevel(Graphics g){
		// draw background
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);

		// draw the blocks
		for(int i=0; i<blocks.size(); i++){
			blocks.get(i).paintBlock(g);
		}
		
		// draw the player
		player.paintPlayer(g);
	}
}
