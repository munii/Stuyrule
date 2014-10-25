import java.util.*;
public class Genericbattle {
	public void battle (Link l, Character c) {
		String s = c.name;
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("You have encountered" + " " + s);
		while (l.HP != 0.0 && c.HP != 0.0) {
			String LinkHP = "Your HP:" + l.HP;
			String EnemyHP = "Enemy's HP:" + c.HP;
			System.out.println (LinkHP);
			System.out.println (EnemyHP);
			System.out.println ("What will you do? Enter the number that corresponds to the action of your choice");
			System.out.println ("1. Attack");
			System.out.println ("2. Double-Edged Swing"); //Should we incorporate explanations of theses actions somehow?
			System.out.println ("3. Strong Attack");
			System.out.println ("4. Sneak Attack");
			//System.out.println ("5. Use Item");
			int x = sc.nextInt();
			//There should be code that clears the screen here
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
