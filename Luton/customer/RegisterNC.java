package customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main_gui.DashboardOne;
import mylibs.RegexExpression;
import mylibs.Registration;
import mylibs.RegistrationJDBC;

public class RegisterNC implements ActionListener {
	JFrame frame;
	JLabel logo, heading, image, name, address, phone, email, credit, username, password, reg_type;
	JPanel north, west, center;
	JTextField txt_name, txt_address, txt_phone, txt_email, txt_credit, txt_username;
	JPasswordField txt_password;
	JButton register, clear, back;
	JComboBox regType;

	public RegisterNC() {
		// frame

		frame = new JFrame("Registration");
		frame.setSize(950, 550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
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

		// Image panel

		west = new JPanel();
		west.setBackground(Color.WHITE);
		west.setPreferredSize(new Dimension(650, 150));
		frame.add(west, BorderLayout.WEST);

		image = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("Hotel Booking-cuate.png")).getImage();
		image.setIcon(new ImageIcon(img));
		west.add(image);

		// center panel

		center = new JPanel();
		center.setBackground(Color.WHITE);
		center.setLayout(null);
		frame.add(center, BorderLayout.CENTER);

		name = new JLabel("Full Name");
		name.setBounds(130, 150, 150, 30);
		name.setFont(new Font("Verdana", Font.BOLD, 18));

		txt_name = new JTextField();
		txt_name.setBounds(320, 150, 200, 30);
		txt_name.setFont(new Font("Verdana", 1, 14));

		address = new JLabel("Address");
		address.setBounds(130, 190, 150, 30);
		address.setFont(new Font("Verdana", Font.BOLD, 18));

		txt_address = new JTextField();
		txt_address.setBounds(320, 190, 200, 30);
		txt_address.setFont(new Font("Verdana", 1, 14));

		phone = new JLabel("Phone No.");
		phone.setBounds(130, 230, 150, 30);
		phone.setFont(new Font("Verdana", Font.BOLD, 18));

		txt_phone = new JTextField();
		txt_phone.setBounds(320, 230, 200, 30);
		txt_phone.setFont(new Font("Verdana", 1, 14));

		email = new JLabel("E-mail");
		email.setBounds(130, 270, 150, 30);
		email.setFont(new Font("Verdana", Font.BOLD, 18));

		txt_email = new JTextField();
		txt_email.setBounds(320, 270, 200, 30);
		txt_email.setFont(new Font("Verdana", 1, 14));

		credit = new JLabel("CreditCard No.");
		credit.setBounds(130, 310, 150, 30);
		credit.setFont(new Font("Verdana", Font.BOLD, 18));

		txt_credit = new JTextField();
		txt_credit.setBounds(320, 310, 200, 30);
		txt_credit.setFont(new Font("Verdana", 1, 14));

		username = new JLabel("Username");
		username.setBounds(130, 350, 150, 30);
		username.setFont(new Font("Verdana", Font.BOLD, 18));

		txt_username = new JTextField();
		txt_username.setBounds(320, 350, 200, 30);
		txt_username.setFont(new Font("Verdana", 1, 14));

		password = new JLabel("Password");
		password.setBounds(130, 390, 150, 30);
		password.setFont(new Font("Verdana", Font.BOLD, 18));

		txt_password = new JPasswordField();
		txt_password.setBounds(320, 390, 200, 30);
		txt_password.setFont(new Font("Verdana", 1, 14));

		reg_type = new JLabel("Reg Type");
		reg_type.setBounds(130, 430, 150, 30);
		reg_type.setFont(new Font("Verdana", Font.BOLD, 18));

		String registration[] = { "Corporate", "Non-Corporate" };
		regType = new JComboBox(registration);
		regType.setBounds(320, 430, 200, 30);
		regType.setFont(new Font("Verdana", 1, 14));

		register = new JButton("Register");
		register.setBounds(320, 470, 85, 30);
		register.setFocusable(false);
		register.addActionListener(this);
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				RegexExpression val = new RegexExpression();
				if (e.getSource() == register) {

					if (txt_name.getText().trim().isEmpty() || txt_address.getText().trim().isEmpty()
							|| txt_phone.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please fill all fields");
					}
				}
				if (e.getSource() == register) {

					String Name = txt_name.getText();
					boolean resultFName = val.Name(Name);
					if (resultFName == true) {

						String Address = txt_address.getText();
						boolean Address2 = val.Address(Address);
						if (Address2 == true) {

							String Phone = txt_phone.getText();
							boolean Phone2 = val.Phone(Phone);
							if (Phone2 == true) {

									String Credit = txt_credit.getText();
									boolean Credit2 = val.CreditCard(Credit);
									if (Credit2 == true) {

										String Username = txt_username.getText();
										boolean Username2 = val.UserName(Username);
										if (Username2 == true) {

											String Password = txt_password.getText();
											boolean Password2 = val.Password(Password);
											if (Password2 == true) {
												
												Registration reg = new Registration();
												reg.setFullName(txt_name.getText());
												reg.setAddress(txt_address.getText());
												reg.setPhoneNo(Long.parseLong(txt_phone.getText()));
												reg.setEmail(txt_email.getText());
												reg.setCreditCardNo(Long.parseLong(txt_credit.getText()));
												reg.setUsername(txt_username.getText());
												reg.setPassword(txt_password.getText());
												reg.setRegType(regType.getSelectedItem().toString());

												RegistrationJDBC jdbc = new RegistrationJDBC();
												boolean result = jdbc.insert(reg);
												if (result == true) {
													JOptionPane.showMessageDialog(null, "Registration Successful");
												}else {
													JOptionPane.showMessageDialog(null, "Registration Unsuccessful");
												}
												}else {
												
													JOptionPane.showMessageDialog(null, "Please Enter Proper Password");
												}
											} else {
												JOptionPane.showMessageDialog(null, "Please Enter Proper Username");
											}
										} else {
											JOptionPane.showMessageDialog(null, "Please Enter Proper Credit Card No.");
										}
								
								} else {
									JOptionPane.showMessageDialog(null, "Invalid Phone No");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Please Enter Correct Address");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Invalid Name");
						}
					} 
				}
			
		});

		clear = new JButton("Clear");
		clear.setBounds(435, 470, 85, 30);
		clear.setFocusable(false);
		clear.addActionListener(this);

		back = new JButton("Back");
		back.setBounds(377, 510, 85, 30);
		back.setFocusable(false);
		back.addActionListener(this);

		// add to center panel

		center.add(name);
		center.add(address);
		center.add(phone);
		center.add(email);
		center.add(credit);
		center.add(username);
		center.add(password);
		center.add(reg_type);
		center.add(txt_name);
		center.add(txt_address);
		center.add(txt_phone);
		center.add(txt_email);
		center.add(txt_credit);
		center.add(txt_username);
		center.add(txt_password);
		center.add(regType);
		center.add(register);
		center.add(clear);
		center.add(back);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			txt_name.setText("");
			txt_address.setText("");
			txt_phone.setText("");
			txt_email.setText("");
			txt_credit.setText("");
			txt_username.setText("");
			txt_password.setText("");
			regType.setSelectedIndex(0);
		} else if (ae.getSource() == back) {
			frame.dispose();
			new DashboardOne();
	}

	}

	public static void main(String[] args) {
		new RegisterNC();
	}

}
