package Warriors;

public class ClassDeathAnnounce {
	int HPBeforeDeath;
	Warrior Die;
	
	public ClassDeathAnnounce(Warrior d, int hp){
		Die = d;
		HPBeforeDeath = hp;
	}
}
