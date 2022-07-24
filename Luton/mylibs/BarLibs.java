package mylibs;

public class BarLibs {
	
	int bar_id;
	String bar_item;
	int rate;
	int quantity;
	int total_price;
	int booking_id;
	
	public BarLibs() {
		this.bar_id =0;
		this.bar_item ="";
		this.rate = 0;
		this.quantity = 0;
		this.total_price = 0;
		this.booking_id = 0;
	}
	
	public BarLibs(int bar_id, String bar_item, int rate, int quantity, int total_price, int booking_id) {
		this.bar_id = bar_id;
		this.bar_item = bar_item;
		this.rate = rate;
		this.quantity = quantity;
		this.total_price = total_price;
		this.booking_id = booking_id;
	}

	public int getBar_id() {
		return bar_id;
	}

	public void setBar_id(int bar_id) {
		this.bar_id = bar_id;
	}

	public String getBar_item() {
		return bar_item;
	}

	public void setBar_item(String bar_item) {
		this.bar_item = bar_item;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	@Override
	public String toString() {
		return "BarLibs [bar_id=" + bar_id + ", bar_item=" + bar_item + ", rate=" + rate + ", quantity=" + quantity
				+ ", total_price=" + total_price + ", booking_id=" + booking_id + "]";
	}
	
	

}
