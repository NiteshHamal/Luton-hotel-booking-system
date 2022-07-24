package manager;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mylibs.ActiveCustomerlibs;
import mylibs.BookingJDBC;

public class AvailableCustomerGUI {
	JFrame frame;
	Object[]Header;
	JTable table;
	DefaultTableModel model;
	ArrayList<ActiveCustomerlibs>cus; 
	 JTextField searchtxt;
	
	public AvailableCustomerGUI() {
		frame=new JFrame("Active Customer");
		frame.setSize(550,350);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		
		Header = new Object[2];
		Header[0] = "Booking ID";
		Header[1] = "Customer Name";
		

		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(Header);

		updateTable();
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400,20,500,400);
		frame.add(scroll1, BorderLayout.CENTER);
		
		
		
		
		frame.setVisible(true);
		
		
	}
	
	public void updateTable() {
		
		cus = new BookingJDBC().activecustomer();
		model.setRowCount(0);
		for (ActiveCustomerlibs boocus : cus) {
			Object tmpRow[] = { boocus.getBooking_id(),
					boocus.getCustomer_name(),		
			};

			model.addRow(tmpRow);
		}
		table = new JTable(model);

		
	}
// main method
	public static void main(String[] args) {
		new AvailableCustomerGUI();
		

	}


}
