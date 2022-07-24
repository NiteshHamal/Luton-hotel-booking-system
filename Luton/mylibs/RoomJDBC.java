package mylibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class RoomJDBC extends Database2 {
	
	public boolean update2(Room mroom) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "UPDATE room SET room_type =?, room_status=?, room_price=? WHERE room_no=?";
		// connect with database server
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, mroom.getRoom_type());
			pstat.setString(2, mroom.getRoom_status());
			pstat.setDouble(3, mroom.getRoom_price());
			pstat.setInt(4, mroom.getRoom_no());
			// 2.2 Execute SQL Statement
			pstat.executeUpdate();
			// 3. Close Connection
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.print("Error:" + ex.getMessage());
		}
		return result;
	}
	
	public Room search(int Room_no) {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM room WHERE  room_no = ?";
	    Room mroom = new Room();
		// connect with database server
		try {
			conn = connect();
			// 2.1 Create JDBC Statement
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Room_no);
			rs = pstat.executeQuery();
			while (rs.next()) {
				mroom.setRoom_no(rs.getInt("room_no"));
				mroom.setRoom_type(rs.getString("room_type"));
				mroom.setRoom_status(rs.getString("room_status"));
				mroom.setRoom_price(rs.getInt("room_price"));
				
			}
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());

		}
		return mroom;
}
	
	public boolean update(Room roo) {
		Connection conn;
		PreparedStatement pstat;
		String sql = "UPDATE room SET room_status= ? WHERE room_no=?";
		boolean result1 = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			 pstat = conn.prepareStatement(sql);
			 
			 pstat.setString(1,roo.getRoom_status());
			 pstat.setInt(2,roo.getRoom_no());
			 pstat.executeUpdate();
			 pstat.close();
			 conn.close();
			 result1 = true;
		}catch(Exception ex) {
			System.out.println("Error :"+ex.getMessage());
		}
		return result1;
	}

	
	public ArrayList select_all() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM room";
		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			while (rs.next()) {
				Room reg = new Room(rs.getInt("room_no"), rs.getString("room_type"),
						rs.getString("room_status"), rs.getInt("room_price"));
				search.add(reg);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return search;
	}
	
	public ArrayList availableroom() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT room_no,room_type,room_price FROM room WHERE room_status = 'Available';";
		ArrayList<AvailableRoomLibs>room = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				AvailableRoomLibs reg = new AvailableRoomLibs(rs.getInt("room_no"),
						rs.getString("room_type"),
						rs.getString("room_price"));
						
				room.add(reg);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return room;
	}
	
}
