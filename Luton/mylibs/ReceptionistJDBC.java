package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReceptionistJDBC extends Database2{
	
	public Receptionist login(Receptionist rec) {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM receptionist WHERE username = ? AND password = ?";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rec.getUsername());
			pstat.setString(2, rec.getPassword());
			rs = pstat.executeQuery();
			while (rs.next()) {
				rec.setStaff_no(rs.getInt("staff_no"));
				rec.setRole(rs.getString("role"));
			}
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return rec;
	}
	

}
