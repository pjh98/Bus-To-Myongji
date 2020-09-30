package TeamProject1;

import java.util.*;
import java.time.*;

public class LeftTime {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		
		Calendar cal=Calendar.getInstance();
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		
		System.out.println(hour);
		System.out.println(minute);
		
		int curtime;
		curtime=hour*60+minute;
		System.out.println(curtime);
		
		int LeftTime=0;
		
		if(1170<=curtime&&curtime<1175)
			LeftTime=1175-curtime;
		else if(1175<=curtime&&curtime<1185)
			LeftTime=1185-curtime;
		else if(1185<=curtime&&curtime<1190)
			LeftTime=1190-curtime;
		
		
		System.out.println("남은시간 : "+LeftTime +"분");
	}
}
