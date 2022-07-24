package manager;

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

import mylibs.Booking;
import mylibs.BookingCustomer;
import mylibs.BookingJDBC;

public class CheckIn implements ActionListener, MouseListener {
	JFrame frame;
	JPanel north, west;
	JLabel heading, logo, booking_id, customer_name, arrival_date, departure_date, room_no, booking_status;
	JTextField txt_booking_id, txt_customer_name, txt_room_no;
	JDateChooser txt_arrival_date, txt_departure_date;
	JComboBox txt_booking_status;
	JButton back, check_in, cancel;
	Object[] Column;
	JTable table;
	DefaultTableModel dm;
	ArrayList<BookingCustomer> check;
	JScrollPane scroll;

	public CheckIn() {
		frame = new JFrame("Check-In");
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 500);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		// heading panel

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

		back = new JButton("Back");
		back.setBounds(1255, 5, 85, 40);
		back.setBackground(new Color(254, 242, 78));
		back.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 0)));
		back.setFocusable(false);
		back.addActionListener(this);
		north.add(back);

		// ************west panel**************
		west = new JPanel();
		west.setBackground(Color.white);
		west.setPreferredSize(new Dimension(450, 50));
		west.setLayout(null);
		west.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		west.setOpaque(false);
		frame.add(west, BorderLayout.WEST);

		// label on west panel
		booking_id = new JLabel("Booking ID");
		booking_id.setBounds(10, 40, 150, 30);
		booking_id.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(booking_id);

		customer_name = new JLabel("Customer Name");
		customer_name.setBounds(10, 80, 150, 30);
		customer_name.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(customer_name);

		arrival_date = new JLabel("Arrival Date");
		arrival_date.setBounds(10, 120, 150, 30);
		arrival_date.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(arrival_date);

		departure_date = new JLabel("Departure Date");
		departure_date.setBounds(10, 160, 150, 30);
		departure_date.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(departure_date);

		room_no = new JLabel("Room No.");
		room_no.setBounds(10, 200, 150, 30);
		room_no.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(room_no);

		booking_status = new JLabel("Room Status");
		booking_status.setBounds(10, 240, 150, 30);
		booking_status.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(booking_status);

		// text field in west panel
		txt_booking_id = new JTextField();
		txt_booking_id.setBounds(170, 40, 200, 30);
		txt_booking_id.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(txt_booking_id);

		txt_customer_name = new JTextField();
		txt_customer_name.setBounds(170, 80, 200, 30);
		txt_customer_name.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(txt_customer_name);

		Date date = new Date();
		txt_arrival_date = new JDateChooser();
		txt_arrival_date.setMinSelectableDate(date);
		txt_arrival_date.setDateFormatString("yyyy-MM-dd");
		txt_arrival_date.setBounds(170, 120, 200, 30);
		txt_arrival_date.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(txt_arrival_date);

		txt_departure_date = new JDateChooser();
		txt_departure_date.setMinSelectableDate(date);
		txt_departure_date.setDateFormatString("yyyy-MM-dd");
		txt_departure_date.setBounds(170, 160, 200, 30);
		txt_departure_date.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(txt_departure_date);

		txt_room_no = new JTextField();
		txt_room_no.setBounds(170, 200, 200, 30);
		txt_room_no.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(txt_room_no);

		String status[] = { "Active" };
		txt_booking_status = new JComboBox(status);
		txt_booking_status.setBounds(170, 240, 200, 30);
		txt_booking_status.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(txt_booking_status);

		// button in west panel
		check_in = new JButton("Check In");
		check_in.setBounds(170, 310, 200, 30);
		check_in.setFocusable(false);
		check_in.addActionListener(this);
		west.add(check_in);

		cancel = new JButton("Cancel");
		cancel.setBounds(170, 350, 200, 30);
		cancel.setFocusable(false);
		west.add(cancel);

		// ********table************

		Column = new Object[8];
		Column[0] = "Customer ID";
		Column[1] = "Customer Name";
		Column[2] = "Booking ID";
		Column[3] = "Arrival Date";
		Column[4] = "Departure Date";
		Column[5] = "Room no";
		Column[6] = "Booking Type";
		Column[7] = "Booking Status";

		table = new JTable();
		dm = (DefaultTableModel) table.getModel();
		dm.setColumnIdentifiers(Column);

		updateTable();
		scroll = new JScrollPane(table);
		scroll.setBounds(450, 0, 900, 700);
		frame.add(scroll, BorderLayout.CENTER);

		frame.setVisible(true);

	}

	public void updateTable() {

		check = new BookingJDBC().CheckIn();
		dm.setRowCount(0);
		for (BookingCustomer booking : check) {
			Object tmpRow[] = { booking.getCustomer_id(), booking.getCustomer_name(), booking.getBooking_id(),
					booking.getArrival_date(), booking.getDeparture_date(), booking.getRoom_no(),
					booking.getBooking_type(), booking.getBooking_status(), };

			dm.addRow(tmpRow);
		}
		table = new JTable(dm);
		table.addMouseListener(this);
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(0, 0, 0));
		h.setForeground(new Color(255, 255, 255));
		// table.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back) {
			frame.dispose();
			new ReceptionistDashboard();
		} else if (ae.getSource()==check_in) {
			Booking book = new Booking();
			book.setBooking_id(Integer.parseInt(txt_booking_id.getText()));
			book.setBooking_status(txt_booking_status.getSelectedItem().toString());
			BookingJDBC jdbc = new BookingJDBC();
			boolean result = jdbc.checkinupdate(book);
			if (result == true) {
				updateTable();
				JOptionPane.showMessageDialog(null, "The booking is Active");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error");
			}
		}
	}
	
	public void mouseClicked(MouseEvent ei) {
		if (ei.getSource() == table) {
			try {
				int h2 = table.getSelectedRow();
				TableModel model = table.getModel();
				String booking_id = model.getValueAt(h2, 2).toString();
				txt_booking_id.setText(booking_id);
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h2, 3));
				txt_arrival_date.setDate(date);
				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h2, 4));
				txt_departure_date.setDate(date2);
				String customer_name = model.getValueAt(h2, 1).toString();
				txt_customer_name.setText(customer_name);
				String booking_status = model.getValueAt(h2, 7).toString();
				txt_booking_status.setSelectedItem(booking_status);
				String room_no = model.getValueAt(h2,5).toString();
				txt_room_no.setText(room_no);
			} catch (Exception ex) {
				System.out.println("Error :" + ex.getMessage());
			}
		}
	}


	public static void main(String args[]) {
		new CheckIn();
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
