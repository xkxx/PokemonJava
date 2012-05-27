import java.awt.*;
import java.util.Random;
import javax.swing.*;


public class PokemonFrame {

	String name;
	int base_hp,base_att,base_def,base_speed,base_spec;
	int HP = 17,ATT,DEF,SPEED,SPEC;
	int type;
	int level = 5; // default level should be 5
	double exp = 0;
	//int exp;
	int number=-1;
	boolean fainted = false;
	Random rgen=new Random(System.currentTimeMillis());
	String item;
	/*
	boolean gender;
	boolean isPlayer; //See if it is a Player or NPC
	boolean isWild; //See if it is a wild
	 */
	Image front_image, back_image, party_image;

	public int attack_damage;

	public PokemonFrame(int n){
		//System.out.println(name+" "+n);
		number = n;
		if(n==004){
			name="Charmander";
			front_image=new ImageIcon("../Pokemon/004.png").getImage();
			back_image=new ImageIcon("../Pokemon/004b.png").getImage();
			party_image=new ImageIcon("../Pokemon/004p.png").getImage();
			ATT=2*level+2;
			DEF = SPEED = SPEC = 2*level;
			base_hp=3*level+2;
			base_att = base_def = base_speed = base_spec = 2*level;
		}
		else if(n==001){
			name="Bulbasaur";
			front_image=new ImageIcon("../Pokemon/001.png").getImage();
			back_image=new ImageIcon("../Pokemon/001b.png").getImage();
			party_image=new ImageIcon("../Pokemon/004p.png").getImage();
			ATT=2*level+2;
			DEF = SPEED = SPEC = 2*level;
			base_hp=3*level+2;
			base_att = base_def = base_speed = base_spec = 2*level;
		}
		else if(n==002){
			name="Ivysaur";
			front_image=new ImageIcon("../Pokemon/002.png").getImage();
			back_image=new ImageIcon("../Pokemon/002b.png").getImage();
			party_image=new ImageIcon("../Pokemon/004p.png").getImage();
			ATT=2*level+2;
			DEF=2*level+3;
			SPEED = SPEC = 2*level;
			base_hp=3*level+2;
			base_att = base_def = base_speed = base_spec = 2*level;
		}
		else if(n==003){
			name="Venusaur";
			front_image=new ImageIcon("../Pokemon/003.png").getImage();
			back_image=new ImageIcon("../Pokemon/003b.png").getImage();
			party_image=new ImageIcon("../Pokemon/003p.png").getImage();
			ATT=2*level+2;
			DEF=2*level+9;
			SPEED = SPEC = 2*level;
			base_hp=3*level+2;
			base_att  = base_speed = base_spec = 2*level;
			base_def=2*level+9;
		}
		else if(n==005){
			name="Charmelion";
			front_image=new ImageIcon("../Pokemon/005.png").getImage();
			back_image=new ImageIcon("../Pokemon/005b.png").getImage();
			party_image=new ImageIcon("../Pokemon/003p.png").getImage();
			ATT = DEF = SPEED = SPEC = 2*level;
			base_hp=3*level+2;
			base_att=2*level+6+2;
			base_def = base_speed = base_spec = 2*level;
		}
		else if(n==006){
			name="Charzard";
			front_image=new ImageIcon("../Pokemon/006.png").getImage();
			back_image=new ImageIcon("../Pokemon/006b.png").getImage();
			party_image=new ImageIcon("../Pokemon/003p.png").getImage();
			ATT = DEF = SPEED = SPEC = 2*level;
			base_hp=3*level+9;
			base_att=2*level+6+2;
			base_def=2*level;
			base_speed=2*level+9;
			base_spec=2*level;
		}
		else if(n==007){
			name="Squirtle";
			front_image=new ImageIcon("../Pokemon/007.png").getImage();
			back_image=new ImageIcon("../Pokemon/007b.png").getImage();
			party_image=new ImageIcon("../Pokemon/003p.png").getImage();
			ATT = DEF = SPEED = SPEC = 2*level;
			base_hp=3*level+2;
			base_att=2*level+6+2;
			base_def = base_speed = base_spec = 2*level;
		}
		else if(n==012){//MissingNo or no pokemon number
			name="MissingNo";
			front_image=new ImageIcon("../Pokemon/000.png").getImage();
			back_image=new ImageIcon("../Pokemon/000b.png").getImage();
			party_image=new ImageIcon("../Pokemon/000p.png").getImage();
			ATT=2*level+2;
			DEF = SPEED = SPEC = 2*level;
			base_hp=3*level+2;
			base_att = base_def = base_speed = base_spec = 2*level;
		}
		else{
			name="MissingNo ... Bug";
			front_image=new ImageIcon("../Pokemon/000.png").getImage();
			back_image=new ImageIcon("../Pokemon/000b.png").getImage();
			party_image=new ImageIcon("../Pokemon/000p.png").getImage();
			ATT=2*level+2;
			DEF = SPEED = SPEC = 2*level;
			base_hp=3*level+2;
			base_att = base_def = base_speed = base_spec = 2*level;
		}
	}
	protected void attacks(PokemonFrame p, int a, TextArea output){
		String attackName;
		int damage=0;
		int hitPercent=0;
		int attackNum=-1;
	
		checkFaint();
		if(fainted==false||p.fainted==false){
			if(a==99){
				a=rgen.nextInt(4);
			}
			switch(a){
			case 0:
				attackName="Iron Tail                                 2";
				hitPercent=rgen.nextInt(100);
				if(hitPercent<=(85/*-(other pkmn's defence)/3*/)){ //Hit percent is 95
					int minDamage=((((2*level)*ATT*base_att/p.DEF)/50));
					int maxDamage=(5*(((2*level)*ATT*base_att/p.DEF)/50));
					int randomDamage=(minDamage+rgen.nextInt(maxDamage-minDamage));
					System.out.println("\n"+p.name+" gets hit by "+ name+ " for "+randomDamage+" damage.");
					System.out.println(attackName);
					output.add("\n"+p.name+" gets hit by "+ name+ " for "+randomDamage+" damage.", Color.red);
					p.HP-=randomDamage;
					//checkFaint();
				}
				else{
					System.out.println("No hit");
				}
				break;
			case 1:
				attackName="Surf                                          3";
				hitPercent=rgen.nextInt(100);
				if(hitPercent<=(85/*-(other pkmn's defence)/3*/)){ //Hit percent is 85
					int minDamage=((((2*level)*ATT*base_att/p.DEF)/50));
					int maxDamage=(5*(((2*level)*ATT*base_att/p.DEF)/50));
					int randomDamage=(minDamage+rgen.nextInt(maxDamage-minDamage));
					System.out.println("\n"+p.name+" gets hit by "+ name+ " for "+randomDamage+" damage.");
					System.out.println(attackName);
					output.add("\n"+p.name+" gets hit by "+ name+ " for "+randomDamage+" damage.", Color.red);
					p.HP-=randomDamage;
					//checkFaint();
				}
				else{
					System.out.println("No hit");
				}
				break;
			case 2:
				attackName="Scratch                                         1";
				hitPercent=rgen.nextInt(100);
				if(hitPercent<=(85/*-(other pkmn's defence)/3*/)){ //Hit percent is 80
					int minDamage=((((2*level)*ATT*base_att/p.DEF)/50));
					int maxDamage=(5*(((2*level)*ATT*base_att/p.DEF)/50));
					//System.out.println("\n"+p.name);
					//p.getStats();
					//System.out.println("\n"+name);
					//getStats();
					//System.out.println(minDamage + "  " + maxDamage+"    ");
					int randomDamage=(minDamage+rgen.nextInt(maxDamage-minDamage));
					System.out.println("\n"+p.name+" gets hit by "+ name+ " for "+randomDamage+" damage.");
					output.add("\n"+p.name+" gets hit by "+ name+ " for "+randomDamage+" damage.", Color.red);

					System.out.println(attackName);
					p.HP-=randomDamage;
					//checkFaint();
				}
				else{
					System.out.println("No hit");
				}
				break;
			case 3:
				attackName="SUPER EPIC ATTACK                                   4";
				hitPercent=rgen.nextInt(100);
				if(hitPercent<=(85)){ //Hit percent is 50
					//int(int(int(2xL/5+2)xAxP D)/50)+2
					//l=attacker lvl
					//A=attacker's current attack lvl
					//P=attacker's base damage
					//D=defender's current damage
					int minDamage=((((2*level)*ATT*base_att/p.DEF)/50));
					int maxDamage=(5*(((2*level)*ATT*base_att/p.DEF)/50));
					//System.out.println("\n"+p.name);
					//p.getStats();
					//System.out.println("\n"+name);
					//getStats();
					//System.out.println(minDamage + "  " + maxDamage+"    ");
					int randomDamage=(minDamage+rgen.nextInt(maxDamage-minDamage));
					System.out.println("\n"+p.name+" gets hit by "+ name+ " for "+randomDamage+" damage.");
					System.out.println(attackName);
					output.add("\n"+p.name+" gets hit by "+ name+ " for "+randomDamage+" damage.", Color.red);
					p.HP-=randomDamage;
					//checkFaint();
				}
				else{
					System.out.println("No hit");
				}
				break;
			}
		}
	}
	public String getName(){
		return name;
	}
	public Image getFront(){
		return front_image;
	}
	public Image getBack(){
		return back_image;
	}
	public Image getParty(){
		return party_image;
	}
	public int getLevel() {
		return level;
	}
	private void levelUp(int upgrade) {
		if(upgrade < 0) {
			System.out.println("ERRPR: Negative exp upgrade");
		}
		level += upgrade;
		
		// update other properties too
		base_hp = HP = 3 * level + 2;
	}
	public int getHP(){
		//System.out.println(HP);
		return HP;
	}
	public void expUp(int upgrade) {
		if(upgrade < 0) {
			System.out.println("ERRPR: Negative exp upgrade");
		}
		exp += upgrade;
		if(exp>=Math.pow(level, 2)) {
			levelUp(1);
			System.out.println("Player upgraded to level: " + level);
		}
	}
	protected double getLevelEXP() {
		return exp;
	}
	protected int getNumber() {
		return number;
	}
	protected void getStats(){
		System.out.println("HP, BASE HP");
		System.out.println(HP);
		System.out.println(base_hp);
		System.out.println("ATT, BASE ATT");
		System.out.println(ATT);
		System.out.println(base_att);
		System.out.println("DEF, BASE DEF");
		System.out.println(DEF);
		System.out.println(base_def);
		System.out.println("SPEC, BASE SPEC");
		System.out.println(SPEC);
		System.out.println(base_spec);	
	}
	protected void healPokemon(){
		HP=base_hp;
		ATT=base_att;
		DEF=base_def;
		SPEED=base_speed;
		SPEC=base_spec;	
		System.out.println("Player's pokemon have been healed");
	}
	protected void checkFaint(){
		if(HP<=0){
			fainted=true;
		}
		else{fainted=false;}
	}
}
