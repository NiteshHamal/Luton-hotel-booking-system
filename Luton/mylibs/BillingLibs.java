package mylibs;

public class BillingLibs {
	
	int Booking_ID;
	String CheckIn;
	String CheckOut;
	String Name;
	String reg_type;
	int Bar;
	int Food;
	int Service;
	int Room_ID;
	int Room_Price;
	
	
	public BillingLibs() {
		this.Booking_ID = 0;
		this.CheckIn = "";
		this.CheckOut = "";
		this.Name = "";
		this.reg_type = "";
		this.Bar = 0;
		this.Food = 0;
		this.Service = 0;
		this.Room_ID = 0;
		this.Room_Price = 0;
	}
	
	public BillingLibs(int booking_ID, String checkIn, String checkOut, String name, String reg_type, int bar, int food,
			int service, int room_ID, int room_Price) {
		this.Booking_ID = booking_ID;
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
		this.Name = name;
		this.reg_type = reg_type;
		this.Bar = bar;
		this.Food = food;
		this.Service = service;
		this.Room_ID = room_ID;
		this.Room_Price = room_Price;
	}

	public int getBooking_ID() {
		return Booking_ID;
	}

	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}

	public String getCheckIn() {
		return CheckIn;
	}

	public void setCheckIn(String checkIn) {
		CheckIn = checkIn;
	}

	public String getCheckOut() {
		return CheckOut;
	}

	public void setCheckOut(String checkOut) {
		CheckOut = checkOut;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getReg_type() {
		return reg_type;
	}

	public void setReg_type(String reg_type) {
		this.reg_type = reg_type;
	}

	public int getBar() {
		return Bar;
	}

	public void setBar(int bar) {
		Bar = bar;
	}

	public int getFood() {
		return Food;
	}

	public void setFood(int food) {
		Food = food;
	}

	public int getService() {
		return Service;
	}

	public void setService(int service) {
		Service = service;
	}

	public int getRoom_ID() {
		return Room_ID;
	}

	public void setRoom_ID(int room_ID) {
		Room_ID = room_ID;
	}

	public int getRoom_Price() {
		return Room_Price;
	}

	public void setRoom_Price(int room_Price) {
		Room_Price = room_Price;
	}

	@Override
	public String toString() {
		return "BillingLibs [Booking_ID=" + Booking_ID + ", CheckIn=" + CheckIn + ", CheckOut=" + CheckOut + ", Name="
				+ Name + ", reg_type=" + reg_type + ", Bar=" + Bar + ", Food=" + Food + ", Service=" + Service
				+ ", Room_ID=" + Room_ID + ", Room_Price=" + Room_Price + "]";
	}
	

}
