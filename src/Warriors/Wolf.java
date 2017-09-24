package Warriors;

import World.Clock;
import World.WorldProperty;
import static a2.A2.WorldClock;
import static a2.FXMLDocumentController.gametype;
import static a2.Task11Controller.tmp;

public class Wolf extends Warrior {
	public Wolf(int pid, int type, int party){
		super(pid, type, party);
	}
	
	public boolean getDeathAnnounce(ClassDeathAnnounce warrior){
                System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
		System.out.println(WorldProperty.PartyNames[warrior.Die.Party]+" "+WarriorType.WarriorNames[warrior.Die.Type]+" "+warrior.Die.ProductionID+" was killed in city "+this.Location);
		if (gametype == 1) {
                    tmp.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                    tmp.appendText(WorldProperty.PartyNames[warrior.Die.Party]+" "+WarriorType.WarriorNames[warrior.Die.Type]+" "+warrior.Die.ProductionID+" was killed in city "+this.Location+"\n");
                }
		if(warrior.Die.Type==3){
			this.HP = this.HP+warrior.HPBeforeDeath;
		}
		return true;
	}
	
}
