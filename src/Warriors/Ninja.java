package Warriors;

public class Ninja extends Warrior{
	public Ninja(int pid, int type, int party){
		super(pid, type, party);
	}
	
	public boolean getAttack(ClassAttack x){
		if(x.attackValue>=this.HP){
			ClassDeathAnnounce announce = new ClassDeathAnnounce(this,this.HP);
			removeHP(this.HP);
			this.Dead = true;
			if(!x.isBeatBack)
				x.Attack.NumberOfKilledWarrior++;
			
			if(x.Attack.Type==4){
				if(x.Attack.NumberOfKilledWarrior%2 == 0 && !x.isBeatBack){
					x.Attack.HP*=2;
					x.Attack.AttackValue*=2;
				}
			}
			x.Attack.getDeathAnnounce(announce);
			return true;
		} else{	
			removeHP(x.attackValue);
			return false;
		}
	}
}
