package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCService extends Database2 {
	
	public boolean insert (ServiceLibs service) {
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO services VALUES(?,?,?,?);";
		
		try {
			conn = connect();
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, service.getService_ID());
			pstat.setString(2, service.getService_Type());
			pstat.setLong(3, service.getService_Price());
			pstat.setInt(4, service.getBooking_ID());
			
			pstat.executeUpdate();
			
			result=true;
			conn.close();
			pstat.close();
			
			
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result;
		
		
		
	}
	
	public ArrayList select_all() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<ServiceLibs>select=new ArrayList();
		String sql="SELECT * FROM services;";
		
		
		try {
			conn = connect();
			pstat=conn.prepareStatement(sql);
		
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				ServiceLibs service22=new ServiceLibs
						(rs.getInt("service_id"),
						rs.getString("service_type"),
						rs.getLong("service_price"),
						rs.getInt("booking_id")
						
						);
				
				select.add(service22);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return select;
		
	}
	
	public boolean update (ServiceLibs service) {
		Connection conn;
		PreparedStatement pstat;
		boolean result1=false;
		String sql="UPDATE services SET service_type=?,service_price=?, booking_id=? WHERE service_id=?;";
		
		try {
            conn = connect();			
			pstat=conn.prepareStatement(sql);
			
			
			pstat.setString(1, service.getService_Type());
			pstat.setLong(2, service.getService_Price());
			pstat.setInt(3, service.getBooking_ID());
			pstat.setInt(4, service.getService_ID());
			
			pstat.executeUpdate();
			
			result1=true;
			conn.close();
			pstat.close();
			
			
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result1;
		
		
		
	}
	
	public boolean delete(int ID) {
		Connection conn;
		PreparedStatement pstat;
		boolean result2 = false;
		String sql = "DELETE FROM services WHERE service_id=?";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, ID);

			pstat.executeUpdate();
			conn.close();
			pstat.close();
			result2 = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result2;
	}

}
