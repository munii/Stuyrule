import java.util.*;
public class Battle {
	public void battle (Link l, Enemy c) {
		String s = c.name;
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("You have encountered" + " " + s);
		if (l.speed > c.speed || l.speed == c.speed) {
		System.out.println( s + "'s speed is no match for yours! You get the first strike!");
		while (l.HP != 0.0 && c.HP != 0.0) {
			String LinkHP = "Your HP:" + l.HP + "/" + l.maxHP;
			String EnemyHP = "Enemy's HP:" + c.HP + "/" + c.maxHP;
			System.out.println (LinkHP);
			System.out.println (EnemyHP);
			System.out.println ("What will you do? Enter the number that corresponds to the action of your choice");
			System.out.println ("1. Attack (A basic attack)");
			System.out.println ("2. Double-Edged Swing (Powerful but deals recoil damage to you)"); //Should we incorporate explanations of theses actions somehow?
			System.out.println ("3. Strong Attack (Stronger but less accurate)");
			System.out.println ("4. Sneak Attack (Ignores defense)");
			//System.out.println ("5. Use Item");
			int x = sc.nextInt();
			//Runtime.getRuntime().exec("clear");
			//System.out.print("\033\143");
			for (int i = 0; i < 150; i++){
				System.out.println("\b");
			}
			if (x == 1) {
			l.attack(c);
			}
			else if (x == 2) {
			l.doubleEdge(c);
			}
			else if (x == 3) {
			l.strongAttack(c);
			}
			else{
			l.sneakAttack(c);
			}//There should be items usage here but Im not sure what to do for it right now
			c.attack (l);
			}
		if (l.HP == 0) {
			System.out.println("Game Over");
			System.out.println("You Lose");
			//Can add more depending on if there is a save function
			System.exit(0);
			}
		else {
			System.out.println (l.name + " " + "emerges victorious!");
			//Int x = rand.nextInt(99); //Numbers for drop rate probably need tweaking
			//if (x < 25) {
				//System.out.println (
			int statincrease = r.nextInt(99);
			if (statincrease < 25) {  //Numbers need balancing
				l.HP += 5.0;
				}
			else if (statincrease >24 && statincrease < 49) {
				l.damage += 5.0;
				}
			else if (statincrease > 49 && statincrease < 75) {
				l.accuracy += 5;
				}
			else {
				l.speed += 5;
				}
			if (statincrease < 25) {
				System.out.println ("Your health has increased");
				}
			else if (statincrease >24 && statincrease < 49) {
				System.out.println ("Your attacks feel stronger");
				}
			else if (statincrease > 49 && statincrease < 75) {
				System.out.println (" Your attacks feel more accurate");
				}
			else {
				System.out.println (" You feel more nimble");
				}
				//Battle ended, now what? need to work on this
				}
	}
	else if (l.speed < c.speed) {
		System.out.println ("Too slow!" + " " + s + " " + " gets the first strike");
		c.attack(l);
		while (l.HP != 0.0 && c.HP != 0.0) {
			String LinkHP = "Your HP:" + l.HP + "/" + l.maxHP;
			String EnemyHP = "Enemy's HP:" + c.HP + "/" + c.maxHP;
			System.out.println (LinkHP);
			System.out.println (EnemyHP);
			System.out.println ("What will you do? Enter the number that corresponds to the action of your choice");
			System.out.println ("1. Attack (A basic attack)");
			System.out.println ("2. Double-Edged Swing (Powerful but deals recoil damage to you)"); //Should we incorporate explanations of theses actions somehow?
			System.out.println ("3. Strong Attack (Strong but less accurate)");
			System.out.println ("4. Sneak Attack (Ignores enemy defense)");
			//System.out.println ("5. Use Item");
			int x = sc.nextInt();
			//Runtime.getRuntime().exec("clear");
			//System.out.print("\033\143");
			for (int i = 0; i < 150; i++){
				System.out.println("\b");
			}
			if (x == 1) {
			l.attack(c);
			}
			else if (x == 2) {
			l.doubleEdge(c);
			}
			else if (x == 3) {
			l.strongAttack(c);
			}
			else{
			l.sneakAttack(c);
			}//There should be items usage here but Im not sure what to do for it right now
			c.attack (l);
			}
		if (l.HP == 0) {
			System.out.println("Game Over");
			System.out.println("You Lose");
			//Can add more depending on if there is a save function
			System.exit(0);
			}
		else {
			System.out.println (l.name + " " + "emerges victorious!");
			//Int x = rand.nextInt(99); //Numbers for drop rate probably need tweaking
			//if (x < 25) {
				//System.out.println (
			int statincrease = r.nextInt(99);
			if (statincrease < 25) {  //Numbers need balancing
				l.HP += 5.0;
				}
			else if (statincrease >24 && statincrease < 49) {
				l.damage += 5.0;
				}
			else if (statincrease > 49 && statincrease < 75) {
				l.accuracy += 5;
				}
			else {
				l.speed += 5;
				}
			if (statincrease < 25) {
				System.out.println ("Your health has increased");
				}
			else if (statincrease >24 && statincrease < 49) {
				System.out.println ("Your attacks feel stronger");
				}
			else if (statincrease > 49 && statincrease < 75) {
				System.out.println (" Your attacks feel more accurate");
				}
			else {
				System.out.println (" You feel more nimble");
				}
				//Battle ended, now what? need to work on this
				}
	}
		
}
}
