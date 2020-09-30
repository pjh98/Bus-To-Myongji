package TeamProject1;

import javax.swing.*;
import java.awt.*;

public class list2 extends JPanel {
	String bus[] = {"5000B", "5001", "5001-1","5002", "5003B", "5005","5600", "5700B", "5002A","5700A", "820", "13"};    
	public list2(){
        
        JLabel label2 = new JLabel("시내버스");
        JList scrollList = new JList(bus); 
        add(label2);
        add(new JScrollPane(scrollList));
       
        scrollList.setPreferredSize(new Dimension(400, 200));
        label2.setPreferredSize(new Dimension(100,100));
        
        label2.setVisible(true);
        scrollList.setVisible(true);
    }

}