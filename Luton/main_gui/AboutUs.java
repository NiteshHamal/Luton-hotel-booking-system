package main_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutUs {
	JFrame frame;
	JPanel body, side, btm;
	JLabel Img, lblAbout, lblAddress, copyright, lbl, lbl1, chill, pill, pop;
	JLabel Img1, Img2, Img3, Img4, Img5, Img6;
	
	public AboutUs() {
		frame = new JFrame();
		frame.setSize(1400, 750);
		frame.setExtendedState(frame.MAXIMIZED_BOTH); // full window
		frame.setTitle("Hotel Luton");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // set default close operation
		frame.setLayout(null); // set layout of the frame
		
		body = new JPanel(); // Initialize and memory allocation
		body.setBounds(0, 0, 900, 500);
		body.setLayout(null);
		frame.add(body);
		

		chill = new JLabel("<html> <p> Welcome to HotelLuton </p> </html>");
		chill.setFont(new Font("", Font.BOLD, 50));
		chill.setForeground(Color.white);
		chill.setBounds(250, 130, 500, 140);
		body.add(chill);
		
		pill = new JLabel("<html> <p> Amazing services," 
				+ " Location & Facilities </p> </html>");
		pill.setFont(new Font("", Font.PLAIN, 16));
		pill.setForeground(Color.white);
		pill.setBounds(250, 210, 500, 140);
		body.add(pill);

		Img = new JLabel("");
		Image lbl = new ImageIcon(this.getClass().getResource("hello.jpg")).getImage();
		Img.setIcon(new ImageIcon(lbl));
		Img.setBounds(0, 0, 900, 500);
		body.add(Img, BorderLayout.CENTER);
		body.add(Img);

		side = new JPanel(); // Initialize and memory allocation
		side.setBounds(900, 0, 500, 500);
		side.setBackground(new Color(255, 255, 0));
		side.setLayout(null);
		frame.add(side);
		
		lblAbout = new JLabel("<html> <p style=\"color:beige;font-size:30px;\"> <b><CENTER>ABOUT US</CENTER></b>  <body> &nbsp <p> Hotel Luton is just "
				+ "800m away from the London Luton Airport and 10 minutes drive to Luton town centre."
				+ " A budget friendly hotel that provides modern rooms which is open 24 hours a day."
				+ "</P> &nbsp <P> The Sophisticated rooms offer free WI-FI, flat-screen Tvs, minibars, light Snacks, tea and coffee making facilities. Our employees are happy to serve our\r\n"
				+ " guest at any time of day or night. Room service is availaible 24-7. We have various dishes available in our menu and the food served\r\n"
				+ " are hygienic and timely. The hotel also offers an outdoor swimming pool and bar. A balcony or terrace are featured in certain rooms where guests can enjoy the impressive views of the runway."
				+ " </p> &nbsp <p>"
				+ "Popular places of interest near Hotel Luton are Someries Castle, Luton Central Library, St Mary's Church, Hatfield House,"
				+ " Knebworth House, Woburn Abbey. </body> </html>");
		lblAbout.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAbout.setVerticalAlignment(JLabel.TOP);
		lblAbout.setBounds(12, 10, 420, 500);
		side.add(lblAbout);

		btm = new JPanel(); // Initialize and memory allocation
		btm.setBounds(0, 500, 1400, 210);
		btm.setBackground(new Color(70, 58, 47));
		btm.setLayout(null);
		frame.add(btm);
		
		lblAddress = new JLabel("<html><body><p style=\"color:white;\"> Address: Spittlesea Road, Luton, LU2 9NZ </p>"
				+ "<p style=\"color:white;\"> Tel: +44 1234 400400, Fax:+44 (0)1582 743699 </p>"
				+ "<p style=\"color:white;\"> Country: United Kingdom</P>"
				+ " <p style=\"color:white;\"> Email: reservation@hoteluton.com.np </p></body></html>");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setVerticalAlignment(JLabel.TOP);
		lblAddress.setBounds(970, 10, 1000, 150);
		btm.add(lblAddress);
		
		Img1 = new JLabel("");
		Image lbl1 = new ImageIcon(this.getClass().getResource("fb.JPG")).getImage();
		Img1.setIcon(new ImageIcon(lbl1));
		Img1.setBounds(1020, 110, 30, 30);
		btm.add(Img1, BorderLayout.CENTER);
		btm.add(Img1);
		
		Img2 = new JLabel("");
		Image lbl2 = new ImageIcon(this.getClass().getResource("insta.png")).getImage();
		Img2.setIcon(new ImageIcon(lbl2));
		Img2.setBounds(1070, 110, 30, 30);
		btm.add(Img2, BorderLayout.CENTER);
		btm.add(Img2);
		
		Img3 = new JLabel("");
		Image lbl3 = new ImageIcon(this.getClass().getResource("whatsapp.png")).getImage();
		Img3.setIcon(new ImageIcon(lbl3));
		Img3.setBounds(1105, 100, 60, 50);
		btm.add(Img3, BorderLayout.CENTER);
		btm.add(Img3);
		
		Img4 = new JLabel("");
		Image lbl4 = new ImageIcon(this.getClass().getResource("google.png")).getImage();
		Img4.setIcon(new ImageIcon(lbl4));
		Img4.setBounds(1165, 100, 60, 50);
		btm.add(Img4, BorderLayout.CENTER);
		btm.add(Img4);
		
		copyright = new JLabel("<html><body><p style=\"color:white;\"> COPYRIGHT 2022 HOTEL LUTON. ALL RIGHTS RESERVED DEVELOPED BY B9</p></body></html>");
		copyright.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		copyright.setVerticalAlignment(JLabel.TOP);
		copyright.setBounds(280, 170, 1000, 150);
		btm.add(copyright);
		
		pop = new JLabel("<html><body><p style=\"color:#D0D0D0;font-size: 18px\"> Property amenities"
				+ "<ul style=\"color:#D0D0D0;\"> <li> Free Wifi Internet Access </li>"
				+ " <li>Airport Pickup & Parking </li> "
				+ "<li> 24 Hr Hot & Cold Water</li>"
				+ "<li> Pet friendly facilities</li>"
				+ "<li> Flexible check-in and check-out </li>"
				+ "<li> Communal spaces for meetings and social gatherings </li><ul></p>  </body> </html>");
		pop.setFont(new Font("", Font.PLAIN, 16));
		pop.setVerticalAlignment(JLabel.TOP);
		pop.setBounds(5, 0, 1400, 150);
		btm.add(pop);
		
		

		frame.setVisible(true);

		
		
	}
	
	
	
	
	// main class
	public static void main (String[] args) {
		new AboutUs();	
	}
}
