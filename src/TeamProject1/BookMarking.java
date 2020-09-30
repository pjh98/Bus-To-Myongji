package TeamProject1;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	public class BookMarking extends JFrame {

		private JPanel contentPane;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						BookMarking frame = new BookMarking();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public BookMarking() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton markbutton = new JButton("\uC990\uACA8\uCC3E\uAE30");
			markbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new MarkingList().setVisible(true);
					
				}
			});
			markbutton.setBounds(218, 82, 105, 57);
			contentPane.add(markbutton);
			
			JButton BusButton = new JButton("\uC2DC\uB0B4\uBC84\uC2A4");
			BusButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SinaeBus().setVisible(true);
					
				}
			});
			BusButton.setBounds(78, 82, 105, 57);
			contentPane.add(BusButton);
		}
	}
}
