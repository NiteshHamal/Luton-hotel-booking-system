package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookingJDBC extends Database2 {
	
	public ArrayList activecustomer() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT booking.booking_id, customer.fullname from booking"
				+ " join customer where booking.customer_id = customer.customer_id "
				+ "and booking_status = 'Active';";
		ArrayList<ActiveCustomerlibs>cus = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			while (rs.next()) {
				ActiveCustomerlibs reg = new ActiveCustomerlibs(rs.getInt("booking_id"),
						rs.getString("fullname"));
				cus.add(reg);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return cus;
	}
	
	public boolean checkinupdate(Booking book) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "UPDATE booking SET booking_status=? WHERE booking_id=?";

		try {
			conn= connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, book.getBooking_status());
			pstat.setInt(2, book.getBooking_id());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return result;
	}
	
public ArrayList CheckIn() {
		
		SimpleDateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String currentDate=dateformate.format(date);
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BookingCustomer> check=new ArrayList();
		String sql="SELECT customer_id, fullname ,booking_id, arrival_date, departure_date,room_no,booking_type,booking_status  FROM booking INNER JOIN customer USING (customer_id) WHERE arrival_date='"+currentDate+"' AND booking_status = 'Booked' ORDER BY booking_id;";
		try {
			conn = connect();
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				BookingCustomer booking=new BookingCustomer(rs.getInt("customer_id"),
						rs.getString("fullname"),
						rs.getInt("booking_id"),						
						rs.getString("arrival_date"),
						rs.getString("departure_date"),
						rs.getInt("room_no"),
						rs.getString("booking_type"),
						rs.getString("booking_status")
						);
				check.add(booking);
			}
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return check;
	}

	public boolean delete(int Id) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "DELETE FROM booking WHERE booking_id = ?";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Id);
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return result;
	}

	public boolean insert(Booking boo) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO `booking`(`booking_id`, `arrival_date`," + " `departure_date`, `customer_id`,"
				+ "`booking_type`, `booking_status`) VALUES(?,?,?,?,?,?)";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, boo.getBooking_id());
			pstat.setString(2, boo.getArrival_date());
			pstat.setString(3, boo.getDeparture_date());
			pstat.setInt(4, boo.getCustomer_id());
			pstat.setString(5, boo.getBooking_type());
			pstat.setString(6, boo.getBooking_status());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return result;
	}

	public ArrayList select_all() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM  booking WHERE customer_id=? AND booking_status = ?";
		ArrayList<Booking> search = new ArrayList<Booking>();
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Global.obj1.getId());
			pstat.setString(2, "Requested");
			rs = pstat.executeQuery();
			while (rs.next()) {
				Booking boo = new Booking(rs.getInt("booking_id"),
						rs.getString("arrival_date"),
						rs.getString("departure_date"),
						rs.getInt("customer_id"),
						rs.getInt("room_no"),
						rs.getString("booking_type"),
						rs.getString("booking_status"));
				search.add(boo);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return search;
	}
	
	public ArrayList bookinghistory() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM  booking WHERE customer_id=?";
		ArrayList<Booking> search = new ArrayList<Booking>();
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Global.obj1.getId());
			rs = pstat.executeQuery();
			while (rs.next()) {
				Booking boo = new Booking(rs.getInt("booking_id"),
						rs.getString("arrival_date"),
						rs.getString("departure_date"),
						rs.getInt("customer_id"),
						rs.getInt("room_no"),
						rs.getString("booking_type"),
						rs.getString("booking_status"));
				search.add(boo);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return search;
	}

	public ArrayList select() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "select customer.customer_id, customer.fullname, booking.booking_id, booking.arrival_date, booking.departure_date, booking.booking_type, booking.booking_status, booking.room_no from booking left join customer on booking.customer_id = customer.customer_id WHERE booking_status = 'Requested'";
		ArrayList<BookingCustomer> search = new ArrayList<BookingCustomer>();
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			while (rs.next()) {
				BookingCustomer boo2 = new BookingCustomer
						(rs.getInt("customer_id"),
						rs.getString("fullname"),
						rs.getInt("booking_id"),
						rs.getString("arrival_date"),
						rs.getString("departure_date"),
						rs.getInt("room_no"),
						rs.getString("booking_type"), 
						rs.getString("booking_status"));
				search.add(boo2);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return search;
	}
	
	public boolean receptionbookingupdate(Booking booking) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "UPDATE booking SET room_no=?, booking_status=? WHERE booking_id=?";

		try {
			conn= connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, booking.getRoom_no());
			pstat.setString(2, booking.getBooking_status());
			pstat.setInt(3, booking.getBooking_id());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return result;
	}
}
