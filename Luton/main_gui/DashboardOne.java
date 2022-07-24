package main_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import customer.RegisterNC;

public class DashboardOne {
	JFrame frame;
	JPanel north, south;
	JLabel heading, logo, bg_img, moto;
	JButton register, sign_in;

	public DashboardOne() {
		frame = new JFrame();
		frame.setSize(550, 550);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout(0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		//****heading panel*******
		north = new JPanel();
		north.setBackground(new Color(255, 193, 0));
		north.setPreferredSize(new Dimension(100, 50));
		north.setLayout(null);
		frame.add(north, BorderLayout.NORTH);

		heading = new JLabel("Hotel Luton", SwingConstants.CENTER);//name the heading
		heading.setFont(new Font("Verdana", Font.BOLD, 25));
		heading.setBounds(580, 0, 230, 50);
		north.add(heading);

		logo = new JLabel("");//added the logo
		Image lbl = new ImageIcon(this.getClass().getResource("logo2.jpg")).getImage();
		logo.setIcon(new ImageIcon(lbl));
		logo.setBounds(10, 2, 60, 45);
		north.add(logo);
		logo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				
				if (ae.getSource()==logo) {
					new AboutUs();
				}
			}
			
			
		});

		register = new JButton("Register");//register button to open register page
		register.setBounds(1160, 5, 90, 40);
		register.setBackground(new Color(254, 242, 78));
		register.setFocusable(false);
		register.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 0)));
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == register) {
					frame.dispose();
					new RegisterNC();
				}
			}
		});
		north.add(register);

		sign_in = new JButton("Sign-In");//sign in button to open sign in page
		sign_in.setBounds(1255, 5, 85, 40);
		sign_in.setBackground(new Color(254, 242, 78));
		sign_in.setFocusable(false);
		sign_in.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 0)));
		sign_in.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource()==sign_in) {
					frame.dispose();
					new SignIn();
				}
			}
		});

		north.add(sign_in);

		bg_img = new JLabel("");//background image
		Image lbl2 = new ImageIcon(this.getClass().getResource("hotel1.jpeg")).getImage();
		bg_img.setIcon(new ImageIcon(lbl2));
		frame.add(bg_img, BorderLayout.CENTER);

		south = new JPanel();
		south.setBackground(Color.WHITE);
		south.setPreferredSize(new Dimension(200, 90));
		frame.add(south, BorderLayout.SOUTH);

		moto = new JLabel("\"Come in as guests, and leave as a family.\" ");
		moto.setBounds(20, 5, 150, 50);
		moto.setForeground(Color.black);
		moto.setFont(new Font("Monotype Corsiva", Font.BOLD, 50));
		south.add(moto);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new DashboardOne();
	}

}
