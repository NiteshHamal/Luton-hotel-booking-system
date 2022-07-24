package mylibs;

public class RestaurantLibs {
	
	int Restaurant_ID;
	String Restaurant_Item;
	int Rate;
	int Quantity;
	int Total_Price;
	int Booking_ID;
	
	
	public RestaurantLibs() {
		
		this.Restaurant_ID = 0;
		this.Restaurant_Item = "";
		this.Rate = 0;
		this.Quantity = 0;
		this.Total_Price = 0;
		this.Booking_ID = 0;
	}
	
	public RestaurantLibs(int restaurant_ID, String restaurant_Item, int rate, int quantity, int total_Price,
			int booking_ID) {
		
		this.Restaurant_ID = restaurant_ID;
		this.Restaurant_Item = restaurant_Item;
		this.Rate = rate;
		this.Quantity = quantity;
		this.Total_Price = total_Price;
		this.Booking_ID = booking_ID;
	}

	public int getRestaurant_ID() {
		return Restaurant_ID;
	}

	public void setRestaurant_ID(int restaurant_ID) {
		Restaurant_ID = restaurant_ID;
	}

	public String getRestaurant_Item() {
		return Restaurant_Item;
	}

	public void setRestaurant_Item(String restaurant_Item) {
		Restaurant_Item = restaurant_Item;
	}

	public int getRate() {
		return Rate;
	}

	public void setRate(int rate) {
		Rate = rate;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getTotal_Price() {
		return Total_Price;
	}

	public void setTotal_Price(int total_Price) {
		Total_Price = total_Price;
	}

	public int getBooking_ID() {
		return Booking_ID;
	}

	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}

	@Override
	public String toString() {
		return "RestaurantLibs [Restaurant_ID=" + Restaurant_ID + ", Restaurant_Item=" + Restaurant_Item + ", Rate="
				+ Rate + ", Quantity=" + Quantity + ", Total_Price=" + Total_Price + ", Booking_ID=" + Booking_ID + "]";
	}
	
	
	

}
