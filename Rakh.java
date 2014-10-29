public class Rakh extends Enemy {
    public Rakh () {
	HP = 300.0; //Make this high
	maxHP = 300.0; 
	damage = 500.0; //High damage
	speed = 10; //Slow
	defense = 50; //Medium defense
	multiplier = 5.0; //This guy does lots of damage
	accuracy = 50; //He misses alot
    }
    //Just for fun
    public void attack( Link c ) {
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy){
	    if (c.HP - (damage * multiplier - c.defense) >= 0){
		c.HP-=( damage * multiplier - c.defense);
		System.out.println("Rakhmedov SMASH!!");
		System.out.println(this.name + " " + "dealt" + " " + ( damage * multiplier - c.defense) + " " + "points of damage to" + " " + c.name);
	    }
	    else{
		System.out.println("Rakhmedov SMASH!!")
	    	System.out.println(this.name + " " + "dealt" + " " + c.HP + " " + "points of damage to" + " " + c.name);
		c.HP = 0;
	    }
	}
