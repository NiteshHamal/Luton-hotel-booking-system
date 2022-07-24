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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.table.TableModel;

import mylibs.Global;
import mylibs.JDBCService;
import mylibs.ServiceLibs;

public class ServiceGUI implements ActionListener, MouseListener {
	JFrame frame;
	JButton back, insertbtn, updatebtn, cancelbtn, searchcustomer;
	JTextField pricetxt, serviceidtxt;
	JComboBox servicetypecombo, bookingcombo;
	Object[] columnsName;
	DefaultTableModel model;
	JTable table;
	ArrayList<ServiceLibs> select;
	JLabel logo, servicetypelbl, titlelbl, booingidlbl, servicepricelbl;
	JPanel north, west;

	public ServiceGUI() {
		frame = new JFrame("Service Management");
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setSize(1050, 650);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		// ***************North Panel******************8
		north = new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(100, 50));
		north.setBackground(new Color(255, 193, 0));
		frame.add(north, BorderLayout.NORTH);

		titlelbl = new JLabel("Service Management", SwingConstants.CENTER);
		titlelbl.setFont(new Font("Verdana", Font.BOLD, 25));
		titlelbl.setBounds(560, 0, 320, 50);
		north.add(titlelbl);

		back = new JButton("Back");
		back.setBounds(1255, 5, 85, 40);
		back.setBackground(new Color(254, 242, 78));
		back.setFocusable(false);
		back.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 0)));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == back) {
					frame.dispose();
					new ReceptionistDashboard();
				}
			}
		});
		north.add(back);

		logo = new JLabel("");
		Image lbl = new ImageIcon(this.getClass().getResource("logo2.jpg")).getImage();
		logo.setIcon(new ImageIcon(lbl));
		logo.setBounds(10, 2, 60, 45);
		north.add(logo);

		// ***************WEST Panel******************8
		west = new JPanel();
		west.setLayout(null);
		west.setPreferredSize(new Dimension(350, 100));
		west.setBackground(new Color(47, 79, 79));
		frame.add(west, BorderLayout.WEST);

		booingidlbl = new JLabel("Booking ID:");
		booingidlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		booingidlbl.setBounds(20, 30, 400, 30);
		booingidlbl.setForeground(Color.white);
		west.add(booingidlbl);

		bookingcombo = new JComboBox();
		bookingcombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bookingcombo.setBounds(130, 30, 200, 30);
		bookingcombo.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(bookingcombo);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			String query1 = "SELECT booking_id FROM booking WHERE booking_status = 'Active';";
			PreparedStatement pst1 = conn.prepareStatement(query1);
			ResultSet rst1 = pst1.executeQuery();
			String booking_id = "";
			while (rst1.next()) {
				bookingcombo.addItem(rst1.getString("booking_id"));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		servicetypelbl = new JLabel("Service Type:");
		servicetypelbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		servicetypelbl.setBounds(20, 90, 400, 30);
		servicetypelbl.setForeground(Color.white);
		west.add(servicetypelbl);

		servicetypecombo = new JComboBox();
		for (int i = 0; i < Global.SERVICE_TYPES.length; i++) {
			servicetypecombo.addItem(Global.SERVICE_TYPES[i]);
		}
		servicetypecombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		servicetypecombo.setBounds(130, 90, 200, 30);
		servicetypecombo.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(servicetypecombo);
		servicetypecombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == servicetypecombo) {
					int index = servicetypecombo.getSelectedIndex();
					pricetxt.setText(Long.toString(Global.SERVICE_PRICE[index]));
				}

			}

		});

		servicepricelbl = new JLabel("Service Price:");
		servicepricelbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		servicepricelbl.setBounds(20, 150, 400, 30);
		servicepricelbl.setForeground(Color.white);
		west.add(servicepricelbl);

		pricetxt = new JTextField();
		pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pricetxt.setBounds(130, 150, 200, 30);
		pricetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(pricetxt);

		serviceidtxt = new JTextField();

		insertbtn = new JButton("Order");
		insertbtn.addActionListener(this);
		insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		insertbtn.setBounds(20, 220, 100, 30);
		insertbtn.setFocusable(false);
		insertbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(insertbtn);

		updatebtn = new JButton("Update");
		updatebtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updatebtn.setBounds(130, 220, 100, 30);
		updatebtn.setFocusable(false);
		updatebtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == updatebtn) {

					ServiceLibs service = new ServiceLibs();

					service.setService_ID(Integer.parseInt(serviceidtxt.getText()));
					service.setBooking_ID(Integer.parseInt(bookingcombo.getSelectedItem().toString()));
					service.setService_Type(servicetypecombo.getSelectedItem().toString());
					service.setService_Price(Integer.parseInt(pricetxt.getText()));

					JDBCService jdbc = new JDBCService();
					boolean result1 = jdbc.update(service);
					if (result1 == true) {
						updateTable();
						JOptionPane.showMessageDialog(null, "Service Updated");
					}

				}

			}

		});

		cancelbtn = new JButton("Cancel");
		cancelbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cancelbtn.setBounds(240, 220, 100, 30);
		cancelbtn.setFocusable(false);
		cancelbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(cancelbtn);
		cancelbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.parseInt(serviceidtxt.getText());

				JDBCService service = new JDBCService();
				boolean result2 = service.delete(ID);
				if (result2 == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Deleted");
				} else {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}

		});

		searchcustomer = new JButton("Customers");
		searchcustomer.setBounds(130, 260, 100, 30);
		searchcustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchcustomer.setFocusable(false);
		searchcustomer.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(searchcustomer);
		searchcustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AvailableCustomerGUI();
	}
			}

		);

		// **************Center Panel***************
		columnsName = new Object[4];
		columnsName[0] = "Service ID";
		columnsName[1] = "Booking ID";
		columnsName[2] = "Service Type";
		columnsName[3] = "Service Price";

		table = new JTable();
		table.addMouseListener(this);
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);

		updateTable();
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		frame.add(scroll1, BorderLayout.CENTER);

		frame.setVisible(true);

	}

	public void updateTable() {
		select = new JDBCService().select_all();
		model.setRowCount(0);
		for (ServiceLibs service : select) {
			Object tmpRow[] = { service.getService_ID(), service.getBooking_ID(), service.getService_Type(),
					service.getService_Price(),

			};

			model.addRow(tmpRow);
		}
		table = new JTable(model);
		table.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ServiceLibs service = new ServiceLibs();

		service.setBooking_ID(Integer.parseInt(bookingcombo.getSelectedItem().toString()));
		service.setService_Type(servicetypecombo.getSelectedItem().toString());
		service.setService_Price(Long.parseLong(pricetxt.getText()));

		JDBCService jdbc = new JDBCService();
		boolean result = jdbc.insert(service);
		if (result == true) {
			updateTable();
			JOptionPane.showMessageDialog(null, "The service is ordered!");

		} else {
			JOptionPane.showMessageDialog(null, "Error!");
		}

	}

	public void mouseClicked(MouseEvent ex) {
		int h2 = table.getSelectedRow();

		TableModel model = table.getModel();

		String bookingid = model.getValueAt(h2, 1).toString();
		bookingcombo.setSelectedItem(bookingid);

		String type = model.getValueAt(h2, 2).toString();
		servicetypecombo.setSelectedItem(type);

		String serviceid = model.getValueAt(h2, 0).toString();
		serviceidtxt.setText(serviceid);
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

	public static void main(String[] args) {
		new ServiceGUI();

	}

}
