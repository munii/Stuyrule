public class Moranondorf extends Character {
	public Moranondorf () { //Placeholder values
		defense = 5000.0;
		HP = 5000.0;
		maxHP = 5000.0;
		damage = 5000.0;
		multiplier = 5.0;
		accuracy = 100;
		speed = 100;
		name = Moranondorf;
		}
	//Super Attacks specific to Moranondorf
	public void unleash(Link l) { //Really lazy ultimate attack
		damage *=2;
		if (l.HP - (damage * multiplier - l.defense) >= 0){
		l.HP-=( damage * multiplier - l.defense);
	    }
	    else{
		l.HP = 0;
	    }
	}
	public void unleashgoddess(Link l) {
		System.out.println("The Goddess Sword's Light weakens the darkness");
		damage /= 2;
		if (l.HP - (damage * multiplier - l.defense) >=0) {
		l.HP -= (damage * multiplier - l.defense);
		}
		else {
		l.HP = 0;
		}
	}
