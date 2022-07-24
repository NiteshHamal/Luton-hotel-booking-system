package mylibs;

public class BookingRoom {
	int customer_id;
	int booking_id;
	String arrival_date;
	String departure_date;
	int room_no;
	String room_type;
	String room_status;
	
	public BookingRoom() {
		this.customer_id = 0;
		this.booking_id = 0;
		this.arrival_date = "";
		this.departure_date = "";
		this.room_no = 0;
		this.room_type = "";
		this.room_status = "";
	}
	
	public BookingRoom(int customer_id, int booking_id, String arrival_date, String departure_date, int room_no,
			String room_type, String room_status) {
		this.customer_id = customer_id;
		this.booking_id = booking_id;
		this.arrival_date = arrival_date;
		this.departure_date = departure_date;
		this.room_no = room_no;
		this.room_type = room_type;
		this.room_status = room_status;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getRoom_status() {
		return room_status;
	}

	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}

	@Override
	public String toString() {
		return "BookingRoom [customer_id=" + customer_id + ", booking_id=" + booking_id + ", arrival_date="
				+ arrival_date + ", departure_date=" + departure_date + ", room_no=" + room_no + ", room_type="
				+ room_type + ", room_status=" + room_status + "]";
	}
	
	


}
