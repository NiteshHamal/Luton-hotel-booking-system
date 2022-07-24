package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RestaurantJDBC extends Database2 {

	public boolean insert(RestaurantLibs restaurant) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO food VALUES(?,?,?,?,?,?)";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, restaurant.getRestaurant_ID());
			pstat.setString(2, restaurant.getRestaurant_Item());
			pstat.setInt(3, restaurant.getRate());
			pstat.setInt(4, restaurant.getQuantity());
			pstat.setInt(5, restaurant.getTotal_Price());
			pstat.setInt(6, restaurant.getBooking_ID());

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
		ArrayList<RestaurantLibs>select=new ArrayList();
		String sql="SELECT * FROM food;";
		try {
			conn = connect();
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				RestaurantLibs res=new RestaurantLibs
						(rs.getInt("food_id"),
						rs.getString("food_item"),
						rs.getInt("food_rate"),
						rs.getInt("restaurant_quantity"),
						rs.getInt("restaurant_price"),
						rs.getInt("booking_id")
						);
				select.add(res);
			}
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return select;
		
	}
}
