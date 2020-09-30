package TeamProject1;

import javax.swing.*;

public class newWindow extends JFrame {
	public newWindow() {

	        setTitle("지도");	    
	        
	        JPanel NewWindowContainer = new JPanel();
	        setContentPane(NewWindowContainer);
	        
	        JLabel NewLabel = new JLabel("지도");
	        
	        NewWindowContainer.add(NewLabel);
	        
	        setSize(500,500);
	        setResizable(false);
	        setVisible(true);
	    }
}