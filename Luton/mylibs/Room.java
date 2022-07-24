package mylibs;

public class Room {
	int room_no;
	String room_type;
	String room_status;
	int room_price;
	
	public Room() {
		this.room_no = 0;
		this.room_type ="";
		this.room_status ="";
		this.room_price = 0;
	}
	
	public Room(int room_no, String room_type, String room_status, int room_price) {
		this.room_no = room_no;
		this.room_type = room_type;
		this.room_status = room_status;
		this.room_price = room_price;
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

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	@Override
	public String toString() {
		return "Room [room_no=" + room_no + ", room_type=" + room_type + ", room_status=" + room_status
				+ ", room_price=" + room_price + "]";
	}

}
