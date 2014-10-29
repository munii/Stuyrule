import java.util.*
public class Door extends Enemy {
    //Ill leave this constructor to you Lucas
    public Door () {
    }

    public void fall() {
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy){
	    if (c.HP - (damage * multiplier - c.defense) >= 0){
		c.HP-=( damage * multiplier - c.defense);
		System.out.println("Door fell on you to deal" + " " + ( 3 * damage * multiplier - c.defense) + " " + "points of damage");
	    }
	    else{
	    	System.out.println("Door fell on you to deal" + " " + c.HP + " " + "points of damage");
		c.HP = 0;
	    }
	
