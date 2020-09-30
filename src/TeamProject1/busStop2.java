package TeamProject1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;

public class busStop2 extends JFrame implements Runnable {
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
	static int T_Schoolbus[] = {495, 505, 515, 530, 550, 555, 570, 590, 595, 610, 635, 645, 660, 690, 700, 720, 730, 740, 780, 820, 835, 865, 880, 885, 895, 925, 940, 955, 985, 1000, 1010, 1035, 1045, 1055, 1080, 1095, 1155, 1185, 1215}; // 8시반부터 한시간단위씩 분단위로 지정
	static int T_5003B[] = {12, 26, 40, 54, 68, 82, 96, 808, 822, 836, 850, 864, 878, 892, 906, 920, 934, 948, 962, 976, 990, 1004, 1018, 1032, 1046, 1060, 1074, 1088, 1102, 1116, 1130, 1144, 1158, 1172, 1186, 1200, 1214, 1228, 1242, 1256, 1270, 1284, 1298, 1312, 1326, 1340, 1354, 1368, 1382, 1396, 1410, 1424, 1438};
	static int T_5000B[]= {24, 49, 73, 889, 914, 939, 964, 989, 1014, 1039, 1064, 1089, 1114, 1139, 1164, 1189, 1214, 1239, 1264, 1289, 1314, 1339, 1364, 1389, 1414, 1439};
	static int T_5001_1[]= {10, 40, 460, 490, 520, 550, 580, 610, 640, 670, 700, 730, 760, 790, 820, 850, 880, 910, 940, 970, 1000, 1030, 1060, 1090, 1120, 1150, 1180, 1210, 1240, 1270, 1300, 1330, 1360, 1390, 1420};
	static int T_13[]= {370, 420, 470, 520, 570, 620, 670, 720, 770, 820, 870, 920, 970, 1020, 1070, 1120, 1170, 1220, 1270, 1320};
	static int busTime_SB,TimeRemaining_SB,busTime_5003B,TimeRemaining_5003B,busTime_5000B,
			TimeRemaining_5000B,busTime_5001_1,TimeRemaining_5001_1,busTime_13,TimeRemaining_13;
	
	
	public busStop2(){			
		MyPanel panel = new MyPanel();
	
		panel.setLayout(null);
		this.add(panel);
		this.setTitle("신성아파트.명지대승차장");
		this.setSize(1000,800);
		this.setVisible(true);
		
		panel.setBackground(new Color(255,255,255));
		
		clock.setFont(new Font("San-Serif",Font.BOLD,30));
		clock.setForeground(new Color(70,70,70));
		clock.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		panel.add(clock);
		clock.setBounds(0,0,600,100);
		
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
			
			
			// 내일오는 버스는 따로출력(수정)
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
