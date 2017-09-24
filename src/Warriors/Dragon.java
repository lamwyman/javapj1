package Warriors;

import World.Clock;
import World.WorldProperty;
import static a2.A2.WorldClock;
import static a2.FXMLDocumentController.gametype;
import static a2.Task11Controller.tmp;

public class Dragon extends Warrior {
	public Dragon(int pid, int type, int party){
		super(pid, type, party);
	}
	
	public void cheers(){
		System.out.println(WorldProperty.PartyNames[this.Party]+" dragon "+this.ProductionID+" yelled in city "+this.Location);
                if (gametype == 1) {
                    tmp.appendText(WorldProperty.PartyNames[this.Party]+" dragon "+this.ProductionID+" yelled in city "+this.Location+"\n");
                }
        }
	
	public boolean attack(Warrior warrior){
		System.out.println(WorldProperty.PartyNames[Party]+" "+WarriorType.WarriorNames[Type]+" "+this.ProductionID+" attacked "+WorldProperty.PartyNames[warrior.Party]+" "+WarriorType.WarriorNames[warrior.Type]+" "+warrior.ProductionID+" in city "+Location+" with "+this.HP+" elements and force "+this.AttackValue);
		if (gametype == 1) {
                    tmp.appendText(WorldProperty.PartyNames[Party]+" "+WarriorType.WarriorNames[Type]+" "+this.ProductionID+" attacked "+WorldProperty.PartyNames[warrior.Party]+" "+WarriorType.WarriorNames[warrior.Type]+" "+warrior.ProductionID+" in city "+Location+" with "+this.HP+" elements and force "+this.AttackValue+"\n");
                }
                ClassAttack attack = new ClassAttack(this,warrior,this.AttackValue,false);
		warrior.getAttack(attack);
		if(!Dead){
			System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
			if (gametype == 1) {
                            tmp.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                        }
                        this.cheers();
		}
		return true;
	}
}
