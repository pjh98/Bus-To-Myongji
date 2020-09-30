package TeamProject1;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class button extends JPanel{
	public button() {
		JButton btn1 = new JButton("지도보기");
		JButton btn2 = new JButton("즐겨찾기");
		btn1.setPreferredSize(new Dimension(100,100));
		add(btn1);
		btn1.setVisible(true);
		btn2.setPreferredSize(new Dimension(100,100));
		add(btn2);
		btn2.setVisible(true);
}
}