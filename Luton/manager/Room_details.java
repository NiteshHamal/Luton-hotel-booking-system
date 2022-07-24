package manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

import mylibs.Global;
import mylibs.Room;
import mylibs.RoomJDBC;

public class Room_details implements ActionListener, MouseListener, ItemListener {
	JFrame frame;
	JLabel logo, lblcaption, heading, label1, Room_no, Room_status, Room_Type, Price;
	JTextField Room_num, txtRoom_Type, txtPrice, txt_search;
	JPanel panel0, north, west;
	JScrollPane scrollPane;
	JButton search, clear, update, back;
	JTable table;
	JComboBox RoomType, RoomStatus;
	DefaultTableModel dtm;

	public Room_details() {
		// Initializing and memory allocation
		// frame
		// frame
		frame = new JFrame();
		frame.setTitle("Booking");
		frame.setSize(1366, 768);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		// heading
		north = new JPanel();
		north.setBackground(new Color(255, 193, 0));
		north.setPreferredSize(new Dimension(100, 50));
		north.setLayout(null);
		frame.add(north, BorderLayout.NORTH);

		label1 = new JLabel("Hotel Luton", SwingConstants.CENTER);
		label1.setFont(new Font("Verdana", Font.BOLD, 25));
		label1.setBounds(580, 0, 230, 50);
		north.add(label1);

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

		// Body

		west = new JPanel();
		west.setBackground(Color.WHITE);
		west.setLayout(null);
		west.setPreferredSize(new Dimension(450, 400));
		frame.add(west, BorderLayout.WEST);

		// inside panel 0
		// panel
		panel0 = new JPanel();
		panel0.setBounds(10, 0, 400, 660);
		panel0.setOpaque(false);

		// heading
		heading = new JLabel("Room Details");
		heading.setBounds(150, 10, 200, 20);

		// caption
		lblcaption = new JLabel(" Enter Room no : ");
		lblcaption.setBounds(20, 50, 200, 20);

		// search field
		txt_search = new JTextField();
		txt_search.setBounds(20, 80, 200, 30);
		txt_search.setFocusable(true);
		txt_search.setOpaque(false);
		txt_search.setFont(new Font("Verdana", 1, 14));
		// for new Panel

		// All Labels

		Room_no = new JLabel("Room no");
		Room_no.setBounds(10, 140, 100, 30);

		Room_status = new JLabel("Room status");
		Room_status.setBounds(10, 180, 100, 30);

		Room_Type = new JLabel("Room Type");
		Room_Type.setBounds(10, 220, 100, 30);

		Price = new JLabel("Price");
		Price.setBounds(10, 260, 100, 30);

		// ALL Text Fields
		Room_num = new JTextField();
		Room_num.setBounds(110, 140, 280, 30);
		Room_num.setFont(new Font("Verdana", 1, 14));

		RoomStatus = new JComboBox();
		for (int i = 0; i < Global.RoomStatus.length; i++) {
			RoomStatus.addItem(Global.RoomStatus[i]);
		}
		RoomStatus.setBounds(110, 180, 280, 30);
		RoomStatus.setFont(new Font("Verdana", 1, 14));

		RoomType = new JComboBox();
		for (int i = 0; i < Global.RoomType.length; i++) {
			RoomType.addItem(Global.RoomType[i]);
		}
		RoomType.setBounds(110, 220, 280, 30);
		RoomType.setFont(new Font("Verdana", 1, 14));
		RoomType.addItemListener(this);

		txtPrice = new JTextField();
		txtPrice.setBounds(110, 260, 280, 30);
		txtPrice.setFont(new Font("Verdana", 1, 14));

		// search button
		search = new JButton("search");
		search.setBounds(240, 80, 150, 30);
		search.addActionListener(this);

		// clear button
		clear = new JButton("Clear");
		clear.setBounds(50, 500, 150, 30);
		clear.addActionListener(this);

		// update button
		update = new JButton("Update");
		update.setBounds(220, 500, 150, 30);
		update.addActionListener(this);

		// back button


		// add to panel
		panel0.setLayout(null);
		panel0.add(txt_search);
		panel0.add(search);
		panel0.add(clear);
		panel0.add(update);
		panel0.add(heading);
		panel0.add(lblcaption);

		// label
		panel0.add(Room_no);
		panel0.add(Room_status);
		panel0.add(Room_Type);
		panel0.add(Price);

		// text fields
		panel0.add(Room_num);
		panel0.add(RoomStatus);
		panel0.add(RoomType);
		panel0.add(txtPrice);

		// panel 0 end

		// table
		dtm = new DefaultTableModel();
		table = new JTable(dtm);
		// table.setBackground(Color.CYAN);
		table.setPreferredScrollableViewportSize(new Dimension(1050, 300));
		table.setFillsViewportHeight(true);
		table.addMouseListener(this);

		JTableHeader h1 = table.getTableHeader();
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(450, 0, 1050, 700);
		// columns
		dtm.addColumn("Room no");
		dtm.addColumn("Room Type");
		dtm.addColumn("Room Status");
		dtm.addColumn("Price");
		refresh();

		// frame add to

		west.add(panel0);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	private void refresh() {
		dtm.setRowCount(0);
		RoomJDBC jdbc = new RoomJDBC();
		ArrayList search = jdbc.select_all();
		if (search.size() > 0) {
			for (int i = 0; i < search.size(); i++) {
				Room mroom = (Room) search.get(i);
				Object[] tmp = { mroom.getRoom_no(), mroom.getRoom_type(), mroom.getRoom_status(),
						mroom.getRoom_price() };
				dtm.addRow(tmp);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			txt_search.setText(null);
			Room_num.setText(null);
			RoomStatus.setSelectedIndex(0);
			RoomType.setSelectedIndex(0);
			txtPrice.setText(null);

		} else if (ae.getSource() == search) {
			Room room = new Room();
			int Room_no = Integer.parseInt(txt_search.getText());
			RoomJDBC jdbc = new RoomJDBC();
			room = jdbc.search(Room_no);
			if (room.getRoom_no() > 0) {
				Room_num.setText(Integer.toString(room.getRoom_no()));
				int Room_num = room.getRoom_no();
				txtPrice.setText(Integer.toString(room.getRoom_price()));
				Integer txtPrice = room.getRoom_price();
				String roomType = room.getRoom_type();
				if (roomType.equals("Single")) {
					RoomType.setSelectedIndex(0);
				} else if (roomType.equals("Double")) {
					RoomType.setSelectedIndex(1);
				} else if (roomType.equals("Twin")) {
					RoomType.setSelectedIndex(2);
				}

				String roomStatus = room.getRoom_status();
				if (roomStatus.equals("Available")) {
					RoomStatus.setSelectedIndex(0);
				} else if (roomStatus.equals("Booked")) {
					RoomStatus.setSelectedIndex(1);
				}

			}

		} else if (ae.getSource() == update) {
			int room_no = Integer.parseInt(Room_num.getText());
			String room_type = RoomType.getSelectedItem().toString();
			String room_status = RoomStatus.getSelectedItem().toString();
			int room_price = Integer.parseInt(txtPrice.getText());
			Room room = new Room();
			room.setRoom_no(room_no);
			room.setRoom_type(room_type);
			room.setRoom_price(room_price);
			room.setRoom_status(room_status);
			RoomJDBC jdbc = new RoomJDBC();
			boolean result = jdbc.update(room);
			if (result == true) {
				refresh();
				JOptionPane.showMessageDialog(null, "Successful to Update");
			} else {
				JOptionPane.showMessageDialog(null, "Unsuccessful to Update");
			}
		} else if (ae.getSource() == back) {
			frame.dispose();
			new ReceptionistDashboard();
		}
	}

	@Override
	public void mouseClicked(MouseEvent ei) {

		int h2 = table.getSelectedRow();
		TableModel model = table.getModel();
		Room_num.setText(model.getValueAt(h2, 0).toString());

		String roomStatus = model.getValueAt(h2, 2).toString();
		RoomStatus.setSelectedItem(roomStatus);

		String roomType = model.getValueAt(h2, 1).toString();
		RoomType.setSelectedItem(roomType);

		txtPrice.setText(model.getValueAt(h2, 3).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == RoomType) {
			int index = RoomType.getSelectedIndex();
			txtPrice.setText(Double.toString(Global.RoomPrice[index]));
		}

	}

	public static void main(String[] args) {
		new Room_details();

	}

}
