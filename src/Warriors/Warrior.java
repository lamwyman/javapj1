package Warriors;

import World.Clock;
import World.WorldProperty;
import static a2.A2.WorldClock;
import static a2.FXMLDocumentController.gametype;
import static a2.Task11Controller.tmp;

public abstract class Warrior {
	public int HP;
	public int AttackValue;
	public int Type;
	public int Party;
	public boolean Dead;
	public int ProductionID;
	public int NumberOfKilledWarrior;
	public int MovedDistance;
	public String WarriorNameCard;
	public int Location;
	
	public Warrior(int pid, int type, int party){
		this.ProductionID = pid;
		this.Party = party;
		this.Type = type;
		
		this.HP = WarriorType.HP_LIST[type];
		this.AttackValue = WarriorType.ATTACK_LIST[type];
		this.Dead = false;
		this.NumberOfKilledWarrior = 0;
		this.MovedDistance = 0;
		this.WarriorNameCard = WarriorType.WarriorNames[type];
		
		if(Party ==0)
			this.Location = 0;
		else
			this.Location = WorldProperty.NumberOfCity+1;
	}
	
	public boolean move(){
		if(this.Party==0){
			this.Location++;
			this.MovedDistance++;
			return true;
		}else{
			this.Location--;
			this.MovedDistance++;
			return true;
		}
	}
	
	public boolean attack(Warrior x){
		System.out.println(WorldProperty.PartyNames[Party]+" "+WarriorType.WarriorNames[Type]+" "+this.ProductionID+" attacked "+WorldProperty.PartyNames[x.Party]+" "+WarriorType.WarriorNames[x.Type]+" "+x.ProductionID+" in city "+this.Location+" with "+HP+" elements and force "+this.AttackValue);
		if (gametype == 1) {
                    tmp.appendText(WorldProperty.PartyNames[Party]+" "+WarriorType.WarriorNames[Type]+" "+this.ProductionID+" attacked "+WorldProperty.PartyNames[x.Party]+" "+WarriorType.WarriorNames[x.Type]+" "+x.ProductionID+" in city "+this.Location+" with "+HP+" elements and force "+this.AttackValue+"\n");
                }
                ClassAttack attack = new ClassAttack(this,x,AttackValue,false);
		x.getAttack(attack);
		
		return true;
	}
	
	public boolean getDeathAnnounce(ClassDeathAnnounce x){
		System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                if (gametype == 1) {
                    tmp.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                }
		System.out.println(WorldProperty.PartyNames[x.Die.Party]+" "+WarriorType.WarriorNames[x.Die.Type]+" "+x.Die.ProductionID+" was killed in city "+this.Location);
		if (gametype == 1) {
                    tmp.appendText(WorldProperty.PartyNames[x.Die.Party]+" "+WarriorType.WarriorNames[x.Die.Type]+" "+x.Die.ProductionID+" was killed in city "+this.Location+"\n");
                }
                if(x.Die.Type==3){
			this.HP = this.HP + x.HPBeforeDeath;
		}
		return true;
	}

	public boolean getAttack(ClassAttack att){
		if(att.attackValue>=this.HP){
			ClassDeathAnnounce announce = new ClassDeathAnnounce(this,this.HP);
			removeHP(this.HP);
			this.Dead = true;
			if(!att.isBeatBack){
				att.Attack.NumberOfKilledWarrior++;
			}
			if(att.Attack.Type==4){
				if(att.Attack.NumberOfKilledWarrior%2 == 0 && !att.isBeatBack){
					att.Attack.HP=att.Attack.HP*2;
					att.Attack.AttackValue=att.Attack.AttackValue*2;
				}
			}
			att.Attack.getDeathAnnounce(announce);
			return true;
		}
		else{
			removeHP(att.attackValue);
			if(!att.isBeatBack){
				ClassAttack attack = new ClassAttack(this,att.Attack,AttackValue/2,true);
				System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
				if (gametype == 1) {
                                    tmp.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                }
                                System.out.println(WorldProperty.PartyNames[Party]+" "+WarriorType.WarriorNames[Type]+" "+this.ProductionID+" fought back against "+WorldProperty.PartyNames[att.Attack.Party]+" "+WarriorType.WarriorNames[att.Attack.Type]+" "+att.Attack.ProductionID+" in city "+this.Location);
				if (gametype == 1) {
                                    tmp.appendText(WorldProperty.PartyNames[Party]+" "+WarriorType.WarriorNames[Type]+" "+this.ProductionID+" fought back against "+WorldProperty.PartyNames[att.Attack.Party]+" "+WarriorType.WarriorNames[att.Attack.Type]+" "+att.Attack.ProductionID+" in city "+this.Location+"\n");
                                }
                                if(att.Attack.getAttack(attack)){
					return true;
				}
			}
			return false;
		}
	}
	
	public boolean removeHP(int removehp){
		this.HP = this.HP-removehp;
		return true;
	}
	
	public boolean die(){
		if(this.die()){
			return true;
		}
		return false;
	}
}
