package main_gui;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import customer.CusDashboard;
import mylibs.Global;
import mylibs.Registration;
import mylibs.RegistrationJDBC;

public class SignInCustomer implements ActionListener {
	JFrame frame;
	JPanel north, west, center;
	JLabel logo, heading, image, username, password;
	JTextField txt_username;
	JPasswordField txt_password;
	JButton clear, back, sign_in;

	public SignInCustomer() {

		// frame
		frame = new JFrame("Customer Sign_In");
		frame.setSize(950, 550);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
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

		// label
		username = new JLabel("Username");
		username.setBounds(130, 230, 150, 30);
		username.setFont(new Font("Verdana", Font.BOLD, 20));

		password = new JLabel("Password");
		password.setBounds(130, 270, 150, 30);
		password.setFont(new Font("Verdana", Font.BOLD, 18));

		// text field
		txt_username = new JTextField();
		txt_username.setBounds(320, 230, 200, 30);
		txt_username.setFont(new Font("Verdana", Font.BOLD, 14));

		txt_password = new JPasswordField();
		txt_password.setBounds(320, 270, 200, 30);
		txt_password.setFont(new Font("Verdana", Font.BOLD, 14));

		// button
		clear = new JButton("Clear");
		clear.setBounds(435, 310, 85, 30);
		clear.setFocusable(false);
		clear.addActionListener(this);
		clear.setFont(new Font("Verdana", Font.BOLD, 13));

		back = new JButton("Back");
		back.setBounds(377, 350, 85, 30);
		back.setFocusable(false);
		back.addActionListener(this);
		back.setFont(new Font("Verdana", Font.BOLD, 13));

		sign_in = new JButton("Sign In");
		sign_in.setBounds(320, 310, 85, 30);
		sign_in.setFocusable(false);
		sign_in.addActionListener(this);
		sign_in.setFont(new Font("Verdana", Font.BOLD, 13));

		// add to center
		center.add(username);
		center.add(password);
		center.add(txt_username);
		center.add(txt_password);
		center.add(clear);
		center.add(back);
		center.add(sign_in);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			txt_username.setText("");
			txt_password.setText("");
		} else if (ae.getSource() == back) {
			frame.dispose();
			new SignIn();
		} else if (ae.getSource() == sign_in) {
			Registration reg = new Registration();
			reg.setUsername(txt_username.getText());
			reg.setPassword(txt_password.getText());
			Global.obj1 = reg;
			reg = new RegistrationJDBC().login(reg);
			if (reg.getId() > 0) {
				JOptionPane.showMessageDialog(null, "Welcome " + reg.getFullName());
				// display manager Window
				frame.dispose();
				new CusDashboard();
			} else {
				JOptionPane.showMessageDialog(null, "Error: Username or Password");
			}
		}

	}

	public static void main(String args[]) {
		new SignInCustomer();
	}
}
