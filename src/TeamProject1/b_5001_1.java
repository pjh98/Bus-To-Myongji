package TeamProject1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;



public class b_5001_1 extends JFrame implements Runnable {
	private Thread thread;
	JLabel clock = new JLabel();
	JLabel Infor = new JLabel();
	
	JButton restTime = new JButton("남은시간 보기");
	JLabel b_5001_1 = new JLabel("5001-1");
	
	public b_5001_1(){			
		MyPanel panel = new MyPanel();
	
		
		panel.setLayout(null);
		this.add(panel);
		this.setTitle("5001-1번 버스");
		this.setSize(1000,800);
		this.setVisible(true);
		
		panel.setBackground(new Color(255,255,255));
		
		clock.setFont(new Font("San-Serif",Font.BOLD,30));
		clock.setForeground(new Color(70,70,70));
		clock.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		panel.add(clock);
		clock.setBounds(0,0,600,100);
		
		Infor.setFont(new Font("San-Serif",Font.BOLD,30));
		Infor.setForeground(new Color(70,70,70));
		Infor.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		panel.add(Infor);
		Infor.setText("<html>---------------------------------------------------------------------<br>"
				+ "운행시간 - 평일 05:30~23:00, 주말 05:30~23:00<br>"
				+"배차간격 - 평일 30분<br>"
				+"주요경유지 - 신성아파트.명지대승차장, 상공회의소<br>"
				+"---------------------------------------------------------------------</html>");
		Infor.setBounds(0,0,800,400);
		
		panel.add(restTime);
		restTime.setBounds(600,400,400,100);
		restTime.setFont(new Font("San-Serif",Font.PLAIN,25));
		restTime.setForeground(Color.black);
		restTime.setBorderPainted(false);
		restTime.setBackground(new Color(126, 126, 126));  // 뒷배경 바꾸기
		restTime.setOpaque(true);
		
		panel.add(b_5001_1);
		b_5001_1.setBounds(0,400,600,100);
		b_5001_1.setFont(new Font("San-Serif",Font.BOLD,30));
		b_5001_1.setBackground(new Color(230,227,227));  // 뒷배경 바꾸기
		b_5001_1.setOpaque(true);
		b_5001_1.setForeground(new Color(219,4,4)); 
		b_5001_1.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		restTime.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new Map(); 
	    		JOptionPane.showMessageDialog(null, "탈 곳을 선택하세요!" );
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