import java.util.*;

public class Character {
	
    protected String name;
    protected double defense;
    protected double HP;
    protected double maxHP;
    protected double damage;
    protected double multiplier;
    protected int accuracy;
    protected int speed;
    protected int IQ; //whats this for?
    
    
    public Character() {
	name = "Trainee";
	maxHP = 3.0;
	HP = 3.0;
	damage = .5;
	multiplier = 1.5;
	accuracy = 85;
	defense = .25;
    }
    
    public Character( String n ) {
	name = n;
	maxHP = 3.0;
	HP = 3.0;
	damage = .5;
	multiplier = 1.5;
	accuracy = 85;
	defense = .25;
    }

    public void attack( Character c ) {
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
	s+= "HP = " + HP + " ";
	s+= "MaxHP = " + maxHP + " ";
	s+= "damage = " + damage + " ";
	s+= "multiplier = " + multiplier + " ";
	s+= "accuracy = " + accuracy + " ";
	return s;
    }

    public void doubleEdge(Character e){
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
    
    public void strongAttack(Character e){
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
	
    public void sneakAttack(Character e){
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
