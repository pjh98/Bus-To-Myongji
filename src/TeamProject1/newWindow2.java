package TeamProject1;

import javax.swing.*;

public class newWindow2 extends JFrame {
	public newWindow2() {

	        setTitle("즐겨찾기");	    
	        
	        JPanel NewWindowContainer = new JPanel();
	        setContentPane(NewWindowContainer);
	        
	        JLabel NewLabel = new JLabel("즐겨찾기");
	        
	        NewWindowContainer.add(NewLabel);
	        
	        setSize(500,500);
	        setResizable(false);
	        setVisible(true);
	    }
}