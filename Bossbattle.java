import java.util.*;
public class Bossbattle {
	public void bossfight(Link l, Moranondorf m) {
		System.out.println("Moranondorf slowly rises from his desk"); //Desk? Still not sure what game this is
		System.out.println("You have exceeded my expectations, Puny Freshman"); //Main chara is a freshman right??
		System.out.println("But Now Your Path Ends Here!"); //Maybe too cheesy
		System.out.println("None have withstood the power of the mighty Moranondorf!");
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		while (l.HP != 0.0 && m.HP > 2500.0) { //placeholder HP
			String LinkHP = "Your HP:" + l.HP + "/" + l.maxHP;
			String EnemyHP = "Enemy's HP:" + m.HP + "/" + m.maxHP;
			System.out.println (LinkHP);
			System.out.println (EnemyHP);
			System.out.println ("What will you do? Enter the number that corresponds to the action of your choice");
			System.out.println ("1. Attack");
			System.out.println ("2. Double-Edged Swing"); //Should we incorporate explanations of theses actions somehow?
			System.out.println ("3. Strong Attack");
			System.out.println ("4. Sneak Attack");
			//System.out.println ("5. Use Item");
			int x = sc.nextInt();
			//Runtime.getRuntime().exec("clear");
			//System.out.print("\033\143");
			for (int i = 0; i < 150; i++){
				System.out.println("\b");
			}
			if (x == 1) {
			l.attack(m);
			}
			else if (x == 2) {
			l.doubleEdge(m);
			}
			else if (x == 3) {
			l.strongAttack(m);
			}
			else{
			l.sneakAttack(m);
			}//There should be items usage here but Im not sure what to do for it right now
			m.attack (l);
			}
		if (l.HP == 0) {
			System.out.println("Game Over");
			System.out.println("You Lose");
			//Can add more depending on if there is a save function
			System.exit(0);
			}
		else {
			System.out.println("It seems I have underestimated you, Freshman");
			System.out.println("Now You Will Know True Fear at the Hands of the Mighty Moranondorf!");
			m.HP = 10000.0;
			m.maxHP = 10000.0;
			if (this.inventory.contains("Goddess Sword")) { //Experimental Goddesss Code
				System.out.println("What! Impossible How did you get your hands on that sword!");
				System.out.println("Grr. This changes nothing Freshman");
				System.out.println("The Goddess Sword reacts to Moranondorf's dark power!");
				m.defense = 100.0;
				while (l.HP != 0.0 && m.HP != 0.0) {
					String LinkHP = "Your HP:" + l.HP + "/" + l.maxHP;
					String EnemyHP = "Enemy's HP:" + m.HP + "/" + m.maxHP;
					System.out.println (LinkHP);
					System.out.println (EnemyHP);
					System.out.println ("What will you do? Enter the number that corresponds to the action of your choice");
					System.out.println ("1. Attack");
					System.out.println ("2. Double-Edged Swing"); //Should we incorporate explanations of theses actions somehow?
					System.out.println ("3. Strong Attack");
					System.out.println ("4. Sneak Attack");
					int x = sc.nextInt();
					for (int i = 0; i < 150; i++){
						System.out.println("\b");
					}
					if (x == 1) {
						l.attack(m);
					}
					else if (x == 2) {
						l.doubleEdge(m);
					}
					else if (x == 3) {
						l.strongAttack(m);
					}
					else{
						l.sneakAttack(m);
					}
					int y = r.nextInt(9);
					if (y == 0) {
						System.out.println ("Moranondorf unleashes his dark power upon you!");
						m.unleashgoddess(l);
						}
					else {
						m.attack(l);
						}
					}
				}
			else {
				while (l.HP != 0.0 && m.HP != 0.0) {
					String LinkHP = "Your HP:" + l.HP + "/" + l.maxHP;
					String EnemyHP = "Enemy's HP:" + m.HP + "/" + m.maxHP;
					System.out.println (LinkHP);
					System.out.println (EnemyHP);
					System.out.println ("What will you do? Enter the number that corresponds to the action of your choice");
					System.out.println ("1. Attack");
					System.out.println ("2. Double-Edged Swing"); //Should we incorporate explanations of theses actions somehow?
					System.out.println ("3. Strong Attack");
					System.out.println ("4. Sneak Attack");
					int x = sc.nextInt();
					for (int i = 0; i < 150; i++){
						System.out.println("\b");
					}
					if (x == 1) {
						l.attack(m);
					}
					else if (x == 2) {
						l.doubleEdge(m);
					}
					else if (x == 3) {
						l.strongAttack(m);
					}
					else{
						l.sneakAttack(m);
					}
					int y = r.nextInt(9);
					if (x == 0) {
						System.out.println ("Moranondorf unleashes his dark power upon you!");
						m.unleash(l);
						}
					else {
						m.attack(l);
						}
					}
				}
				if (l.HP == 0.0) {
					System.out.println ("Fool, None can conquer the Unstoppable Might of Moranondorf!");
					System.out.println ("Game Over");
					System.exit(0);
					}
				else {
					System.out.println ("NOOOooooo! Impossible! How could a Freshman.. Conquer me...");
					System.out.println ("Congratulations! You have defeated Moranondorf!");
					//Insert useless plot drivel/credits here
					}
				}
			}
		}
	
