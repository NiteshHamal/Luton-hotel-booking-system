package manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import mylibs.BillingLibs;
import mylibs.BillingLibs2;
import mylibs.Booking;
import mylibs.BookingJDBC;
import mylibs.Global;
import mylibs.JDBCBilling;
import mylibs.Room;
import mylibs.RoomJDBC;

public class BillingGUI implements MouseListener {
	JFrame frame;
	JTextField searchField;
	TableRowSorter sorter;
	JTable table1;
	JTextField bookingidtxt, customeridtxt, nametxt, typetxt, roomratetxt, servicepricetxt, foodpricetxt, vattxt,
			servicechargetxt, totalbilltxt, drinktxt, roomidtxt, noofdaystxt,reg_typetxt,
			roompricetxt, discounttxt;
	JComboBox statustxt;
	JButton back,generatebillbtn, clearbtn;
	Object[] Column;
	DefaultTableModel model;
	ArrayList<BillingLibs> Billing;
	JDateChooser c1, c2;

	public BillingGUI() {
		frame = new JFrame("Check Out");
		frame.setSize(1450, 800);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		// ***************North Panel*****************
		JPanel north = new JPanel();
		north.setLayout(null);
		north.setBackground(new Color(255, 195, 0));
		north.setPreferredSize(new Dimension(100, 50));
		frame.add(north, BorderLayout.NORTH);

		bookingidtxt = new JTextField();

		JLabel title = new JLabel("CHECK OUT", SwingConstants.CENTER);
		title.setBounds(580, 0, 230, 50);
		title.setFont(new Font("Verdana", Font.BOLD, 25));
		north.add(title);

		JLabel searchlbl = new JLabel("Search: ");
		searchlbl.setBounds(10, 0, 210, 50);
		searchlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		north.add(searchlbl);

		searchField = new JTextField();
		searchField.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		searchField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		searchField.setBounds(100, 10, 200, 30);
		north.add(searchField);

		searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(searchField.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search(searchField.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				search(searchField.getText());
			}

			public void search(String str) {
				if (str.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(str));
				}
			}
		});
		
		back = new JButton("Back");
		back.setBounds(1255, 5, 85, 40);
		back.setBackground(new Color(254, 242, 78));
		back.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 0)));
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new ReceptionistDashboard();
			}
		});		
		north.add(back);

		// **********************Center Panel*****************
		Column = new Object[10];
		Column[0] = "Booking ID";
		Column[1] = "Arrival Date";
		Column[2] = "Departure Date";
		Column[3] = "Name";
		Column[4] = "Reg Type";
		Column[5] = "Bar Charge";
		Column[6] = "Food Charge";
		Column[7] = "Service Charge";
		Column[8] = "Room ID";
		Column[9] = "Room Price";
		table1 = new JTable();
		model = (DefaultTableModel) table1.getModel();
		model.setColumnIdentifiers(Column);

		updateTable();
		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setBounds(400, 20, 500, 400);
		frame.add(scroll1, BorderLayout.CENTER);

		// *******************WEST Panel******************
		JPanel west = new JPanel();
		west.setLayout(null);
		west.setPreferredSize(new Dimension(400, 320));
		frame.add(west, BorderLayout.WEST);

		// *******************SOUTH Panel******************
		JPanel southPanel = new JPanel();
		southPanel.setLayout(null);
		southPanel.setPreferredSize(new Dimension(400, 280));
		frame.add(southPanel, BorderLayout.SOUTH);

		roomidtxt = new JTextField();

		JLabel namelbl = new JLabel("Name:");
		namelbl.setBounds(10, 20, 210, 35);
		namelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(namelbl);

		nametxt = new JTextField();
		nametxt.setBounds(180, 20, 210, 35);
		nametxt.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(nametxt);

		JLabel checkinlbl = new JLabel("Arrival Date:");
		checkinlbl.setBounds(10, 70, 210, 35);
		checkinlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(checkinlbl);

		c1 = new JDateChooser();
		c1.setDateFormatString("yyyy-MM-dd");
		c1.setBounds(180, 70, 210, 35);
		c1.setFont(new Font("Verdana", Font.PLAIN, 18));
		west.add(c1);

		JLabel checkoutlbl = new JLabel("Departure Date: ");
		checkoutlbl.setBounds(10, 120, 210, 35);
		checkoutlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(checkoutlbl);

		c2 = new JDateChooser();
		c2.setDateFormatString("yyyy-MM-dd");
		c2.setBounds(180, 120, 210, 35);
		c2.setFont(new Font("Verdana", Font.PLAIN, 18));
		west.add(c2);

		JLabel noofdays = new JLabel("No of Days: ");
		noofdays.setBounds(10, 170, 210, 35);
		noofdays.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(noofdays);

		noofdaystxt = new JTextField();
		noofdaystxt.setBounds(180, 170, 210, 35);
		noofdaystxt.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(noofdaystxt);

		roomratetxt = new JTextField();
		
		JLabel reg_type = new JLabel("Customer Type:");
		reg_type.setBounds(10, 220, 210, 35);
		reg_type.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(reg_type);
		
		reg_typetxt = new JTextField();
		reg_typetxt.setBounds(180, 220, 210, 35);
		reg_typetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(reg_typetxt);

		JLabel roomlbl = new JLabel("Drink Amount:");
		roomlbl.setBounds(10, 270, 210, 35);
		roomlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(roomlbl);

		drinktxt = new JTextField();
		drinktxt.setBounds(180, 270, 210, 35);
		drinktxt.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(drinktxt);

		JLabel servicepricelbl = new JLabel("Service Amount:");
		servicepricelbl.setBounds(10, 320, 210, 35);
		servicepricelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(servicepricelbl);

		servicepricetxt = new JTextField();
		servicepricetxt.setBounds(180, 320, 210, 35);
		servicepricetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		west.add(servicepricetxt);

		JLabel foodpricelbl = new JLabel("Food Price:");
		foodpricelbl.setBounds(10, 0, 210, 35);
		foodpricelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(foodpricelbl);

		foodpricetxt = new JTextField();
		foodpricetxt.setBounds(180, 0, 210, 35);
		foodpricetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(foodpricetxt);

		JLabel roompricelbl1 = new JLabel("Room Price:");
		roompricelbl1.setBounds(10, 60, 210, 35);
		roompricelbl1.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(roompricelbl1);

		roompricetxt = new JTextField();
		roompricetxt.setBounds(180, 60, 210, 35);
		roompricetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(roompricetxt);

		JLabel vatlbl = new JLabel("VAT:");
		vatlbl.setBounds(10, 110, 210, 35);
		vatlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(vatlbl);

		vattxt = new JTextField();
		vattxt.setText("13%");
		vattxt.setEditable(false);
		vattxt.setBounds(180, 110, 210, 35);
		vattxt.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(vattxt);

		JLabel servicechargelbl = new JLabel("Service Charge: ");
		servicechargelbl.setBounds(10, 160, 210, 35);
		servicechargelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(servicechargelbl);

		servicechargetxt = new JTextField();
		servicechargetxt.setText("Rs: 100");
		servicechargetxt.setEditable(false);
		servicechargetxt.setBounds(180, 160, 210, 35);
		servicechargetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(servicechargetxt);

		JLabel discountlbl = new JLabel("Discount:");
		discountlbl.setBounds(10, 210, 210, 35);
		discountlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(discountlbl);

		discounttxt = new JTextField();
		discounttxt.setBounds(180, 210, 210, 35);
		discounttxt.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(discounttxt);
		discounttxt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float roomprice1;
				float serviceprice1;
				float foodprice1;
				float drinkprice1;

				drinkprice1 = Integer.parseInt(drinktxt.getText());
				roomprice1 = Integer.parseInt(roompricetxt.getText());
				serviceprice1 = Integer.parseInt(servicepricetxt.getText());
				foodprice1 = Integer.parseInt(foodpricetxt.getText());

				double h5 = roomprice1 + serviceprice1 + foodprice1 + drinkprice1+100;
				double h6 = h5 + (0.13*h5);
				double h7 = Double.parseDouble(discounttxt.getText());
				double h8=h7/100;
			    double h9=h8*h6;
				double h10 = (h6-h9);
				totalbilltxt.setText(Double.toString(h10));
				
			}
			
			
		});

		JLabel totalbilllbl = new JLabel("Total Charge: ");
		totalbilllbl.setBounds(450, 60, 210, 35);
		totalbilllbl.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(totalbilllbl);

		totalbilltxt = new JTextField();
		totalbilltxt.setBounds(660, 60, 210, 35);
		totalbilltxt.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(totalbilltxt);
		
		generatebillbtn = new JButton("Pay");
		generatebillbtn.setFocusable(false);
		generatebillbtn.setBounds(450, 130, 200, 35);
		generatebillbtn.setFont(new Font("Verdana", Font.BOLD, 18));
		generatebillbtn.setForeground(Color.white);
		generatebillbtn.setBackground(new Color(106, 101, 101));
		southPanel.add(generatebillbtn);
		generatebillbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == generatebillbtn) {
					Room room = new Room();
					int roomid = Integer.parseInt(roomidtxt.getText());
					room.setRoom_no(roomid);
					room.setRoom_status("Available");
					RoomJDBC jdbc1 = new RoomJDBC();
					boolean result1 = jdbc1.update(room);
					// *******************Update Booking Status**************
					Booking booking = new Booking();
					booking.setBooking_id(Integer.parseInt(bookingidtxt.getText()));
					booking.setBooking_status("Inactive");
					BookingJDBC jdbc2 = new BookingJDBC();
					boolean result = jdbc2.checkinupdate(booking);
					// *****************Blling********************
					BillingLibs2 billing = new BillingLibs2();
					billing.setName(nametxt.getText());
					billing.setRoom_Price(Integer.parseInt(roompricetxt.getText()));
					billing.setFood_Price(Integer.parseInt(foodpricetxt.getText()));
					billing.setBar_Price(Integer.parseInt(drinktxt.getText()));
					billing.setService_Price(Integer.parseInt(servicepricetxt.getText()));
					billing.setTotal_Bill(Double.parseDouble(totalbilltxt.getText()));
					billing.setDiscount(Double.parseDouble(discounttxt.getText()));
					billing.setBooking_id(Integer.parseInt(bookingidtxt.getText()));
					Global.currentBilling = billing;
					JDBCBilling jdbc = new JDBCBilling();
					boolean result5 = jdbc.insert(billing);
					if (result5 == true) {
						updateTable();
						JOptionPane.showMessageDialog(null, "Data stored");
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
					new InvoiceGUI();
				}
			}
		});
		
		JButton print = new JButton("Print Invoice");
		print.setFocusable(false);
		print.setBounds(700, 130, 200, 35);
		print.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		print.setFont(new Font("Verdana", Font.BOLD, 18));
		print.setForeground(Color.white);
		print.setBackground(new Color(106, 101, 101));
		southPanel.add(print);
		print.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == print) {
					Room room = new Room();
					int roomid = Integer.parseInt(roomidtxt.getText());
					room.setRoom_no(roomid);
					room.setRoom_status("Available");
					RoomJDBC jdbc1 = new RoomJDBC();
					boolean result1 = jdbc1.update(room);
					// *******************Update Booking Status**************
					Booking booking = new Booking();
					booking.setBooking_id(Integer.parseInt(bookingidtxt.getText()));
					booking.setBooking_status("Inactive");
					BookingJDBC jdbc2 = new BookingJDBC();
					boolean result = jdbc2.checkinupdate(booking);
					//*******************billing*****************
					BillingLibs2 billing = new BillingLibs2();
					billing.setName(nametxt.getText());
					billing.setRoom_Price(Integer.parseInt(roompricetxt.getText()));
					billing.setFood_Price(Integer.parseInt(foodpricetxt.getText()));
					billing.setBar_Price(Integer.parseInt(drinktxt.getText()));
					billing.setService_Price(Integer.parseInt(servicepricetxt.getText()));
					billing.setTotal_Bill(Double.parseDouble(totalbilltxt.getText()));
					billing.setDiscount(Double.parseDouble(discounttxt.getText()));
					billing.setBooking_id(Integer.parseInt(bookingidtxt.getText()));
					Global.currentBilling = billing;
					JDBCBilling jdbc = new JDBCBilling();
					boolean result5 = jdbc.insert(billing);
					if (result5 == true) {
						updateTable();
						JOptionPane.showMessageDialog(null, "Data stored");
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
					new InvoiceGUI();
				}				}
			});
				
		
		clearbtn = new JButton("Clear");
		clearbtn.setFocusable(false);
		clearbtn.setBounds(585, 180, 200, 35);
		clearbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		clearbtn.setFont(new Font("Verdana", Font.BOLD, 18));
		clearbtn.setForeground(Color.white);
		clearbtn.setBackground(new Color(106, 101, 101));
		southPanel.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				discounttxt.setText(null);
				nametxt.setText(null);
				noofdaystxt.setText(null);
				foodpricetxt.setText(null);
				drinktxt.setText(null);
				roomratetxt.setText(null);
				roompricetxt.setText(null);
				servicepricetxt.setText(null);
				foodpricetxt.setText(null);
				totalbilltxt.setText(null);
			}
		});
		frame.setVisible(true);

	}

	public void updateTable() {

		Billing = new JDBCBilling().billingview();
		model.setRowCount(0);
		for (BillingLibs billingLibs : Billing) {
			Object tmpRow[] = { billingLibs.getBooking_ID(), billingLibs.getCheckIn(), billingLibs.getCheckOut(),
					billingLibs.getName(),billingLibs.getReg_type(), billingLibs.getBar(), billingLibs.getFood(), billingLibs.getService(),
					billingLibs.getRoom_ID(), billingLibs.getRoom_Price()

			};

			model.addRow(tmpRow);
		}
		table1 = new JTable(model);
		table1.addMouseListener(this);
		sorter = new TableRowSorter<>(model);
		table1.setRowSorter(sorter);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		try {

			int h1 = table1.getSelectedRow();

			TableModel model = table1.getModel();

			String roomid = model.getValueAt(h1, 8).toString();
			roomidtxt.setText(roomid);

			String bookingid = model.getValueAt(h1, 0).toString();
			bookingidtxt.setText(bookingid);

			String name = model.getValueAt(h1, 3).toString();
			nametxt.setText(name);

			String drinkamount = model.getValueAt(h1, 5).toString();
			drinktxt.setText(drinkamount);

			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h1, 1));
			c1.setDate(date);

			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h1, 2));
			c2.setDate(date2);

			String roomprice = model.getValueAt(h1, 9).toString();
			roomratetxt.setText(roomprice);

			String serviceprice = model.getValueAt(h1, 7).toString();
			servicepricetxt.setText(serviceprice);

			String foodprice = model.getValueAt(h1, 6).toString();
			foodpricetxt.setText(foodprice);
			
			String regtype = model.getValueAt(h1, 4).toString();
			reg_typetxt.setText(regtype);

			String fromdate = ((JTextField) c1.getDateEditor().getUiComponent()).getText();
			String todate = ((JTextField) c2.getDateEditor().getUiComponent()).getText();

			LocalDate fday = LocalDate.parse(fromdate);
			LocalDate tday = LocalDate.parse(todate);

			Long day_gap = ChronoUnit.DAYS.between(fday, tday);
			noofdaystxt.setText(String.valueOf(day_gap));

			int rate = Integer.parseInt(roomratetxt.getText());
			int days = Integer.parseInt(noofdaystxt.getText());
			int result = rate * days;
			roompricetxt.setText(String.valueOf(result));

			

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}

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
		new BillingGUI();
	}

}
