package Warriors;

public class ClassAttack {
	public int attackValue;
	boolean isBeatBack;
	Warrior Attack;
	Warrior Defense;
	
	public ClassAttack(Warrior a, Warrior d, int attackValue, boolean isBeatBack){
		Attack = a;
		Defense = d;
		this.attackValue = attackValue;
		this.isBeatBack = isBeatBack;
	}
}
