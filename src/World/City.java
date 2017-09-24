package World;

import java.util.ArrayList;

import Warriors.Warrior;
import static a2.FXMLDocumentController.gametype;
import static a2.Task11Controller.tmp;

public class City {
	public int CityID;
	public int LifeElement;
	public ArrayList<Warrior> RedWarriorStation;
	public ArrayList<Warrior> BlueWarriorStation;
	public int Flag;
	public int PartyOfLastRoundWinner;
	public boolean Status_AfterBattle;
	
	public City(int cid){
		this.CityID = cid;
		this.LifeElement = 0;
		this.RedWarriorStation = new ArrayList<Warrior>();
		this.BlueWarriorStation = new ArrayList<Warrior>();
		this.Flag = 2;
		this.PartyOfLastRoundWinner = 2;
	}

	public int popLifeElements(){
		int lin = this.LifeElement;
		this.LifeElement = 0;
		return lin;
	}
	
	public boolean addWarrior(Warrior x){
		if(x.Party == 0){
			this.RedWarriorStation.add(x);
			return true;
		} else{
			this.BlueWarriorStation.add(x);
			return true;
		}
	}
	
	public boolean removeWarrior(Warrior x){
		if(x.Party == 0){
			this.RedWarriorStation.remove(x);
			return true;
		} else{
			this.BlueWarriorStation.remove(x);
			return true;
		}
	}
	
	//public boolean organizeBattle(){
	//}
	
	//public void payTribute(){	
	//}
	
	public boolean organizeBattle(){
		if(this.Flag==0){
			if(this.RedWarriorStation.get(0).attack(this.BlueWarriorStation.get(0)))
				return true;
		} else{
			if(this.Flag==1){
				if(this.BlueWarriorStation.get(0).attack(this.RedWarriorStation.get(0)))
					return true;
			} else if(this.CityID%2 != 0){
					if(this.RedWarriorStation.get(0).attack(this.BlueWarriorStation.get(0)))
						return true;
			} else if(this.CityID%2 == 0){
					if(this.BlueWarriorStation.get(0).attack(this.RedWarriorStation.get(0)))
						return true;
			}
		}
		return false;
	}
	
	public void payTribute(){
		this.Flag = this.PartyOfLastRoundWinner;
		if (gametype == 1) {
                    tmp.appendText(WorldProperty.PartyNames[this.Flag]+" flag raised in city "+this.CityID+"\n");
                }
                System.out.println(WorldProperty.PartyNames[this.Flag]+" flag raised in city "+this.CityID);
	}
}
