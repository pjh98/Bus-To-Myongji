package TeamProject1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;

class Queue {
	int[] array;
	int head;
	int tail;
	
	Queue(int size){
		array=new int[size];
		head=-1;
		tail=-1;
	}
	public void enQueue(int number) {
		if(tail==array.length-1) {
			throw new RuntimeException("큐가 다 찼습니다.");
		} 
		array[++tail]=number;
	}
	public int deQueue() {
		if(tail==-1) {
			throw new RuntimeException("큐에 데이터가 없습니다.");
		}
		int temp=array[++head];
		array[head]=-1;
		
		if(head==tail) {
			head=-1;
			tail=-1;
		}
		return temp;
	}
}
public class busStop3 extends JFrame implements Runnable {
	private Thread thread;
	JLabel clock = new JLabel();
	
	JLabel restTime_SB = new JLabel();
	JLabel Schoolbus = new JLabel("스쿨버스");
	JLabel restTime_5003B = new JLabel();
	JLabel b_5003B = new JLabel("5003B");
	JLabel restTime_5000B = new JLabel();
	JLabel b_5000B = new JLabel("5000B");
	JLabel restTime_5001_1 = new JLabel();
	JLabel b_5001_1 = new JLabel("5001-1");
	JLabel restTime_13 = new JLabel();
	JLabel b_13 = new JLabel("13");
	
	static int curtime;	
	static int T_Schoolbus[] = {498, 508, 518, 533, 553, 558, 573, 593, 598, 613, 638, 648, 663, 693, 703, 723, 733, 743, 783, 823, 838, 868, 883, 888, 898, 928, 943, 958, 988, 1003, 1013, 1038, 1048, 1058, 1083, 1098, 1158, 1188, 1218}; // 8시반부터 한시간단위씩 분단위로 지정
	static int T_5003B[] = {13, 27, 41, 55, 69, 83, 97, 809, 823, 837, 851, 865, 879, 893, 907, 921, 935, 949, 963, 977, 991, 1005, 1019, 1033, 1047, 1061, 1075, 1089, 1103, 1117, 1131, 1145, 1159, 1173, 1187, 1201, 1215, 1229, 1243, 1257, 1271, 1285, 1299, 1313, 1327, 1341, 1355, 1369, 1383, 1397, 1411, 1425, 1439};
	static int T_5000B[]= {25, 50, 75, 890, 915, 940, 965, 990, 1015, 1040, 1065, 1090, 1115, 1140, 1165, 1190, 1215, 1240, 1265, 1290, 1315, 1340, 1365, 1390, 1415, 1440};
	static int T_5001_1[]= {11, 41, 461,491, 521, 551, 581, 611, 641, 671, 701, 731, 761, 791, 821, 851, 881, 911, 941, 971, 1001, 1031, 1061, 1091, 1121, 1151, 1181, 1211, 1241, 1271, 1301, 1331, 1361, 1391, 1421};
	static int T_13[]= {375, 425, 475, 525, 575, 625, 675, 725, 775, 825, 875, 925, 975, 1025, 1075, 1125, 1175, 1225, 1275, 1325};
	static int busTime_SB,TimeRemaining_SB,busTime_5003B,TimeRemaining_5003B,busTime_5000B,
				TimeRemaining_5000B,busTime_5001_1,TimeRemaining_5001_1,busTime_13,TimeRemaining_13;
	
	public busStop3(){			
		MyPanel panel = new MyPanel();
	
		panel.setLayout(null);
		this.add(panel);
		this.setTitle("상공회의소");
		this.setSize(1000,800);
		this.setVisible(true);
		
		panel.setBackground(new Color(255,255,255));
		
		clock.setFont(new Font("San-Serif",Font.BOLD,30));
		clock.setForeground(new Color(70,70,70));
		clock.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		panel.add(clock);
		clock.setBounds(0,0,600,100);
		
		//버스 남은시간
		panel.add(restTime_SB);
		restTime_SB.setBounds(600,100,400,100);
		restTime_SB.setFont(new Font("San-Serif",Font.BOLD,30));
		restTime_SB.setForeground(Color.black);
		restTime_SB.setBackground(new Color(230,227,227));  // 뒷배경 바꾸기
		restTime_SB.setOpaque(true);
		
		panel.add(restTime_5003B);
		restTime_5003B.setBounds(600,200,400,100);
		restTime_5003B.setFont(new Font("San-Serif",Font.BOLD,30));
		restTime_5003B.setForeground(Color.black);
		restTime_5003B.setBackground(new Color(190,190,190)); 
		restTime_5003B.setOpaque(true);
		
		panel.add(restTime_5000B);
		restTime_5000B.setBounds(600,300,400,100);
		restTime_5000B.setFont(new Font("San-Serif",Font.BOLD,30));
		restTime_5000B.setForeground(Color.black);
		restTime_5000B.setBackground(new Color(230,227,227));  // 뒷배경 바꾸기
		restTime_5000B.setOpaque(true);
		
		panel.add(restTime_5001_1);
		restTime_5001_1.setBounds(600,400,400,100);
		restTime_5001_1.setFont(new Font("San-Serif",Font.BOLD,30));
		restTime_5001_1.setForeground(Color.black);
		restTime_5001_1.setBackground(new Color(190,190,190)); 
		restTime_5001_1.setOpaque(true);
		
		panel.add(restTime_13);
		restTime_13.setBounds(600,500,400,100);
		restTime_13.setFont(new Font("San-Serif",Font.BOLD,30));
		restTime_13.setForeground(Color.black);
		restTime_13.setBackground(new Color(230,227,227)); 
		restTime_13.setOpaque(true);
	
		
		//버스 정보
		panel.add(Schoolbus);
		Schoolbus.setBounds(0,100,600,100);
		Schoolbus.setFont(new Font("San-Serif",Font.BOLD,30));
		Schoolbus.setBackground(new Color(230,227,227));  // 뒷배경 바꾸기
		Schoolbus.setOpaque(true);
		Schoolbus.setForeground(new Color(31, 74, 155)); 
		Schoolbus.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		panel.add(b_5003B);
		b_5003B.setBounds(0,200,600,100);
		b_5003B.setFont(new Font("San-Serif",Font.BOLD,30));
		b_5003B.setBackground(new Color(190,190,190));  // 뒷배경 바꾸기
		b_5003B.setOpaque(true);
		b_5003B.setForeground(new Color(219,4,4));
		b_5003B.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		panel.add(b_5000B);
		b_5000B.setBounds(0,300,600,100);
		b_5000B.setFont(new Font("San-Serif",Font.BOLD,30));
		b_5000B.setBackground(new Color(230,227,227));  // 뒷배경 바꾸기
		b_5000B.setOpaque(true);
		b_5000B.setForeground(new Color(219,4,4));
		b_5000B.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		panel.add(b_5001_1);
		b_5001_1.setBounds(0,400,600,100);
		b_5001_1.setFont(new Font("San-Serif",Font.BOLD,30));
		b_5001_1.setBackground(new Color(190,190,190));  // 뒷배경 바꾸기
		b_5001_1.setOpaque(true);
		b_5001_1.setForeground(new Color(219,4,4));
		b_5001_1.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		panel.add(b_13);
		b_13.setBounds(0,500,600,100);
		b_13.setFont(new Font("San-Serif",Font.BOLD,30));
		b_13.setForeground(new Color(37, 172, 154)); 
		b_13.setBackground(new Color(230,227,227));  // 뒷배경 바꾸기
		b_13.setOpaque(true);
		b_13.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		
		if(thread == null){
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void run(){
		while(true){
			Calendar cal = Calendar.getInstance();
			String now = "현재시간: " + cal.get(Calendar.YEAR)+"년"+
					(cal.get(Calendar.MONTH)+1)+"월"+
					cal.get(Calendar.DATE)+"일"+
					cal.get(Calendar.HOUR)+"시"+
					cal.get(Calendar.MINUTE)+"분"+
					cal.get(Calendar.SECOND)+"초";
			curtime = cal.get(Calendar.HOUR_OF_DAY)*60 +cal.get(Calendar.MINUTE);
			
			Queue q=new Queue(10); //큐 객체 선언
			
			//스쿨버스 시간
			if(curtime<=T_Schoolbus[0]) {
				busTime_SB = T_Schoolbus[0];
				q.enQueue(T_Schoolbus[0]);
				q.deQueue();
			}
			for(int i=0;i<=37;i++) {
				if(T_Schoolbus[i]<curtime&&curtime<=T_Schoolbus[i+1]) {
					busTime_SB=T_Schoolbus[i+1];
					q.enQueue(T_Schoolbus[i+1]);
					q.deQueue();
					break;
				}
			}
			
			//5003B 시간
			if(curtime<=T_5003B[0]) {
				busTime_5003B = T_5003B[0];
				q.enQueue(T_5003B[0]);
				q.deQueue();
			}
			for(int i=0;i<=51;i++) {
				if(T_5003B[i]<curtime&&curtime<=T_5003B[i+1]) {
					busTime_5003B=T_5003B[i+1];
					q.enQueue(T_5003B[i+1]);
					q.deQueue();
					break;
				}
			}
			
			//5000B 시간
			if(curtime<=T_5000B[0]) {
				busTime_5000B = T_5000B[0];
				q.enQueue(T_5000B[0]);
				q.deQueue();
			}
			for(int i=0;i<=24;i++) {
				if(T_5000B[i]<curtime&&curtime<=T_5000B[i+1]) {
					busTime_5000B=T_5000B[i+1];
					q.enQueue(T_5000B[i+1]);
					q.deQueue();
					break;
				}
			}
			
			//5001-1 시간
			if(curtime<=T_5001_1[0]) {
				busTime_5001_1 = T_5001_1[0];
				q.enQueue(T_5001_1[0]);
				q.deQueue();
			}
			for(int i=0;i<=33;i++) {
				if(T_5001_1[i]<curtime&&curtime<=T_5001_1[i+1]) {
					busTime_5001_1=T_5001_1[i+1];
					q.enQueue(T_5001_1[i+1]);
					q.deQueue();
					break;
				}
			}
			
			//13 시간
			if(curtime<=T_13[0]) {
				busTime_13 = T_13[0];
				q.enQueue(T_13[0]);
				q.deQueue();
			}
			for(int i=0;i<=18;i++){
				if(T_13[i]<curtime&&curtime<=T_13[i+1]){
					busTime_13=T_13[i+1];
					q.enQueue(T_13[i+1]);
					q.deQueue();
					break;
				}
			}
			
			
			TimeRemaining_SB = busTime_SB -curtime;
			TimeRemaining_5003B = busTime_5003B-curtime;
			TimeRemaining_5000B = busTime_5000B -curtime;
			TimeRemaining_5001_1 = busTime_5001_1 -curtime;
			TimeRemaining_13 = busTime_13 -curtime;
			
			
			String T_SB = "남은시간: "+ TimeRemaining_SB + "분";
			String T_b13 = "남은시간: "+ TimeRemaining_13 + "분";
			if(T_Schoolbus[38]<curtime&&curtime<1440) {
				T_SB = "막차 종료";
			}
			if(T_13[19]<curtime&&curtime<1440) {
				T_b13 = "막차 종료";
			}
			String T_b5003B = "남은시간: "+ TimeRemaining_5003B + "분";
			String T_b5000B = "남은시간: "+ TimeRemaining_5000B + "분";
			String T_b5001_1 = "남은시간: "+ TimeRemaining_5001_1 + "분";
			
			
			clock.setText(now);
			restTime_SB.setText(T_SB);
			restTime_5003B.setText(T_b5003B);
			restTime_5000B.setText(T_b5000B);
			restTime_5001_1.setText(T_b5001_1);
			restTime_13.setText(T_b13);
			
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	class MyPanel extends JPanel{
		public MyPanel(){			
		}
	}

}