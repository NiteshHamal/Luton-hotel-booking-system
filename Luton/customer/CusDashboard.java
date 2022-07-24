package customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import main_gui.SignIn;
import mylibs.Booking;
import mylibs.BookingJDBC;
import mylibs.Global;
import mylibs.MaterialTabbed;

public class CusDashboard implements ActionListener, MouseListener {
	JFrame frame;
	JPanel north, west, center, booking, payment, history, menu, panel0, up;
	JLabel heading, logo, customer_id, arrival_date, departure_date, room_number, room_type, title;
	JTextField txt_id, txt_room_number, txt_total,txt_booking_id;
	JButton sign_out, book, cancel;
	DefaultTableModel model, dm;
	JTable table, table2;
	JScrollPane scrollPane;
	JComboBox cmb_room_status, txt_room_type;
	Object[] columnsName,Column;
	ArrayList<Booking> search;
	JDateChooser txt_arrival_date, txt_departure_date;

	public CusDashboard() {
		frame = new JFrame("Customer");
		frame.setSize(550, 550);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		// heading
		north = new JPanel();
		north.setBackground(new Color(255, 193, 0));
		north.setPreferredSize(new Dimension(100, 50));
		north.setLayout(null);
		frame.add(north, BorderLayout.NORTH);

		heading = new JLabel("Hotel Luton", SwingConstants.CENTER);
		heading.setFont(new Font("Verdana", Font.BOLD, 25));
		heading.setBounds(580, 0, 230, 50);
		north.add(heading);

		logo = new JLabel("");
		Image lbl = new ImageIcon(this.getClass().getResource("logo2.jpg")).getImage();
		logo.setIcon(new ImageIcon(lbl));
		logo.setBounds(10, 2, 60, 45);
		north.add(logo);

		sign_out = new JButton("Sign Out");
		sign_out.setFocusable(false);
		sign_out.setBounds(1255, 5, 85, 40);
		sign_out.setBackground(new Color(254, 242, 78));
		sign_out.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 0)));
		sign_out.addActionListener(this);
		north.add(sign_out);

		// center panel

		center = new JPanel();
		center.setBackground(Color.WHITE);
		center.setLayout(null);
		frame.add(center, BorderLayout.CENTER);

		// add tab
		MaterialTabbed tab = new MaterialTabbed();
		tab.setBounds(0, 0, 1365, 650);
		tab.setFont(new Font("Verdana", Font.BOLD, 18));
		center.add(tab);

		// panel on tab
		booking = new JPanel();
		tab.add("Booking", booking);
		booking.setLayout(null);
		booking.setBackground(Color.WHITE);

		history = new JPanel();
		history.setLayout(new BorderLayout());
		tab.add("Booking History", history);

		// booking panel

		// inside panel 0
		// panel
		panel0 = new JPanel();
		panel0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		panel0.setBounds(10, 0, 400, 660);
		panel0.setOpaque(false);

		// for new Panel

		// All Labels

		arrival_date = new JLabel("Arrival Date");
		arrival_date.setBounds(10, 10, 100, 30);

		departure_date = new JLabel("Departure Date");
		departure_date.setBounds(10, 50, 100, 30);

		room_type = new JLabel("Room Type");
		room_type.setBounds(10, 90, 100, 30);

		// ALL Text Fields
		txt_id = new JTextField();
		txt_id.setText(Integer.toString(Global.obj1.getId()));
		txt_booking_id = new JTextField();
		

		
		Date date = new Date();
		
		
		txt_arrival_date = new JDateChooser();
		txt_arrival_date.setMinSelectableDate(date);
		txt_arrival_date.setDateFormatString("yyyy-MM-dd");
		txt_arrival_date.setBounds(110, 10, 280, 30);
		txt_arrival_date.setFont(new Font("Verdana", 1, 14));

		txt_departure_date = new JDateChooser();
		txt_departure_date.setMinSelectableDate(date);
		txt_departure_date.setDateFormatString("yyyy-MM-dd");
		txt_departure_date.setBounds(110, 50, 280, 30);
		txt_departure_date.setFont(new Font("Verdana", 1, 14));

		Object[] h5 = { "Single", "Double", "Twin" };
		txt_room_type = new JComboBox(h5);
		txt_room_type.setBounds(110, 90, 280, 30);
		txt_room_type.setFont(new Font("Verdana", 1, 14));

		// All button
		book = new JButton("Book");
		book.setBounds(130, 130, 200, 30);
		book.setFocusable(false);
		book.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(130,170,200,30);
		cancel.setFocusable(false);
		cancel.addActionListener(this);

		// add to panel
		panel0.setLayout(null);
		// label
		panel0.add(arrival_date);
		panel0.add(departure_date);
		panel0.add(room_type);

		// text fields
		panel0.add(txt_arrival_date);
		panel0.add(txt_departure_date);
		panel0.add(txt_room_type);

		// button
		panel0.add(book);
		panel0.add(cancel);
		// panel0.add(search);
		// panel 0 end

		// table
         //*****************Table 1********************
		columnsName = new Object[5];
		columnsName[0] = "Booking ID";
		columnsName[1] = "Arrival Date";
		columnsName[2] = "Departure Date";
		columnsName[3] = "Room Type";
		columnsName[4] = "Booking Status";

		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		table.addMouseListener(this);


		updateTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(450, 0, 900, 700);
		booking.add(scrollPane);

		booking.add(panel0);

		// history panel
		// table 2***************************
		Column = new Object[6];
		Column[0] = "Booking ID";
		Column[1] = "Arrival Date";
		Column[2] = "Departure Date";
		Column[3] = "Room No";
		Column[4] = "Room Type";
		Column[5] = "Booking Status";

		table2 = new JTable();
		dm = (DefaultTableModel) table2.getModel();
		dm.setColumnIdentifiers(Column);
		table2.addMouseListener(this);


		updateTable2();
		JScrollPane scroll = new JScrollPane(table2);
		scroll.setBounds(450, 0, 900, 700);
		history.add(scroll,BorderLayout.CENTER);
		

		frame.setVisible(true);

	}

	public void updateTable() {

		search = new BookingJDBC().select_all();
		model.setRowCount(0);
		for (Booking bookingLibs : search) {
			Object tmpRow[] = { bookingLibs.getBooking_id(),
					bookingLibs.getArrival_date(),
					bookingLibs.getDeparture_date(), 
					bookingLibs.getBooking_type(),
					bookingLibs.getBooking_status(), };

			model.addRow(tmpRow);
		}
		table = new JTable(model);
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(0, 0, 0));
		h.setForeground(new Color(255, 255, 255));
		table.addMouseListener(this);

	}
	
	public void updateTable2() {

		search = new BookingJDBC().bookinghistory();
		dm.setRowCount(0);
		for (Booking bookingLibs : search) {
			Object tmpRow[] = { bookingLibs.getBooking_id(),
					bookingLibs.getArrival_date(),
					bookingLibs.getDeparture_date(),
					bookingLibs.getRoom_no(),
					bookingLibs.getBooking_type(),
					bookingLibs.getBooking_status(), };

			dm.addRow(tmpRow);
		}
		table2 = new JTable(dm);
		JTableHeader h1 = table2.getTableHeader();
		h1.setBackground(new Color(0, 0, 0));
		h1.setForeground(new Color(255, 255, 255));
		table2.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == sign_out) {
			frame.dispose();
			new SignIn();
		} else if (ae.getSource() == book) {
			Booking boo = new Booking();

			int id = Integer.parseInt(txt_id.getText());
			String arrival = ((JTextField) txt_arrival_date.getDateEditor().getUiComponent()).getText();
			String departure = ((JTextField) txt_departure_date.getDateEditor().getUiComponent()).getText();
			String roomtype = txt_room_type.getSelectedItem().toString();

			boo.setCustomer_id(id);
			boo.setArrival_date(arrival);
			boo.setDeparture_date(departure);
			boo.setBooking_type(roomtype);
			boo.setBooking_status("Requested");

			BookingJDBC jdbc = new BookingJDBC();
			boolean result = jdbc.insert(boo);
			if (result == true) {
				updateTable();
				JOptionPane.showMessageDialog(null, "Requested");
			} else {
				JOptionPane.showMessageDialog(null, "Unsuccessful");
			}
		} else if (ae.getSource() == cancel) {
			int booking_id = Integer.parseInt(txt_booking_id.getText());
			BookingJDBC jdbc = new BookingJDBC();
			boolean result = jdbc.delete(booking_id);
			if (result == true) {
				updateTable();
				JOptionPane.showMessageDialog(null, "Deleted Successfully");
			} else {
				JOptionPane.showMessageDialog(null, "Unsuccessful to Delete");
			}
		}

	}

	public void mouseClicked(MouseEvent ei) {
		if (ei.getSource()==table) 	{
			try {
		int h2 = table.getSelectedRow();
		TableModel model = table.getModel();
		String booking_id = model.getValueAt(h2, 0).toString();
		txt_booking_id.setText(booking_id);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(h2, 1));
		txt_arrival_date.setDate(date);
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(h2, 2));
		txt_departure_date.setDate(date2);
		String room_type = model.getValueAt(h2,3).toString();
		txt_room_type.setSelectedItem(room_type);
		
			}catch (Exception ex) {
				System.out.println("Error :"+ex.getMessage());
			}
		}
	}

	public static void main(String args[]) {
		new CusDashboard();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
