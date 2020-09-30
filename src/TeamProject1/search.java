package TeamProject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class search extends JPanel{
 	public search() {
		JFrame frame=new JFrame("버스 검색");
		JTextArea ta=new JTextArea();
		ta.setBounds(20,20,200,20);
		JLabel l1=new JLabel();
		l1.setBounds(20,50,100,20);
		JButton btn=new JButton("검색");
		btn.setBounds(220,20,60,20);
		
		
		frame.add(l1);
		frame.add(ta);
		frame.add(btn);
		frame.setSize(500,200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				String bus=ta.getText();
				l1.setText("버스 : "+bus);
			}
		});
 	}
 	
}