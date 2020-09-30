package TeamProject1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

	public class MarkingList extends JFrame {

		private JPanel contentPane;
		private JTable table;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MarkingList frame = new MarkingList();
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
		public MarkingList() {
			setTitle("\uC990\uACA8\uCC3E\uAE30");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			SinaeBus SB=new SinaeBus();
			
			JLabel lblNewLabel = new JLabel("\uC990\uACA8\uCC3E\uAE30 \uBAA9\uB85D");
			lblNewLabel.setBounds(71, 28, 103, 30);
			contentPane.add(lblNewLabel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.addContainerListener(new ContainerAdapter() {
				@Override
				public void componentAdded(ContainerEvent e) {
				}
			});
			scrollPane.setBounds(81, 70, 262, 120);
			contentPane.add(scrollPane);
			
			
			scrollPane.setViewportBorder(SB.SinaeBus());
		}
	}
}
