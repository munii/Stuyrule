import java.util.*;
public class Link{
	protected static String name;
    protected static double defense;
    protected static double HP;
    protected static double maxHP;
    protected static double damage;
    protected static double multiplier;
    protected static int accuracy;
    protected static int speed;
    
    public static int color;
    //Constructors
	public Link() {
	name = "Trainee";
	maxHP = 3.0;
	HP = 3.0;
	damage = .5;
	multiplier = 1.5;
	accuracy = 85;
	defense = .25;
    }
    public Link(String n, int c) {
	defense = 100.0;
	damage = 100.0;
	name = n;
    color = c;
	accuracy = 95;
	multiplier = 2.0;
	HP = 100.0;
	maxHP = 100.0;
    }
	public void attack( Guy c ) {
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy){
	    if (c.HP - (damage * multiplier - defense) >= 0){
		c.HP-=( damage * multiplier - defense);
	    }
	    else{
		c.HP = 0;
	    }
	}
	else{
	    System.out.println("I missed... :(");
	}
    }
    
    public void heal(int x){
	if (x + HP >= maxHP){
	    HP = maxHP;
	}
	else{
	    HP += x;
	}
    }

    public String toString() {
	String s = name + " ";
	s+= "\n" + "HP = " + HP + " ";
	s+= "\n" + "MaxHP = " + maxHP + " ";
	s+= "\n" + "damage = " + damage + " ";
	s+= "\n" + "multiplier = " + multiplier + " ";
	s+= "\n" + "accuracy = " + accuracy + " ";
	return s;
    }

    public void doubleEdge(Guy e){
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy){
	    if (e.HP - damage * multiplier * 1.5 >= 0){
		e.HP-=( damage * multiplier * 1.5);
	    }
	    else{
		e.HP = 0;
	    }
	    HP -= (damage * multiplier / 4 - defense);
	}
	else{
	    System.out.println("I missed bad");
	}
	
    }
    
    public void strongAttack(Guy e){
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy - 10){
	    if (e.HP - ((damage + .5) * multiplier - defense) >= 0){
		e.HP-=( (damage + .5) * multiplier - defense);
	    }
	    else{
		e.HP = 0;
	    }
	}
	else{
	    System.out.println("I missed... :(");
	}	
    }
	
    public void sneakAttack(Guy e){
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy - 15){
	    if (e.HP - (damage * multiplier) >= 0){
		e.HP-=( damage * multiplier);
	    }
	    else{
		e.HP = 0;
	    }
	}
	else{
	    System.out.println("I missed... :(");
	}	
    }
}
