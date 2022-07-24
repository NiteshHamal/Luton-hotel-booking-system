package mylibs;

public class BookingCustomer {
	int customer_id;
	String customer_name;
	int booking_id;
	String arrival_date;
	String departure_date;
	int room_no;
	String booking_type;
	String booking_status;
	
	
	
	public BookingCustomer() {
		this.customer_id = 0;
		this.customer_name = "";
		this.booking_id = 0;
		this.arrival_date = "";
		this.departure_date = "";
		this.room_no = 0;
		this.booking_type = "";
		this.booking_status = "";
	}
	
	public BookingCustomer(int customer_id, String customer_name, int booking_id, String arrival_date,
			String departure_date, int room_no, String booking_type, String booking_status) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.booking_id = booking_id;
		this.arrival_date = arrival_date;
		this.departure_date = departure_date;
		this.room_no = room_no;
		this.booking_type = booking_type;
		this.booking_status = booking_status;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}

	public String getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getBooking_type() {
		return booking_type;
	}

	public void setBooking_type(String booking_type) {
		this.booking_type = booking_type;
	}

	public String getBooking_status() {
		return booking_status;
	}

	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}

	@Override
	public String toString() {
		return "BookingCustomer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", booking_id="
				+ booking_id + ", arrival_date=" + arrival_date + ", departure_date=" + departure_date + ", room_no="
				+ room_no + ", booking_type=" + booking_type + ", booking_status=" + booking_status + "]";
	}


}
