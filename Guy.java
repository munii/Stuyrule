import java.util.*;

public class Guy {
	
    protected static String name;
    protected static double defense;
    protected static double HP;
    protected static double maxHP;
    protected static double damage;
    protected static double multiplier;
    protected static int accuracy;
    protected static int speed;
    
    public Guy() {
	name = "Trainee";
	maxHP = 3.0;
	HP = 3.0;
	damage = .5;
	multiplier = 1.5;
	accuracy = 85;
	defense = .25;
    }
    
    public Guy( String n ) {
	name = n;
	maxHP = 3.0;
	HP = 3.0;
	damage = .5;
	multiplier = 1.5;
	accuracy = 85;
	defense = .25;
    }

    public void attack( Link c ) {
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

    public void doubleEdge(Link e){
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
    
    public void strongAttack(Link e){
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
	
    public void sneakAttack(Link e){
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
