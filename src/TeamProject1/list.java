package TeamProject1;

import javax.swing.*;
import java.awt.*;

class list extends JPanel{
	String bus[] = {"-", "-", "-","-", "-", "-","-", "-", "-","-", "-", "-"};    
	public list(){
		JLabel label1 = new JLabel("스쿨버스");
        JList strList = new JList(bus);
        add(label1); 
        add(new JScrollPane(strList));
        
        strList.setPreferredSize(new Dimension(400, 150));
        label1.setPreferredSize(new Dimension(100,100));
        
        strList.setVisible(true);
        label1.setVisible(true);
        
    }
}