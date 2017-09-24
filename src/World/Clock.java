package World;

public class Clock {
	private int hour;
	private int minute;
	
	public Clock(){
		this.hour = 0;
		this.minute = 0;
	}
	
	public static String customFormat(String hour, double minute){
		int min = (int) minute;
		int h = Integer.parseInt(hour);
		
		if (h<=9){
			return "00"+h+":"+((min<10)?"0"+min:min)+" ";
		} else if(h<=99){
			return "0"+h+":"+((min<10)?"0"+min:min)+" ";
		} else {
			return h+":"+((min<10)?"0"+min:min)+" ";
		}
	}
	
	public String getTime(){
		String hour = String.valueOf(this.hour);
		return hour;
	}
	
	public int getMinute(){
		return this.minute;
	}
	
	public void increase(){
		if(this.minute==50){
			this.hour++;
			this.minute = 0;
		} else{
			this.minute+=10;
		}
	}
}
