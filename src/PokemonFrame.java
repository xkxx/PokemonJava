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
    
    private String[] names = {"MissingNo", "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmelion", "Charzard", "Squirtle"};

	/*
	boolean gender;
	boolean isPlayer; //See if it is a Player or NPC
	boolean isWild; //See if it is a wild
	 */
	Image front_image, back_image, party_image;

	public int attack_damage;

	public PokemonFrame(int n){
		//System.out.println(name+" "+n);
		// only 1<=n<12 are implemented
		if(1 > n || n >= 12) { // must be a bug
			System.out.println("ERROR: Pokenmon number out of range");
			n = 0;
		}
		number = n;
        name = names[n];
		front_image = getImage(n, "front");
		back_image = getImage(n, "back");
		party_image = getImage(n, "party");
        updateSkills();
	}
	private Image getImage(int num, String type) {
		String filename, path = "../Pokemon/", postfix;
		switch(type) {
			case "front": postfix = ".png"; break;
			case "back": postfix = "b.png"; break;
			case "party": postfix = "p.png"; break;
			// any other values are impossible, but we don't feel like raising a error
			default: postfix = ".png";
		}
		switch(num) {
			case >= 100: filename = path + num.toString() + postfix; break;
			case >= 10: filename = path + "0" +num.toString() + postfix; break;
			case >= 0: filename = path + "00" +num.toString() + postfix; break;
			// any other values are impossible, but we don't feel like raising a error
			default: filename = path + num.toString() + postfix;
		}
		return new ImageIcon(filename).getImage();
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
		updateSkills();
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
    private void updateSkills() {
        base_hp = HP = 3 * level + 2;
        if(number == 004){
			ATT=2*level+2;
			DEF = SPEED = SPEC = 2*level;
			base_att = base_def = base_speed = base_spec = 2*level;
		}
		else if(number == 001){
			ATT=2*level+2;
			DEF = SPEED = SPEC = 2*level;
			base_att = base_def = base_speed = base_spec = 2*level;
		}
		else if(numeber == 002){
			ATT=2*level+2;
			DEF=2*level+3;
			SPEED = SPEC = 2*level;
			base_att = base_def = base_speed = base_spec = 2*level;
		}
		else if(number == 003){
			ATT=2*level+2;
			DEF=2*level+9;
			SPEED = SPEC = 2*level;
			base_att  = base_speed = base_spec = 2*level;
			base_def=2*level+9;
		}
		else if(number==005){
			ATT = DEF = SPEED = SPEC = 2*level;
			base_att=2*level+6+2;
			base_def = base_speed = base_spec = 2*level;
		}
		else if(number==006){
			ATT = DEF = SPEED = SPEC = 2*level;
			base_att=2*level+6+2;
			base_def=2*level;
			base_speed=2*level+9;
			base_spec=2*level;
		}
		else if(number==007){
			ATT = DEF = SPEED = SPEC = 2*level;
			base_att=2*level+6+2;
			base_def = base_speed = base_spec = 2*level;
		}
		else {//MissingNo or no pokemon number
			ATT=2*level+2;
			DEF = SPEED = SPEC = 2*level;
			base_att = base_def = base_speed = base_spec = 2*level;
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
