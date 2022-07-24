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

import main_gui.SignIn;
import mylibs.Booking;
import mylibs.BookingCustomer;
import mylibs.BookingJDBC;
import mylibs.Room;
import mylibs.RoomJDBC;

public class ReceptionistDashboard implements MouseListener, ActionListener {
	JFrame frame;
	JPanel north, west, center, up, down;
	JLabel logo, heading, booking_id, customer_name, arrival_date, departure_date, room_no, room_status;
	JButton btncustomer, btnbooking, btnroom, btnbilling, btnextra, sign_out, customer, room, bill, extra_services,
			check_in, check, assign;
	JDateChooser txt_arrival_date, txt_departure_date;
	JTextField txt_booking_id, txt_customer_name, txt_room_no;
	Object[] columnsName;
	JTable table;
	DefaultTableModel model;
	ArrayList<BookingCustomer> search;
	JComboBox txt_room_status;

//Sub class
	public ReceptionistDashboard() {
		frame = new JFrame(); // JFrame creation
		frame.setSize(1345, 600); // sets the size position of frame
		frame.setTitle("Receptionist DashBoard"); // Add title to the frame
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		// north panel
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

		sign_out = new JButton("Sign-Out");
		sign_out.setBounds(1255, 5, 85, 40);
		sign_out.setBackground(new Color(254, 242, 78));
		sign_out.setFocusable(false);
		sign_out.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 0)));
		sign_out.addActionListener(this);
		north.add(sign_out);

		// left/west panel
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

		room_status = new JLabel("Room Status");
		room_status.setBounds(10, 240, 150, 30);
		room_status.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(room_status);

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

		String status[] = { "Booked", "Room Not Available" };
		txt_room_status = new JComboBox(status);
		txt_room_status.setBounds(170, 240, 200, 30);
		txt_room_status.setFont(new Font("Verdana", Font.BOLD, 14));
		west.add(txt_room_status);

		// button in west panel
		check = new JButton("Check");
		check.setBounds(170, 310, 200, 30);
		check.setFocusable(false);
		west.add(check);
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AvailableRoomGUI();
			}
		});

		assign = new JButton("Assign");
		assign.setBounds(170, 350, 200, 30);
		assign.setFocusable(false);
		west.add(assign);
		assign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == assign) {

					// **********Update Room***********

					Room room = new Room();

					int roomid = Integer.parseInt(txt_room_no.getText());

					room.setRoom_no(roomid);
					room.setRoom_status("Booked");

					RoomJDBC jdbc = new RoomJDBC();
					boolean result1 = jdbc.update(room);

					// ***********Update Booking Table**********8

					Booking booking = new Booking();

					booking.setBooking_id(Integer.parseInt(txt_booking_id.getText()));

					booking.setRoom_no(Integer.parseInt(txt_room_no.getText()));
					booking.setBooking_status(txt_room_status.getSelectedItem().toString());

					BookingJDBC jdbc2 = new BookingJDBC();
					boolean result = jdbc2.receptionbookingupdate(booking);
					if (result == true) {
						updateTable();
						JOptionPane.showMessageDialog(null, "The booking is confirmed");

					}

					else {
						JOptionPane.showMessageDialog(null, "Error");
					}

				}

			}

		});

		// west panel complete

		// center panel

		center = new JPanel();
		center.setLayout(new BorderLayout());
		frame.add(center, BorderLayout.CENTER);

		// center panel up panel
		up = new JPanel();
		up.setBackground(new Color(47, 79, 79));
		up.setPreferredSize(new Dimension(100, 200));
		up.setLayout(null);
		center.add(up, BorderLayout.NORTH);

		// button on up panel
		customer = new JButton("Customer");
		customer.setBounds(30, 30, 200, 30);
		customer.setFocusable(false);
		customer.setFont(new Font("Verdana", Font.BOLD, 14));
		customer.addActionListener(this);
		up.add(customer);

		room = new JButton("Room");
		room.setBounds(30, 120, 200, 30);
		room.setFocusable(false);
		room.setFont(new Font("Verdana", Font.BOLD, 14));
		room.addActionListener(this);
		up.add(room);

		extra_services = new JButton("Extra Services");
		extra_services.setBounds(300, 30, 200, 30);
		extra_services.setFocusable(false);
		extra_services.setFont(new Font("Verdana", Font.BOLD, 14));
		extra_services.addActionListener(this);
		up.add(extra_services);

		check_in = new JButton("Check-In");
		check_in.setBounds(300, 120, 200, 30);
		check_in.setFocusable(false);
		check_in.setFont(new Font("Verdana", Font.BOLD, 14));
		check_in.addActionListener(this);
		up.add(check_in);

		bill = new JButton("Bill");
		bill.setBounds(550, 75, 200, 30);
		bill.setFocusable(false);
		bill.addActionListener(this);
		bill.setFont(new Font("Verdana", Font.BOLD, 14));
		up.add(bill);

		// center panel down panel

		// ***************table**********************
		columnsName = new Object[7];
		columnsName[0] = "Customer ID";
		columnsName[1] = "Customer Name";
		columnsName[2] = "Booking ID";
		columnsName[3] = "Arrival Date";
		columnsName[4] = "Departure Date";
		columnsName[5] = "Booking Type";
		columnsName[6] = "Booking Status";

		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		table.addMouseListener(this);

		updateTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 900, 700);
		center.add(scrollPane, BorderLayout.CENTER);

		frame.setVisible(true);
	}

	public void updateTable() {

		search = new BookingJDBC().select();
		model.setRowCount(0);
		for (BookingCustomer bookingLibs : search) {
			Object tmpRow[] = { bookingLibs.getCustomer_id(), bookingLibs.getCustomer_name(),
					bookingLibs.getBooking_id(), bookingLibs.getArrival_date(), bookingLibs.getDeparture_date(),
					bookingLibs.getBooking_type(), bookingLibs.getBooking_status(), };

			model.addRow(tmpRow);
		}
		table = new JTable(model);
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(0, 0, 0));
		h.setForeground(new Color(255, 255, 255));
		table.addMouseListener(this);

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
				String booking_status = model.getValueAt(h2, 6).toString();
				txt_room_status.setSelectedItem(booking_status);

			} catch (Exception ex) {
				System.out.println("Error :" + ex.getMessage());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == customer) {
			frame.dispose();
			new Customer();
		} else if (ae.getSource() == extra_services) {
			frame.dispose();
			new ServiceGUI();
		} else if (ae.getSource() == check_in) {
			frame.dispose();
			new CheckIn();
		} else if (ae.getSource() == sign_out) {
			frame.dispose();
			new SignIn();
		} else if (ae.getSource()== bill) {
			frame.dispose();
			new BillingGUI();
		} else if (ae.getSource()==room) {
			frame.dispose();
			new Room_details();
		}
	}

// main class
	public static void main(String[] args) {
		new ReceptionistDashboard();

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
