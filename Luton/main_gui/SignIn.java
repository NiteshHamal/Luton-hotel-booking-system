package main_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SignIn implements ActionListener {
	JFrame frame;
	JLabel  logo,heading, moto, bground, cus, mem;
	JPanel north, south;
	JButton customer, hotelmember, back;

	public SignIn() {
		// frame
		frame = new JFrame();
		frame.setTitle("Sign-In");
		frame.setSize(550, 550);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0, 0));
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

		back = new JButton("Back");
		back.setBounds(1255, 5, 85, 40);
		back.setBackground(new Color(254, 242, 78));
		back.setFocusable(false);
		back.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 0)));
		north.add(back);
		back.addActionListener(this);

		// Body
		bground = new JLabel("");
		Image lbl2 = new ImageIcon(this.getClass().getResource("hotel1.jpeg")).getImage();
		bground.setIcon(new ImageIcon(lbl2));
		frame.add(bground, BorderLayout.CENTER);

		// customer button
		customer = new JButton("");
		customer.setIcon(new javax.swing.ImageIcon(getClass().getResource("customer.png")));
		customer.setBounds(300, 200, 200, 200);
		customer.addActionListener(this);
		bground.add(customer);

		cus = new JLabel("Customer");
		cus.setBounds(330, 370, 150, 100);
		cus.setForeground(Color.white);
		cus.setFont(new Font("Verdena", Font.BOLD, 30));
		bground.add(cus);

		// hotel member button
		hotelmember = new JButton("");
		hotelmember.setIcon(new javax.swing.ImageIcon(getClass().getResource("service.png")));
		hotelmember.setBounds(850, 200, 200, 200);
		hotelmember.addActionListener(this);
		bground.add(hotelmember);

		mem = new JLabel("Hotel Member");
		mem.setBounds(850, 370, 250, 100);
		mem.setForeground(Color.white);
		mem.setFont(new Font("Verdena", Font.BOLD, 30));
		bground.add(mem);

		// hotel moto
		south = new JPanel();
		south.setBackground(new Color(255, 255, 255));
		south.setPreferredSize(new Dimension(200, 90));
		frame.add(south, BorderLayout.SOUTH);

		moto = new JLabel("\"Come in as guests, and leave as a family.\" ");
		moto.setBounds(20, 5, 150, 50);
		moto.setForeground(Color.black);
		moto.setFont(new Font("Monotype Corsiva", Font.BOLD, 50));
		south.add(moto);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == customer) {
			frame.dispose();
			new SignInCustomer();
		} else if (ae.getSource() == hotelmember) {
			frame.dispose();
			new SignInHotelStaff();
		}
		else if (ae.getSource()==back) {
			frame.dispose();
			new DashboardOne();
		}
	}

	public static void main(String args[]) {
		new SignIn();
	}
}
