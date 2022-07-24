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
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import main_gui.SignIn;
import mylibs.BarJDBC;
import mylibs.BarLibs;
import mylibs.Global;
import mylibs.JDBCService;
import mylibs.ServiceLibs;

public class BarGUI implements MouseListener{
	JFrame frame;
	JComboBox bookingCombo,itemCombo,quantityCombo;
	JTextField ratetxt,pricetxt;
	JLabel logo;
	Object[] columnsName;
	DefaultTableModel model;
	JTable table;
	ArrayList<BarLibs>select;

	public BarGUI() {

		frame = new JFrame("Restaurant Dashboard");
		frame.setSize(950, 650);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));


		// *****************North Panel****************
		JPanel north = new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(100, 50));
		north.setBackground(new Color(255,195,0));
		frame.add(north, BorderLayout.NORTH);

		// Title Label
		JLabel titlelbl = new JLabel("Bar Dashboard");
		titlelbl.setFont(new Font("Times New Roman", Font.BOLD, 40));
		titlelbl.setBorder(new MatteBorder(0, 0, 3, 0, Color.black));
		titlelbl.setBounds(500, 10, 270, 35);
		north.add(titlelbl);

		JButton logoutbtn = new JButton("Log Out");
		logoutbtn.setFocusable(false);
		logoutbtn.setBackground(new Color(254, 242, 78));
		logoutbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		logoutbtn.setBounds(1255, 5, 100, 40);
		logoutbtn.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 0)));
		north.add(logoutbtn);
		logoutbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SignIn();	
			}
		});
		
		logo = new JLabel("");
		Image lbl = new ImageIcon(this.getClass().getResource("logo2.jpg")).getImage();
		logo.setIcon(new ImageIcon(lbl));
		logo.setBounds(10, 2, 60, 45);
		north.add(logo);
		
		//****************West Panel***************
		JPanel west = new JPanel();
		west = new JPanel();
		west.setLayout(null);
		west.setPreferredSize(new Dimension(350, 100));
		west.setBackground(new Color(47, 79, 79));
		frame.add(west, BorderLayout.WEST);
		
		JLabel CustomerNamelbl = new JLabel("Booking ID:");
		CustomerNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CustomerNamelbl.setBounds(20, 30, 400, 30);
		CustomerNamelbl.setForeground(Color.white);
		west.add(CustomerNamelbl);
		
		bookingCombo = new JComboBox();
		bookingCombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bookingCombo.setBounds(130, 30, 200, 30);
		bookingCombo.setBorder(BorderFactory.createLineBorder(Color.white,1));
		west.add(bookingCombo);
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			String query1 = "SELECT booking_id FROM booking WHERE booking_status = 'Active';";
			PreparedStatement pst1 = conn.prepareStatement(query1);
			ResultSet rst1 = pst1.executeQuery();
			String booking_id = "";
			while (rst1.next()) {
				
				bookingCombo.addItem(rst1.getString("booking_id"));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		JLabel itemcombolbl = new JLabel("Items Name:");
		itemcombolbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		itemcombolbl.setBounds(20, 80, 400, 30);
		itemcombolbl.setForeground(Color.white);
		west.add(itemcombolbl);
		
		itemCombo = new JComboBox();
		for (int i = 0; i < Global.BAR_TYPES.length; i++) {
			itemCombo.addItem(Global.BAR_TYPES[i]);
		}
		itemCombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		itemCombo.setBounds(130, 80, 200, 30);
		itemCombo.setBorder(BorderFactory.createLineBorder(Color.white,1));
		west.add(itemCombo);
		itemCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==itemCombo) {
					int index=itemCombo.getSelectedIndex();
					ratetxt.setText(Integer.toString(Global.BAR_PRICE[index]));
				}
				
			}
			
			
		});
		
		JLabel ratelbl = new JLabel("Rate:");
		ratelbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ratelbl.setBounds(20, 130, 400, 30);
		ratelbl.setForeground(Color.white);
		west.add(ratelbl);
		
		ratetxt = new JTextField();
		ratetxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ratetxt.setBounds(130, 130, 200, 30);
		ratetxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		west.add(ratetxt);
		
		JLabel quantitylbl = new JLabel("Quantity:");
		quantitylbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		quantitylbl.setBounds(20, 180, 400, 30);
		quantitylbl.setForeground(Color.white);
		west.add(quantitylbl);
		
		Object[]h5= {1,2,3,4,5};
		quantityCombo = new JComboBox(h5);
		quantityCombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		quantityCombo.setBounds(130, 180, 200, 30);
		quantityCombo.setBorder(BorderFactory.createLineBorder(Color.white,1));
		west.add(quantityCombo);
		quantityCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int price;
				price=Integer.parseInt(quantityCombo.getSelectedItem().toString());
				int rate=Integer.parseInt(ratetxt.getText());
				int total=price*rate;
				pricetxt.setText(Integer.toString(total));
			}
		});
		
		JLabel pricelbl = new JLabel("Total Price:");
		pricelbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pricelbl.setBounds(20, 230, 200, 30);
		pricelbl.setForeground(Color.white);
		west.add(pricelbl);
		
		pricetxt = new JTextField();
		pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pricetxt.setBounds(130, 230, 200, 30);
		pricetxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		west.add(pricetxt);
		
		JButton orderbtn = new JButton("Order");
		orderbtn.setBackground(new Color(59,59,59));
		orderbtn.setForeground(Color.white);
		orderbtn.setFocusable(false);
		orderbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		orderbtn.setBounds(20, 280, 150, 30);
		orderbtn.setBorder(BorderFactory.createLineBorder(Color.white,1));
		west.add(orderbtn);
		orderbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
	
				BarLibs bar=new BarLibs();
				bar.setBooking_id(Integer.parseInt(bookingCombo.getSelectedItem().toString()));
				bar.setBar_item(itemCombo.getSelectedItem().toString());
				bar.setRate(Integer.parseInt(ratetxt.getText()));
				bar.setQuantity(Integer.parseInt(quantityCombo.getSelectedItem().toString()));
				bar.setTotal_price(Integer.parseInt(pricetxt.getText()));
				BarJDBC jdbc=new BarJDBC();
				boolean result=jdbc.insert(bar);
				if(result==true) {
					JOptionPane.showMessageDialog(null, "The item is ordered successfully");	
				}
				else {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		
		JButton searchbtn = new JButton("Search Customers");
		searchbtn.setBackground(new Color(59,59,59));
		searchbtn.setForeground(Color.white);
		searchbtn.setFocusable(false);
		searchbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchbtn.setBounds(100, 330, 150, 30);
		searchbtn.setBorder(BorderFactory.createLineBorder(Color.white,1));
		west.add(searchbtn);
		searchbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==searchbtn) {
				new AvailableCustomerGUI();
				}	
			}
		});
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.setBackground(new Color(59,59,59));
		clearbtn.setForeground(Color.white);
		clearbtn.setFocusable(false);
		clearbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clearbtn.setBounds(180, 280, 150, 30);
		clearbtn.setBorder(BorderFactory.createLineBorder(Color.white,1));
		west.add(clearbtn);
		
		//****************Center Panel***************
		JPanel center = new JPanel();
		center.setLayout(null);
		center.setPreferredSize(new Dimension(100, 60));
		frame.add(center, BorderLayout.CENTER);
		
		columnsName = new Object[6];
		columnsName[0] = "Bar ID";
		columnsName[1] = "Booking ID";
		columnsName[2] = "Item Name";
		columnsName[3] = "Rate";
		columnsName[4] = "Quantity";
		columnsName[5] = "Total Price";

		table = new JTable();
		table.addMouseListener(this);
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);

		updateTable();
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		frame.add(scroll1, BorderLayout.CENTER);


		// *****************South Panel****************
		JPanel south = new JPanel();
		south.setLayout(null);
		south.setPreferredSize(new Dimension(100, 60));
		south.setBackground(new Color(255,195,0));
		frame.add(south, BorderLayout.SOUTH);
		
		
		
		JLabel southtitle = new JLabel("Luton Hotel Pvt.Ltd");
		southtitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
		southtitle.setBounds(550, 20, 450, 30);
		south.add(southtitle);

		frame.setVisible(true);

	}
	
	public void updateTable() {
		select = new BarJDBC().select_all();
		model.setRowCount(0);
		for (BarLibs service : select) {
			Object tmpRow[] = { service.getBar_id(),service.getBooking_id(),
					service.getBar_item(),service.getRate(),service.getQuantity(),
					service.getTotal_price()
			};

			model.addRow(tmpRow);
		}
		table = new JTable(model);
		table.addMouseListener(this);

	}

	public static void main(String[] args) {
		new BarGUI();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
