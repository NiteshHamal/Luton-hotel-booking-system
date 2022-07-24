package mylibs;

public class ServiceLibs {

	int Service_ID;
	String Service_Type;
	long Service_Price;
	int Booking_ID;

	public ServiceLibs() {

		this.Service_ID = 0;
		this.Service_Type = "";
		this.Service_Price = 0;
		this.Booking_ID = 0;
	}

	public ServiceLibs(int service_ID, String service_Type, long service_Price, int booking_ID) {

		this.Service_ID = service_ID;
		this.Service_Type = service_Type;
		this.Service_Price = service_Price;
		this.Booking_ID = booking_ID;
	}

	public int getService_ID() {
		return Service_ID;
	}

	public void setService_ID(int service_ID) {
		Service_ID = service_ID;
	}

	public String getService_Type() {
		return Service_Type;
	}

	public void setService_Type(String service_Type) {
		Service_Type = service_Type;
	}

	public long getService_Price() {
		return Service_Price;
	}

	public void setService_Price(long service_Price) {
		Service_Price = service_Price;
	}

	public int getBooking_ID() {
		return Booking_ID;
	}

	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}

	@Override
	public String toString() {
		return "ServiceLibs [Service_ID=" + Service_ID + ", Service_Type=" + Service_Type + ", Service_Price="
				+ Service_Price + ", Booking_ID=" + Booking_ID + "]";
	}

}
