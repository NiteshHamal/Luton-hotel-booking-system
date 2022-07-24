package manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class Hotel_Booking implements ActionListener, MouseListener, ItemListener{
	JFrame frame;
	JLabel heading, image, label1, lblcaption, lblBooking_date, lblArrival_date, lblDeparture_date,lblRoom_Type, lblRoom_no;
	JTextField txtBooking_date, txtArrival_date, txtDeparture_date, txtRoom_no, txt_search;
	JPanel panel0, north, center;
	JScrollPane scrollPane;
	JButton search, clear, update, delete, add, back ;
	JTable table;
	DefaultTableModel dtm;
	JComboBox Roomtype;
	
	public Hotel_Booking() {
		//Initializing and memory allocation
		//frame
		// frame
				frame = new JFrame();
				frame.setTitle("Booking");
				frame.setSize(1366, 768);
				frame.setResizable(false);
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
				heading = new JLabel("Customers Booking Details");
				heading.setBounds(150, 10, 200, 20);

				// caption = new JLabel("address or phone_no or Email");
				lblcaption = new JLabel("Enter Customer ID :");
				lblcaption.setBounds(20, 50, 200, 20);
				
				// search field
				txt_search = new JTextField();
				txt_search.setBounds(20, 80, 200, 30);
				txt_search.setFocusable(true);
				txt_search.setOpaque(false);
				txt_search.setFont(new Font("Verdana", 1, 14));
				// for new Panel

				// All Labels

				lblBooking_date = new JLabel("Booking_date");
				lblBooking_date.setBounds(10, 140, 100, 30);

				lblArrival_date = new JLabel("Arrival_date");
				lblArrival_date.setBounds(10, 180, 100, 30);

				lblDeparture_date = new JLabel("Departure_date");
				lblDeparture_date.setBounds(10, 220, 100, 30);

				lblRoom_no = new JLabel("Room No");
				lblRoom_no.setBounds(10, 260, 100, 30);

				lblRoom_Type = new JLabel("Room_Type");
				lblRoom_Type.setBounds(10, 300, 100, 30);

				// ALL Text Fields
				txtBooking_date = new JTextField();
				txtBooking_date.setBounds(110, 140, 280, 30);
				txtBooking_date.setFont(new Font("Verdana", 1, 14));

				txtArrival_date = new JTextField();
				txtArrival_date.setBounds(110, 180, 280, 30);
				txtArrival_date.setFont(new Font("Verdana", 1, 14));

				txtDeparture_date = new JTextField();
				txtDeparture_date.setBounds(110, 220, 280, 30);
				txtDeparture_date.setFont(new Font("Verdana", 1, 14));

				txtRoom_no = new JTextField();
				txtRoom_no.setBounds(110, 260, 280, 30);
				txtRoom_no.setFont(new Font("Verdana", 1, 14));
				/*
				 * Roomtype = new JComboBox(); for (int i = 0; i < Global1.Roomtype.length; i++)
				 * { Roomtype.addItem(Global1.Roomtype[i]); }
				 */
				/*
				 * Roomtype.setBounds(110, 310, 280, 30); Roomtype.setFont(new Font("Verdana",
				 * 1, 14)); Roomtype.addItemListener(this);
				 */


				// search button
				search = new JButton("search");
				search.setBounds(240, 80, 150, 30);
				search.addActionListener(this);

				// clear button
				clear = new JButton("Clear");
				clear.setBounds(50, 500, 150, 30);
				clear.addActionListener(this);

				// add button
				add = new JButton("Add");
				add.setBounds(220, 500, 150, 30);
				add.addActionListener(this);

				// update button
				update = new JButton("Update");
				update.setBounds(50, 540, 150, 30);

				// delete button
				delete = new JButton("Delete");
				delete.setBounds(220, 540, 150, 30);
				delete.addActionListener(this);
				
				//back button
				back = new JButton("Back");
				back.setBounds(130,580,150,30);
				back.addActionListener(this);

				// add to panel
				panel0.setLayout(null);
				panel0.add(txt_search);
				panel0.add(search);
				panel0.add(clear);
				panel0.add(add);
				panel0.add(update);
				panel0.add(delete);
				panel0.add(back);
				panel0.add(heading);
				panel0.add(lblcaption);
				// label
				panel0.add(lblBooking_date);
				panel0.add(lblArrival_date);
				panel0.add(lblDeparture_date);
				panel0.add(lblRoom_no);
				panel0.add(lblRoom_Type);
		
				// text fields
				panel0.add(txtBooking_date);
				panel0.add(txtArrival_date);
				panel0.add(txtDeparture_date);
				panel0.add(txtRoom_no);
				//panel0.add(Roomtype);
				
				// panel 0 end
				
				// table
				dtm = new DefaultTableModel();
				table = new JTable(dtm);
				// table.setBackground(Color.CYAN);
				table.setPreferredScrollableViewportSize(new Dimension(1050, 300));
				table.setFillsViewportHeight(true);
				table.addMouseListener(this);
				
				JTableHeader h1=table.getTableHeader();
				h1.setBackground(Color.black);
				h1.setForeground(Color.white);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(450, 0, 1050, 700);
				// columns
				dtm.addColumn("Booking_date");
				dtm.addColumn("Arrival_date");
				dtm.addColumn("Departure_date");
				dtm.addColumn("Room No");
				dtm.addColumn("Room_Type");

				/*RegistrationJDBC jdbc = new RegistrationJDBC();
				ArrayList search = jdbc.select_all();
				if (search.size() > 0) {
					for (int i = 0; i < search.size(); i++) {
						Registration reg = (Registration) search.get(i);
						Object[] tmp = { reg.getId(), reg.getFullName(), reg.getAddress(), reg.getEmail(), reg.getPhoneNo(),
								reg.getCreditCardNo(),reg.getUsername(),reg.getPassword(), reg.getRegType() };
						dtm.addRow(tmp);
					}
				}
				*/
				
				// frame add to

				center.add(panel0);
				center.add(scrollPane);
				frame.setVisible(true);
			}

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == clear) {

					txtBooking_date.setText("");
					txt_search.setText("");
					txtArrival_date.setText("");
					txtDeparture_date.setText("");
					txtRoom_no.setText("");
					Roomtype.setSelectedIndex(0);
					}
				} 
				/*else if (ae.getSource() == add) {
					booking bk = new booking();
					bk.setBooking_date(txtBooking_date.getText());
					bk.setArrival_date(txtArrival_date.getText());
					bk.setDeparture_date(txtDeparture_date.getText());
					bk.setRoom_no(txtRoom_no.getText());
					bk.setRoom_type(txtRoom_Type.getText());
				}
				

					booking bk1 = new booking();
					boolean result = jdbc.insert(reg);
					if (result == true) {
						JOptionPane.showMessageDialog(null, "Successful to Add Room Details");
					} else {
						JOptionPane.showMessageDialog(null, "Unsuccessful to Add Room Details");
					}
				} else if (ae.getSource() == search) {
					Registration reg = new Registration();
					int id = Integer.parseInt(txt_search.getText());
					RegistrationJDBC jdbc = new RegistrationJDBC();
					reg = jdbc.search(id);
					if (reg.getId() > 0) {
						int customer_id = reg.getId();
						txt_id.setText(Integer.toString(customer_id));
						String Booking_date = reg.Arrival_date();
						txtBooking_date.setText(Booking_date);
						String Arrival_date = reg.getBooking_date();
						txtArrival_date.setText(Arrival_date);
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
				}
				else if (ae.getSource()== back) {
					frame.dispose();
					//new Customer();
				}
				else if (ae.getSource()==delete) {
					int customer_id= Integer.parseInt(txt_id.getText());
					RegistrationJDBC jdbc = new RegistrationJDBC();
					boolean result = jdbc.delete(customer_id);
					if (result == true) {
						JOptionPane.showMessageDialog(null,"Deleted Successfully");
					}
					else {
						JOptionPane.showMessageDialog(null,"Unsuccessful to Delete");
					}
				}

			}*/
			
			@Override
			public void mouseClicked(MouseEvent ei) {
				int h2 = table.getSelectedRow();
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
				
			}
				/*TableModel model=table.getModel();
				String id = model.getValueAt(h2,0).toString();
				txt_id.setText(id);
				String name = model.getValueAt(h2,1).toString();
				txt_name.setText(name);
				String address = model.getValueAt(h2, 2).toString();
				txt_address.setText(address);
				String email = model.getValueAt(h2,3).toString();
				txt_email.setText(email);
				String phone = model.getValueAt(h2,4).toString();
				txt_phone.setText(phone);
				String credit = model.getValueAt(h2,5).toString();
				txt_credit.setText(credit);
				String username = model.getValueAt(h2,6).toString();
				txt_username.setText(username);
				String password = model.getValueAt(h2,7).toString();
				txt_password.setText(password);
				String reg_type = model.getValueAt(h2,8).toString();
			    cmb_reg_type.setSelectedItem(reg_type);
			
			*/
	public static void main(String[] args) {
		new Hotel_Booking();
	 

	}

}
