package TeamProject1;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Star extends JFrame { 
	private JTable table;
	
	public Star() {
		setTitle("즐겨찾기");
		JPanel NewWindowContainer = new JPanel();
		setContentPane(NewWindowContainer);
		NewWindowContainer.setBounds(100, 100, 1000, 400);
		NewWindowContainer.setLayout(null);
		this.setSize(1000,400);
        setResizable(true);
        setVisible(true);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(65, 30, 190, 50);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"시내버스", "13", "5001-1", "5003B", "5000B"}));
		NewWindowContainer.add(comboBox);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(65, 90, 190, 50);
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"스쿨버스","명지대역방면", "시내방면"}));
		NewWindowContainer.add(comboBox2);
		
		
		JButton addbookmarking = new JButton("즐겨찾기 추가");
		addbookmarking.setBounds(90, 168, 130, 50);
		addbookmarking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data[]= {comboBox.getSelectedItem().toString()};
				String data2[]= {comboBox2.getSelectedItem().toString()};
				if(comboBox.getSelectedItem()=="시내버스"&&comboBox2.getSelectedItem()=="스쿨버스") {
					JOptionPane.showMessageDialog(null, "버스를 선택하세요!" );
				}
				else if((comboBox.getSelectedItem())!="시내버스"&&comboBox2.getSelectedItem()=="스쿨버스") {
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					JOptionPane.showMessageDialog(null, "즐겨찾기에 추가되었습니다!" );
					tblModel.addRow(data);
				}
				else if(comboBox.getSelectedItem()=="시내버스"&&(comboBox2.getSelectedItem())!="스쿨버스"){
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					JOptionPane.showMessageDialog(null, "즐겨찾기에 추가되었습니다!" );
					tblModel.addRow(data2);
				}
				else if((comboBox.getSelectedItem())!="시내버스"&&(comboBox2.getSelectedItem())!="스쿨버스"){
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					JOptionPane.showMessageDialog(null, "즐겨찾기에 추가되었습니다!" );
					tblModel.addRow(data);
					tblModel.addRow(data2);
				}
			}
			
			
		});
		
		NewWindowContainer.add(addbookmarking);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 50, 580, 230);
		NewWindowContainer.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {"버스번호", "버스시간"}) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table.getColumnModel().getColumn(0).setPreferredWidth(3500);
		table.getColumnModel().getColumn(1).setPreferredWidth(3500);
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer tblModel = new DefaultTableCellRenderer();
		tblModel.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellRenderer(tblModel);
		
		
		JButton btnDelete = new JButton("즐겨찾기 삭제");
		btnDelete.setBounds(90, 243, 130, 50);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
				if(table.getSelectedRowCount()==1) {
					tblModel.removeRow(table.getSelectedRow());
				}
				else {
					if(table.getRowCount()==0) {
						//if table is empty (no data) than display message
						JOptionPane.showMessageDialog(null, "즐겨찾기 목록이 비었습니다." );
					}else {
						JOptionPane.showMessageDialog(null, "삭제할 버스를 한개만 선택해주세요." );
					}
				}
			}
		});
		NewWindowContainer.add(btnDelete);
		}
}