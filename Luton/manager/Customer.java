package manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import mylibs.Registration;
import mylibs.RegistrationJDBC;

public class Customer extends JFrame implements ActionListener {

	JFrame frame;
	JLabel logo, name, address, email, phone, credit, reg_type, heading2, caption, customer_id, username, password;
	JTextField txt_name, txt_address, txt_email, txt_phone, txt_credit, txt_id, txt_username;
	JTextField txt_search;
	JButton back,search, clear, update, add;
	JTable table;
	JScrollPane scrollPane;
	DefaultTableModel dtm,model;
	JPanel panel0, north, center;
	JLabel label1;
	Object[] columnsName;
	JComboBox cmb_reg_type;
	JPasswordField txt_password;
	ArrayList<Registration>search5;
	public Customer() {
		// frame
		frame = new JFrame();
		frame.setTitle("Customers");
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
		center = new JPanel();
		center.setBackground(Color.WHITE);
		center.setLayout(null);
		frame.add(center, BorderLayout.CENTER);

		// inside panel 0
		// panel
		panel0 = new JPanel();
		panel0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		panel0.setBounds(10, 0, 400, 660);
		panel0.setOpaque(false);

		// heading
		heading2 = new JLabel("Customers Details");
		heading2.setBounds(150, 10, 200, 20);

		// caption = new JLabel("address or phone_no or Email");
		caption = new JLabel("Enter Customer Name :");
		caption.setBounds(20, 50, 200, 20);

		// search field
		txt_search = new JTextField();
		txt_search.setBounds(20, 80, 200, 30);
		txt_search.setFocusable(true);
		txt_search.setOpaque(false);
		txt_search.setFont(new Font("Verdana", 1, 14));
		// for new Panel

		// All Labels
		customer_id = new JLabel("Customer ID");
		customer_id.setBounds(10, 140, 100, 30);

		name = new JLabel("Name");
		name.setBounds(10, 180, 100, 30);

		address = new JLabel("Address");
		address.setBounds(10, 220, 100, 30);

		email = new JLabel("Email");
		email.setBounds(10, 260, 100, 30);

		phone = new JLabel("Phone No");
		phone.setBounds(10, 300, 100, 30);

		credit = new JLabel("Credit Info");
		credit.setBounds(10, 340, 100, 30);

		reg_type = new JLabel("Reg_type");
		reg_type.setBounds(10, 380, 100, 30);

		username = new JLabel("Username");
		username.setBounds(10, 420, 100, 30);

		password = new JLabel("Password");
		password.setBounds(10, 460, 100, 30);

		// ALL Text Fields
		txt_id = new JTextField();
		txt_id.setBounds(110, 140, 280, 30);
		txt_id.setFont(new Font("Verdana", 1, 14));
		txt_id.setEditable(false);

		txt_name = new JTextField();
		txt_name.setBounds(110, 180, 280, 30);
		txt_name.setFont(new Font("Verdana", 1, 14));

		txt_address = new JTextField();
		txt_address.setBounds(110, 220, 280, 30);
		txt_address.setFont(new Font("Verdana", 1, 14));

		txt_email = new JTextField();
		txt_email.setBounds(110, 260, 280, 30);
		txt_email.setFont(new Font("Verdana", 1, 14));

		txt_phone = new JTextField();
		txt_phone.setBounds(110, 300, 280, 30);
		txt_phone.setFont(new Font("Verdana", 1, 14));

		txt_credit = new JTextField();
		txt_credit.setBounds(110, 340, 280, 30);
		txt_credit.setFont(new Font("Verdana", 1, 14));

		String registration[] = { "Corporate", "Non-Corporate" };
		cmb_reg_type = new JComboBox(registration);
		cmb_reg_type.setBounds(110, 380, 280, 30);
		cmb_reg_type.setFont(new Font("Verdana", 1, 14));

		txt_username = new JTextField();
		txt_username.setBounds(110, 420, 280, 30);
		txt_username.setFont(new Font("Verdana", 1, 14));

		txt_password = new JPasswordField();
		txt_password.setBounds(110, 460, 280, 30);
		txt_password.setFont(new Font("Verdana", 1, 14));

		// search button
		search = new JButton("search");
		search.setBounds(240, 80, 150, 30);
		search.setFocusable(false);
		search.addActionListener(this);

		// clear button
		clear = new JButton("Clear");
		clear.setBounds(50, 500, 150, 30);
		clear.setFocusable(false);
		clear.addActionListener(this);

		// add button
		add = new JButton("Add");
		add.setBounds(220, 500, 150, 30);
		add.setFocusable(false);
		add.addActionListener(this);

		// update button
		update = new JButton("Update");
		update.setBounds(50, 540, 150, 30);
		update.setFocusable(false);
		update.addActionListener(this);


		// add to panel
		panel0.setLayout(null);
		panel0.add(txt_search);
		panel0.add(search);
		panel0.add(clear);
		panel0.add(add);
		panel0.add(update);
		panel0.add(heading2);
		panel0.add(caption);
		// label
		panel0.add(customer_id);
		panel0.add(name);
		panel0.add(address);
		panel0.add(phone);
		panel0.add(email);
		panel0.add(credit);
		panel0.add(reg_type);
		panel0.add(username);
		panel0.add(password);
		// text fields
		panel0.add(txt_id);
		panel0.add(txt_name);
		panel0.add(txt_address);
		panel0.add(txt_phone);
		panel0.add(txt_email);
		panel0.add(txt_credit);
		panel0.add(cmb_reg_type);
		panel0.add(txt_username);
		panel0.add(txt_password);
		// panel 0 end
		
		//*************table***************
		
		columnsName = new Object[9];
		columnsName[0] = "ID";
		columnsName[1] = "Name";
		columnsName[2] = "Address";
		columnsName[3] = "Email";
		columnsName[4] = "Phone No";
		columnsName[5] = "Credit Info";
		columnsName[6] = "Username";
		columnsName[7] = "Password";
		columnsName[8] = "Registration Type";

		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);

		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(450, 0, 900, 700);
		center.add(scroll1);

		// frame add to

		center.add(panel0);
		updateTable();
		frame.setVisible(true);
	}
	
	public void updateTable() {
		search5 = new RegistrationJDBC().select_all();
		model.setRowCount(0);
		for (Registration bookingLibs : search5) {
			Object tmpRow[] = { bookingLibs.getId(),
					bookingLibs.getFullName(),
					bookingLibs.getAddress(),
					bookingLibs.getEmail(),
					bookingLibs.getPhoneNo(),
					bookingLibs.getCreditCardNo(),
					bookingLibs.getUsername(),
					bookingLibs.getPassword(),
					bookingLibs.getRegType()

			};

			model.addRow(tmpRow);
		}
		table = new JTable(model);

		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			txt_id.setText("");
			txt_search.setText("");
			txt_name.setText("");
			txt_address.setText("");
			txt_email.setText("");
			txt_phone.setText("");
			txt_credit.setText("");
			cmb_reg_type.setSelectedIndex(0);
			txt_username.setText("");
			txt_password.setText("");
		} else if (ae.getSource() == add) {
			Registration reg = new Registration();
			reg.setFullName(txt_name.getText());
			reg.setAddress(txt_address.getText());
			reg.setEmail(txt_email.getText());
			reg.setPhoneNo(Long.parseLong(txt_phone.getText()));
			reg.setCreditCardNo(Long.parseLong(txt_credit.getText()));
			reg.setRegType(cmb_reg_type.getSelectedItem().toString());
			reg.setUsername(txt_username.getText());
			reg.setPassword(txt_password.getText());

			RegistrationJDBC jdbc = new RegistrationJDBC();
			boolean result = jdbc.insert(reg);
			if (result == true) {
				updateTable();
				JOptionPane.showMessageDialog(null, "Successful to Add Customer Details");
			} else {
				JOptionPane.showMessageDialog(null, "Unsuccessful to Add Customer Details");
			}
		} else if (ae.getSource() == search) {
			Registration reg = new Registration();
			String name = txt_search.getText();
			RegistrationJDBC jdbc = new RegistrationJDBC();
			reg = jdbc.search(name);
			if (reg.getId() > 0) {
				int customer_id = reg.getId();
				txt_id.setText(Integer.toString(customer_id));
				String fullname = reg.getFullName();
				txt_name.setText(fullname);
				String address = reg.getAddress();
				txt_address.setText(address);
				long phoneno = reg.getPhoneNo();
				txt_phone.setText(Long.toString(phoneno));
				String email = reg.getEmail();
				txt_email.setText(email);
				long creditcardno = reg.getCreditCardNo();
				txt_credit.setText(Long.toString(creditcardno));
				String username = reg.getUsername();
				txt_username.setText(username);
				String password = reg.getPassword();
				txt_password.setText(password);

				String regtype = reg.getRegType();
				if (regtype.equals("Corporate")) {
					cmb_reg_type.setSelectedIndex(0);
				} else if (regtype.equals("Non-Corporate")) {
					cmb_reg_type.setSelectedIndex(1);
				}
			} else
				JOptionPane.showMessageDialog(null, "Error to search");
		} else if (ae.getSource()==update) {
			int customer_id=Integer.parseInt(txt_id.getText());
			String fullname=txt_name.getText();
			String address = txt_address.getText();
			long phone_no = Long.parseLong(txt_phone.getText());
			String email = txt_email.getText();
			long creditcardno = Long.parseLong(txt_credit.getText());
			String username = txt_username.getText();
			String password = txt_password.getText();
			String reg_type=cmb_reg_type.getSelectedItem().toString();	
			Registration bio=new Registration();
			bio.setId(customer_id);
			bio.setFullName(fullname);
			bio.setAddress(address);
			bio.setPhoneNo(phone_no);
			bio.setEmail(email);
			bio.setCreditCardNo(creditcardno);
			bio.setUsername(username);
			bio.setPassword(password);
			bio.setRegType(reg_type);
			RegistrationJDBC jdbc11=new RegistrationJDBC();
			boolean result5=jdbc11.update(bio);
			if(result5==true) {
				updateTable();
				JOptionPane.showMessageDialog(null, "Data Updated");
			}
		} else if (ae.getSource()==back) {
			frame.dispose();
			new ReceptionistDashboard();
		}

	}


	public static void main(String[] args) {
		new Customer();
	}

}
