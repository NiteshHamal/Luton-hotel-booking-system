package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BarJDBC extends Database2 {

	public boolean insert(BarLibs bar) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO drinks VALUES(?,?,?,?,?,?)";

		try {
			conn=connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, bar.getBar_id());
			pstat.setString(2, bar.getBar_item());
			pstat.setInt(3, bar.getRate());
			pstat.setInt(4, bar.getQuantity());
			pstat.setInt(5, bar.getTotal_price());
			pstat.setInt(6, bar.getBooking_id());
			
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
		ArrayList<BarLibs>select=new ArrayList();
		String sql="SELECT * FROM drinks;";
		try {
			conn = connect();
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				BarLibs bar=new BarLibs
						(rs.getInt("bar_id"),
						rs.getString("bar_item"),
						rs.getInt("bar_rate"),
						rs.getInt("bar_quantity"),
						rs.getInt("bar_price"),
						rs.getInt("booking_id")
						);
				select.add(bar);
			}
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return select;
		
	}

}
