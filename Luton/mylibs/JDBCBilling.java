package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JDBCBilling extends Database2{
	
	SimpleDateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
	Date date=new Date();
	String currentDate=dateformate.format(date);
	
	public ArrayList billingview() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BillingLibs>Billing=new ArrayList();
		String sql="select b.booking_id, b.arrival_date, b.departure_date, c.fullname,"
				+ "c.reg_type,sum(nullif(d.bar_price,0)) as bar_price, "
				+ "sum(nullif(f.restaurant_price,0)) as restaurant_price,"
				+ "sum(nullif(s.service_price,0)) as service_price, r.room_no, r.room_price"
				+ " from booking b left join customer c on b.customer_id = c.customer_id"
				+ " left join drinks d  on b.booking_id=d.booking_id left join food f on "
				+ "f.booking_id = b.booking_id join services s on s.booking_id = b.booking_id"
				+ " join room r on b.room_no = r.room_no where b.booking_status='Active'"
				+ "group by b.booking_id, b.arrival_date, b.departure_date,c.fullname,"
				+ "c.reg_type,r.room_no, r.room_price; ";
		
		try {
			conn=connect();
			
			pstat=conn.prepareStatement(sql);
		
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BillingLibs billing=new BillingLibs(rs.getInt("booking_id"),
						rs.getString("arrival_date"),
						rs.getString("departure_date"),
						rs.getString("fullname"),
						rs.getString("reg_type"),
						rs.getInt("bar_price"),
						rs.getInt("restaurant_price"),
						rs.getInt("service_price"),
						rs.getInt("room_no"),
						rs.getInt("room_price"));
				
				Billing.add(billing);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return Billing;
		
	}

	public boolean insert (BillingLibs2 billing) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result5=false;
		String sql="INSERT INTO bill VALUES (?,?,?,?,?,?,?,?,?);";
		try {
			conn=connect();
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, billing.getBilling_ID());
			pstat.setString(2, billing.getName());
			pstat.setInt(3, billing.getRoom_Price());
			pstat.setInt(4, billing.getFood_Price());
			pstat.setDouble(5, billing.getBar_Price());
			pstat.setDouble(6, billing.getService_Price());
			pstat.setDouble(7, billing.getTotal_Bill());
			pstat.setDouble(8, billing.getDiscount());
			pstat.setInt(9,billing.getBooking_id());
			pstat.executeUpdate();
			conn.close();
			pstat.close();
			result5=true;
			
			
		}
		
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result5;
	}
	



}
