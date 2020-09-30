package TeamProject1;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolbusList_Frame extends JFrame {
	public SchoolbusList_Frame() {
		SchoolbusList lt = new SchoolbusList();
		 setTitle("스쿨버스");	
		  
		 getContentPane().add(lt);
	     this.setSize(1000,400);
	     this.setLayout(new FlowLayout());
	     this.setVisible(true);
		
	 
	     
	     
	}
}
	
