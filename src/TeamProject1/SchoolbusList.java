package TeamProject1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class SchoolbusList extends JPanel{
	String bus[] = {"명지대역방면"};    
	public SchoolbusList(){
		JLabel label1 = new JLabel("스쿨버스");
        JList strList = new JList(bus);
        JButton view = new JButton("정보보기");
        
        add(label1); 
        add(new JScrollPane(strList));    
        add(view);
        
        strList.setPreferredSize(new Dimension(500,300));
        label1.setPreferredSize(new Dimension(100,100));
        view.setPreferredSize(new Dimension(150,100));
        
        strList.setVisible(true);
        label1.setVisible(true);	  
        
        view.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		if (strList.getSelectedValue()== "명지대역방면") {
	    			new b_School();
	    		}
	    	}
	    });
        
    }

}