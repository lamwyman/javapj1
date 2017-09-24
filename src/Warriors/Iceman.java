package Warriors;

public class Iceman extends Warrior{
	public Iceman(int pid, int type, int party){
		super(pid, type, party);
	}
	
	public boolean move(){
		if(this.Party==0){
			this.Location++;
			this.MovedDistance++;
		}
		if(this.Party==1){
			this.Location--;
			this.MovedDistance++;
		}
		if(this.MovedDistance%2==0){
			this.HP = this.HP-9;
			this.AttackValue = this.AttackValue+20;
			
			if(this.HP<=0){
				this.HP = 1;
			}
		}
		return true;
	}
}
