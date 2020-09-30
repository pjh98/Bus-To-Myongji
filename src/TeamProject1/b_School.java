package TeamProject1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;



public class b_School extends JFrame implements Runnable {
	private Thread thread;
	JLabel clock = new JLabel();
	JButton restTime = new JButton("남은시간 보기");
	JLabel b_School = new JLabel("스쿨 버스");
	JButton timetable = new JButton("시간표 보기");
	public b_School(){			
		MyPanel panel = new MyPanel();
	
		
		panel.setLayout(null);
		this.add(panel);
		this.setTitle("스쿨버스");
		this.setSize(1000,500);
		this.setVisible(true);
		
		panel.setBackground(new Color(255,255,255));
		
		clock.setFont(new Font("San-Serif",Font.BOLD,30));
		clock.setForeground(new Color(70,70,70));
		clock.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		panel.add(clock);
		clock.setBounds(0,0,600,100);
		
		
		panel.add(restTime);
		restTime.setBounds(800,100,200,100);
		// 버튼 테마
	/*	restTime.setFont(new Font("San-Serif",Font.PLAIN,25));
		restTime.setForeground(Color.black);
		restTime.setBorderPainted(false);
		restTime.setBackground(new Color(126, 126, 126));  // 뒷배경 바꾸기
		restTime.setOpaque(true);*/
		
		panel.add(timetable);
		timetable.setBounds(600,100,200,100);
		
		panel.add(b_School);
		b_School.setBounds(0,100,600,100);
		b_School.setFont(new Font("San-Serif",Font.BOLD,30));
		b_School.setBackground(new Color(230,227,227));  // 뒷배경 바꾸기
		b_School.setOpaque(true);
		b_School.setForeground(new Color(31, 74, 155)); 
		b_School.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		restTime.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new Map(); 
	    		JOptionPane.showMessageDialog(null, "탈 곳을 선택하세요!" );
	    	}
	    });
		
		timetable.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new Schoolbus_timetable(); 
	    	}
	    });
		
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
		
			clock.setText(now);
			
		
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