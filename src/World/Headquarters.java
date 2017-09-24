package World;

import Warriors.Dragon;
import Warriors.Iceman;
import Warriors.Lion;
import Warriors.Ninja;
import Warriors.Warrior;
import Warriors.WarriorType;
import Warriors.Wolf;

public class Headquarters extends City{
	private int[] ProductionOrder;
	private int WarriorIndex;
	private int ProductionID;
	private int Party;
	
	public int getParty(){
		return this.Party;
	}
	
	public void increaseLifeElement(int x){
		this.LifeElement += x;
	}
	
	public Headquarters(int[] ProductionOrder, int cityid, int Party, int flag){
		super(cityid);
		this.ProductionOrder = ProductionOrder;
		this.WarriorIndex = 0;
		this.ProductionID = 1;
		this.Party = Party;
		
		this.Flag = flag;
		this.LifeElement = WorldProperty.InitLifeElements;
	}
	
	public boolean rewardWarrior(Warrior rewardwarr,int life){
		if(this.LifeElement>=life){
			rewardwarr.HP = rewardwarr.HP + life;
			this.LifeElement = this.LifeElement - life;
			return true;
		}
		return false;
	}
	
	public boolean tryToProduceWarrior(){
		return produceWarrior(ProductionOrder[WarriorIndex]);
	}
	
	public boolean produceWarrior(int x){
		if(LifeElement>=WarriorType.HP_LIST[x]){
			LifeElement = LifeElement-WarriorType.HP_LIST[x];
			Warrior warrior = null;
			if (x == WarriorType.DRAGON) {
				warrior = new Dragon(ProductionID, x, getParty());
			}
			if (x == WarriorType.ICEMAN) {
				warrior = new Iceman(ProductionID, x, getParty());
			}
			if (x == WarriorType.LION) {
				warrior = new Lion(ProductionID, x, getParty());
			}
			if (x == WarriorType.NINJA) {
				warrior = new Ninja(ProductionID, x, getParty());
			}
			if (x == WarriorType.WOLF) {
				warrior = new Wolf(ProductionID, x, getParty());
			}
			addWarrior(warrior);
			if(WarriorIndex<4){
				WarriorIndex++;
			}else{
				WarriorIndex = 0;
			}
			this.ProductionID++;
			return true;
		}
		return false;
	}
	
	public boolean checkOccupied(){
		if(this.Party == WorldProperty.RED && this.BlueWarriorStation.size() >= 2 || 
			this.Party == WorldProperty.BLUE && this.RedWarriorStation.size() >= 2){
			return true;
		}
		return false;
	}
}
