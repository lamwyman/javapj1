package Warriors;

public class WarriorType {
	public static final int DRAGON = 0;
	public static final int NINJA = 1;
	public static final int ICEMAN = 2;
	public static final int LION = 3;
	public static final int WOLF = 4;
	public static final String[] WarriorNames = {"dragon","ninja","iceman","lion","wolf"};
	public static int[] HP_LIST = new int[5];
	public static int[] ATTACK_LIST = new int[5];
	
	public WarriorType(){
		
	}
	
	public int getHPByIndex(int x){
		return HP_LIST[x];
	}
	
	public int getAttackByIndex(int x){
		return ATTACK_LIST[x];
	} 
}
