public class BowlingKing extends Enemy {
    public BowlingKing () {
	HP = 300.0; //Make this high
	maxHP = 300.0; 
	damage = 500.0; //High damage
	speed = 10; //Slow
	defense = 50; //Medium defense
	multiplier = 5.0; //This guy does lots of damage
	accuracy = 50; //He misses alot
    }
    //Just for fun
    public void strike( Link c ) {
	Random rand = new Random();
	if (rand.nextInt(1000) + 1 <= accuracy){
	    if (c.HP - (10 * damage * multiplier - c.defense) >= 0){
		c.HP-=(10 * damage * multiplier - c.defense);
		System.out.println("STRIKE");
		System.out.println("BowlingKing Scores a Strike for" + " " + (10 * damage * multiplier - c.defense));
	    }
	    else{
		System.out.println("BowlingKing Scores a Strike for" + " " + c.HP);
		c.HP = 0;
	    }
	}
