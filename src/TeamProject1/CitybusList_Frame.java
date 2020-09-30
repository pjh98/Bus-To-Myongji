package TeamProject1;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitybusList_Frame extends JFrame {
	public CitybusList_Frame() {
		CitybusList lt = new CitybusList();
		setTitle("시내버스");	
		  
		getContentPane().add(lt);
	    this.setSize(1000,400);
	    this.setLayout(new FlowLayout());
	    this.setVisible(true);
	     
	}
}
