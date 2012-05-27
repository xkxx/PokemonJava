import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class BattleScene {
	MouseEvent mouse;
	boolean mouseClicked=false;
	TextArea output;
	ArrayList<PokemonFrame> playerspokemon = new ArrayList<PokemonFrame>();
	ArrayList<PokemonFrame> enemypokemon =new ArrayList<PokemonFrame>();
	public BattleScene(){
		playerspokemon.add(new PokemonFrame(001));
		playerspokemon.add(new PokemonFrame(004));
		playerspokemon.add(new PokemonFrame(012));
		playerspokemon.add(new PokemonFrame(001));
		playerspokemon.add(new PokemonFrame(004));
		playerspokemon.add(new PokemonFrame(012));
		playerspokemon.add(new PokemonFrame(001));


		enemypokemon.add(new PokemonFrame(004));
		//enemypokemon.get(0).HP=10;
		output=new TextArea(30,9,10,10);
		//playerspokemon.get(0).HP+=100;

		//playerspokemon.get(0).attacks(enemypokemon.get(0),1);
		//enemypokemon.get(0).attacks(playerspokemon.get(0),0);
		//playerspokemon.get(0).addExp(enemypokemon.get(0));
		for(int i=0;i<playerspokemon.size();i++){
			System.out.println(playerspokemon.get(i).getName());
			System.out.println(i);
		}
	}
	public void play(){
		//System.out.println(playerspokemon.size());
		//System.out.println(enemypokemon.size());
		if(mouseClicked){
			mouseClicked=false;
			if(mouse.getY()>=200&&mouse.getY()<=250&&mouse.getX()>=300&&mouse.getX()<=400){
				playerspokemon.get(0).attacks(enemypokemon.get(0),0,output);
				enemypokemon.get(0).attacks(playerspokemon.get(0),99,output);
			}
			else if(mouse.getY()>=200&&mouse.getY()<=250&&mouse.getX()>=400&&mouse.getX()<=500){
				playerspokemon.get(0).attacks(enemypokemon.get(0),1, output);
				enemypokemon.get(0).attacks(playerspokemon.get(0),99, output);
			}
		}
		if(playerspokemon.get(0).fainted==true){
			PokemonFrame temp=playerspokemon.get(0);
			playerspokemon.remove(0);
			playerspokemon.add(temp);
		}
		if(enemypokemon.get(0).fainted==true){
			output.add(enemypokemon.get(0).name+" has fainted.", Color.magenta);
			playerspokemon.get(0).expUp(enemypokemon.get(0).level);
		}

	}
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0,0,600,300);
		output.paint(g);
		g.drawImage(playerspokemon.get(0).getBack(), 10, 200, null);
		g.drawImage(enemypokemon.get(0).getFront(), 400, 10, null);
		g.setColor(Color.blue);
		g.fillRect(300, 200, 200, 100);
		g.setColor(Color.green);
		g.drawRect(300, 200, 100, 50);
		g.setColor(Color.green);
		g.drawRect(400, 200, 100, 50);
		g.drawRect(400, 250, 100, 50);
		g.drawRect(300, 250, 100, 50);
		g.drawString("Attack-1", 320, 225);
		g.drawString("Attack-2", 320, 275);
		g.drawString("Attack-3", 420, 275);
		g.drawString("Attack-4", 420, 225);
		g.drawString("Enemy HP: "+enemypokemon.get(0).getHP(), 250, 50);
		g.drawString("Enemy Level: "+enemypokemon.get(0).getLevel(), 250, 70);
		g.drawString("Enemy Exp: "+enemypokemon.get(0).getLevelEXP(), 250, 90);
		g.drawString("Enemy Pdex Number: "+enemypokemon.get(0).getNumber(), 250, 110);
		g.drawString("Player HP:  "+playerspokemon.get(0).getHP(), 150, 210);
		g.drawString("Player Level: "+playerspokemon.get(0).getLevel(), 150, 230);
		g.drawString("Player Exp: "+playerspokemon.get(0).getLevelEXP(), 150, 250);

		//g.drawString(player_pkmn.name + " HP: "+charmander.HP + " ATT: "+charmander.ATT+ " DEF: "+charmander.DEF+ " SPEED: "+charmander.SPEED+ " SPEC: "+charmander.SPEC,10,10);
		/*
		for(int i=0; i<500; i++){
			if(i%5!=0) g.setColor(Color.white);
			else g.setColor(Color.red);

			g.drawLine(i*5,0,i*5, 5000);
			g.drawLine(0, i*5, 5000, i*5);
		}
		 */
		//g.drawImage(buffer,0,0,this);
	}
}
