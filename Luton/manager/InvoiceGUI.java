package manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import mylibs.Global;

public class InvoiceGUI {
	JFrame frame;
	JPanel north, up, down, center;
	JLabel name, email, contact, address1, address2, invoice;

	public InvoiceGUI() {
		frame = new JFrame("Invoice");
		frame.setSize(750, 650);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));

		// ************center panel********
		center = new JPanel();
		center.setPreferredSize(new Dimension(100, 150));
		center.setLayout(new BorderLayout());
		frame.add(center, BorderLayout.CENTER);

		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		JMenu menu = new JMenu("Print");
		menubar.add(menu);

		JMenuItem print = new JMenuItem("Print");
		menu.add(print);
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				PrinterJob job = PrinterJob.getPrinterJob();
				job.setJobName("Print Data");

				job.setPrintable(new Printable() {
					public int print(Graphics pg, PageFormat pf, int pageNum) {
						pf.setOrientation(PageFormat.LANDSCAPE);
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						g2.scale(0.85, 0.70);

						center.print(g2);

						return Printable.PAGE_EXISTS;

					}
				});
				boolean ok = job.printDialog();
				if (ok) {
					try {

						job.print();
					} catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}

			}

		});

		// ************north panel********
		north = new JPanel();
		north.setPreferredSize(new Dimension(100, 150));
		north.setLayout(new BorderLayout());
		center.add(north, BorderLayout.NORTH);

		// *********up panel in north panel*********
		up = new JPanel();
		up.setLayout(null);
		north.add(up, BorderLayout.CENTER);

		SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentDate = simpledate.format(date);

		JLabel datelbl = new JLabel();
		datelbl.setText(currentDate);
		datelbl.setFont(new Font("Arial", Font.BOLD, 18));
		datelbl.setBounds(600, 40, 200, 20);
		up.add(datelbl);

		// *******title******
		name = new JLabel("Hotel Luton");
		name.setFont(new Font("Arial", Font.BOLD, 35));
		name.setBounds(5, 5, 200, 25);
		up.add(name);

		// *****email******
		email = new JLabel("E-mail : hotelluton@gmail.com");
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setBounds(5, 32, 200, 15);
		up.add(email);

		// ******contact*****
		contact = new JLabel("Contact : 9855036545");
		contact.setFont(new Font("Arial", Font.PLAIN, 15));
		contact.setBounds(5, 49, 200, 15);
		up.add(contact);

		// ****address*****
		address1 = new JLabel("Luton Town");
		address1.setFont(new Font("Arial", Font.PLAIN, 15));
		address1.setBounds(5, 66, 200, 15);
		up.add(address1);

		address2 = new JLabel("Bedfordshire, England");
		address2.setFont(new Font("Arial", Font.PLAIN, 15));
		address2.setBounds(5, 83, 200, 15);
		up.add(address2);

		// ********down panel in north panel********
		down = new JPanel();
		down.setPreferredSize(new Dimension(100, 50));
		down.setBackground(new Color(255, 195, 0));
		north.add(down, BorderLayout.SOUTH);

		invoice = new JLabel("Invoice", SwingConstants.CENTER);
		invoice.setFont(new Font("Verdana", Font.BOLD, 25));
		invoice.setBounds(580, 0, 230, 50);
		down.add(invoice);

		// ********center panel*********
		JPanel center1 = new JPanel();
		center1.setLayout(null);
		center.add(center1, BorderLayout.CENTER);

		JLabel invoiceno = new JLabel("Invoice No:");
		invoiceno.setFont(new Font("Verdana", Font.PLAIN, 18));
		invoiceno.setBounds(20, 20, 230, 20);
		center1.add(invoiceno);

		Random rand=new Random();
		int random=(int) (Math.random()*5900+1);
		
		JLabel invoicenolbl = new JLabel();
		invoicenolbl.setText(String.valueOf(random));
		invoicenolbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		invoicenolbl.setBounds(190, 20, 230, 20);
		center1.add(invoicenolbl);

		JLabel custname = new JLabel("Customer Name:");
		custname.setFont(new Font("Verdana", Font.PLAIN, 18));
		custname.setBounds(20, 60, 230, 20);
		center1.add(custname);

		JLabel custnamelbl = new JLabel();
		custnamelbl.setText(Global.currentBilling.getName());
		custnamelbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		custnamelbl.setBounds(190, 60, 230, 20);
		center1.add(custnamelbl);

		JSeparator sep1 = new JSeparator();
		sep1.setFont(new Font("Verdana", Font.PLAIN, 18));
		sep1.setBounds(10, 100, 710, 20);
		center1.add(sep1);

		JLabel snlbl = new JLabel("S.No");
		snlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		snlbl.setBounds(20, 110, 230, 20);
		center1.add(snlbl);

		JLabel description = new JLabel("Description");
		description.setFont(new Font("Verdana", Font.PLAIN, 18));
		description.setBounds(240, 110, 230, 20);
		center1.add(description);

		JLabel amountlbl = new JLabel("Amount");
		amountlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		amountlbl.setBounds(600, 110, 230, 20);
		center1.add(amountlbl);

		// ***************Separator******************
		JSeparator sep2 = new JSeparator();
		sep2.setFont(new Font("Verdana", Font.PLAIN, 18));
		sep2.setBounds(10, 150, 710, 20);
		center1.add(sep2);

		JLabel onelbl = new JLabel("1.");
		onelbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		onelbl.setBounds(30, 170, 230, 20);
		center1.add(onelbl);

		JLabel roomlbl = new JLabel("Room Price");
		roomlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		roomlbl.setBounds(240, 170, 230, 20);
		center1.add(roomlbl);

		JLabel roomamount = new JLabel("1200");
		roomamount.setText(Integer.toString(Global.currentBilling.getRoom_Price()));
		roomamount.setFont(new Font("Verdana", Font.PLAIN, 18));
		roomamount.setBounds(600, 170, 230, 20);
		center1.add(roomamount);

		JLabel twolbl = new JLabel("2.");
		twolbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		twolbl.setBounds(30, 200, 230, 20);
		center1.add(twolbl);

		JLabel drinkslbl = new JLabel("Drinks Price");
		drinkslbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		drinkslbl.setBounds(240, 200, 230, 20);
		center1.add(drinkslbl);

		JLabel drinksamount = new JLabel();
		drinksamount.setText(Integer.toString(Global.currentBilling.getBar_Price()));
		drinksamount.setFont(new Font("Verdana", Font.PLAIN, 18));
		drinksamount.setBounds(600, 200, 230, 20);
		center1.add(drinksamount);

		JLabel threelbl = new JLabel("3.");
		threelbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		threelbl.setBounds(30, 230, 230, 20);
		center1.add(threelbl);

		JLabel foodlbl = new JLabel("Food Price");
		foodlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		foodlbl.setBounds(240, 230, 230, 20);
		center1.add(foodlbl);

		JLabel foodamount = new JLabel();
		foodamount.setText(Integer.toString(Global.currentBilling.getFood_Price()));
		foodamount.setFont(new Font("Verdana", Font.PLAIN, 18));
		foodamount.setBounds(600, 230, 230, 20);
		center1.add(foodamount);

		JLabel fourlbl = new JLabel("4.");
		fourlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		fourlbl.setBounds(30, 260, 230, 20);
		center1.add(fourlbl);

		JLabel servicelbl = new JLabel("Service Price");
		servicelbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		servicelbl.setBounds(240, 260, 230, 20);
		center1.add(servicelbl);

		JLabel serviceamount = new JLabel();
		serviceamount.setText(Integer.toString(Global.currentBilling.getService_Price()));
		serviceamount.setFont(new Font("Verdana", Font.PLAIN, 18));
		serviceamount.setBounds(600, 260, 230, 20);
		center1.add(serviceamount);

		// ***************Separator******************
		JSeparator sep3 = new JSeparator();
		sep3.setFont(new Font("Verdana", Font.PLAIN, 18));
		sep3.setBounds(10, 290, 710, 20);
		center1.add(sep3);
		
		JLabel totalbill = new JLabel("Total Bill:");
		totalbill.setFont(new Font("Verdana", Font.PLAIN, 18));
		totalbill.setBounds(480, 300, 230, 20);
		center1.add(totalbill);
		
		JLabel totalbilllbl = new JLabel();
		totalbilllbl.setText(Double.toString(Global.currentBilling.getTotal_Bill()));
		totalbilllbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		totalbilllbl.setBounds(600, 300, 230, 20);
		center1.add(totalbilllbl);
		
		

		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new InvoiceGUI();
	}

}
