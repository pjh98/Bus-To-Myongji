package TeamProject1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Map extends JFrame {
	ImageIcon img = new ImageIcon("C:\\Users\\Jinho Park\\eclipse-workspace\\TeamProject1\\src\\image\\map.png");	
	Image im = img.getImage();
	ImageIcon bus = new ImageIcon("C:\\Users\\Jinho Park\\eclipse-workspace\\TeamProject1\\src\\image\\busstation.png");
	Image Ibus = bus.getImage();
	Image Cbus = Ibus.getScaledInstance(50,50, Image.SCALE_SMOOTH);
	ImageIcon Nbus = new ImageIcon(Cbus);
	
	JButton btn1 = new JButton(Nbus);
	JButton btn2 = new JButton(Nbus);
	JButton btn3 = new JButton(Nbus);
	
	public Map() {
	        setTitle("지도");	    
	        MyPanel panel = new MyPanel();        
	
	        panel.setLayout(null);
	        panel.add(btn1);
	        btn1.setBounds(560,50,50,50);
	        btn1.setBorderPainted(false);
	        panel.add(btn2);
	        btn2.setBounds(460,610,50,50);
	        btn2.setBorderPainted(false);
	        panel.add(btn3);
	        btn3.setBounds(420,700,50,50);
	        btn3.setBorderPainted(false);
	        this.add(panel);
	        this.setSize(1000,1000);
	        this.setVisible(true);
	        
	        
	        btn1.addActionListener(new ActionListener () {
		    	public void actionPerformed(ActionEvent e) {
		    		new busStop1(); 
		    	}
		    });
	        
	        btn2.addActionListener(new ActionListener () {
		    	public void actionPerformed(ActionEvent e) {
		    		new busStop2(); 
		    	}
		    });
	        
	        btn3.addActionListener(new ActionListener () {
		    	public void actionPerformed(ActionEvent e) {
		    		new busStop3(); 
		    	}
		    });
	       
	   
	    }
	class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(im,0,0,getWidth(),getHeight(),this);
        }
    }
}