package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RegistrationJDBC extends Database2 {

	public boolean update(Registration bio) {
		Connection conn;
		PreparedStatement pstat;
		boolean result5 = false;
		String sql = "UPDATE customer SET fullname=?, address=?, phone_no=?, email=?, "
				+ "creditcardno=?, username=?, password=?, reg_type=? WHERE customer_id=?;";
		try {

			conn = connect();

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, bio.getFullName());
			pstat.setString(2, bio.getAddress());
			pstat.setLong(3, bio.getPhoneNo());
			pstat.setString(4, bio.getEmail());
			pstat.setLong(5, bio.getCreditCardNo());
			pstat.setString(6, bio.getUsername());
			pstat.setString(7, bio.getPassword());
			pstat.setString(8, bio.getRegType());
			pstat.setInt(9, bio.getId());
			pstat.executeUpdate();

			pstat.close();
			conn.close();
			result5 = true;

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result5;

	}

	public Registration login(Registration reg) {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM customer WHERE username = ? AND password = ?";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, reg.getUsername());
			pstat.setString(2, reg.getPassword());
			rs = pstat.executeQuery();
			while (rs.next()) {
				reg.setId(rs.getInt("customer_id"));
				reg.setFullName(rs.getString("fullname"));
				reg.setRegType(rs.getString("reg_type"));
			}
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return reg;
	}

	public ArrayList select_all() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM customer";
		ArrayList<Registration>search5 = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			while (rs.next()) {
				Registration reg = new Registration(rs.getInt("customer_id"), rs.getString("fullname"),
						rs.getString("address"), rs.getLong("phone_no"), rs.getString("email"),
						rs.getLong("creditcardno"), rs.getString("username"), rs.getString("password"),
						rs.getString("reg_type"));
				search5.add(reg);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return search5;
	}

	public Registration search(String fullname) {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM customer WHERE fullname = ?";
		Registration reg = new Registration();
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, fullname);
			rs = pstat.executeQuery();
			while (rs.next()) {
				reg.setId(rs.getInt("customer_id"));
				reg.setFullName(rs.getString("fullname"));
				reg.setAddress(rs.getString("address"));
				reg.setPhoneNo(rs.getLong("phone_no"));
				reg.setEmail(rs.getString("email"));
				reg.setCreditCardNo(rs.getLong("creditcardno"));
				reg.setRegType(rs.getString("reg_type"));
				reg.setUsername(rs.getString("username"));
				reg.setPassword(rs.getString("password"));
			}
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());

		}
		return reg;
	}

	public boolean insert(Registration reg) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, reg.getId());
			pstat.setString(2, reg.getFullName());
			pstat.setString(3, reg.getAddress());
			pstat.setLong(4, reg.getPhoneNo());
			pstat.setString(5, reg.getEmail());
			pstat.setLong(6, reg.getCreditCardNo());
			pstat.setString(7, reg.getUsername());
			pstat.setString(8, reg.getPassword());
			pstat.setString(9, reg.getRegType());
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
