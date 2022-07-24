package manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import mylibs.AvailableRoomLibs;
import mylibs.RoomJDBC;

public class AvailableRoomGUI {
	JFrame frame;
	Object[]Header;
	JTable table;
	DefaultTableModel model;
	ArrayList<AvailableRoomLibs>room;
	 TableRowSorter sorter;
	 JTextField searchtxt;
	
	public AvailableRoomGUI() {
		frame=new JFrame("Available Rooms");
		frame.setSize(550,350);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		
		Header = new Object[3];
		Header[0] = "Room No";
		Header[1] = "Room Type";
		Header[2] = "Room Price";
		

		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(Header);

		sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);
		updateTable();
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400,20,500,400);
		frame.add(scroll1, BorderLayout.CENTER);
		
		
		
		
		frame.setVisible(true);
		
		
	}
	
	public void updateTable() {
		
		room = new RoomJDBC().availableroom();
		model.setRowCount(0);
		for (AvailableRoomLibs roomlib : room) {
			Object tmpRow[] = { roomlib.getRoom_No(),
					roomlib.getRoom_Type(),
					roomlib.getRoom_Status()
			
			};

			model.addRow(tmpRow);
		}
		table = new JTable(model);
		table.setGridColor(Color.white);

		
	}

	public static void main(String[] args) {
		new AvailableRoomGUI();
		

	}

}
