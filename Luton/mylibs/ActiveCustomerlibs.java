package mylibs;

public class ActiveCustomerlibs {
	
	int booking_id;
	String customer_name;
	
	public ActiveCustomerlibs() {
		this.booking_id = 0;
		this.customer_name = "";
	}
	
	public ActiveCustomerlibs(int booking_id, String customer_name) {
		this.booking_id = booking_id;
		this.customer_name = customer_name;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	@Override
	public String toString() {
		return "ActiveCustomerlibs [booking_id=" + booking_id + ", customer_name=" + customer_name + "]";
	}
	

}
