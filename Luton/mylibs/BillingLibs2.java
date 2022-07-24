package mylibs;

public class BillingLibs2 {
	
	int Billing_ID;
	String Name;
	int Room_Price;
	int Food_Price;
	int Bar_Price;
	int Service_Price;
	double Total_Bill;
	double Discount;
	int booking_id;
	
	
	public BillingLibs2() {
		
		this.Billing_ID = 0;
		this.Name = "";
		this.Room_Price = 0;
		this.Food_Price = 0;
		this.Bar_Price = 0;
		this.Service_Price = 0;
		this.Total_Bill = 0.0;
		this.Discount = 0.0;
		this.booking_id= 0;
	}
	



	public BillingLibs2(int billing_ID, String name, int room_Price, int food_Price, int bar_Price, int service_Price,
			double total_Bill, double discount, String billing_Status,
			int booking_id) {
		this.Billing_ID = billing_ID;
		this.Name = name;
		this.Room_Price = room_Price;
		this.Food_Price = food_Price;
		this.Bar_Price = bar_Price;
		this.Service_Price = service_Price;
		this.Total_Bill = total_Bill;
		this.Discount = discount;
		this.booking_id = booking_id;
	}




	public int getBilling_ID() {
		return Billing_ID;
	}




	public void setBilling_ID(int billing_ID) {
		Billing_ID = billing_ID;
	}




	public String getName() {
		return Name;
	}




	public void setName(String name) {
		Name = name;
	}




	public int getRoom_Price() {
		return Room_Price;
	}




	public void setRoom_Price(int room_Price) {
		Room_Price = room_Price;
	}




	public int getFood_Price() {
		return Food_Price;
	}




	public void setFood_Price(int food_Price) {
		Food_Price = food_Price;
	}




	public int getBar_Price() {
		return Bar_Price;
	}




	public void setBar_Price(int bar_Price) {
		Bar_Price = bar_Price;
	}




	public int getService_Price() {
		return Service_Price;
	}




	public void setService_Price(int service_Price) {
		Service_Price = service_Price;
	}




	public double getTotal_Bill() {
		return Total_Bill;
	}




	public void setTotal_Bill(double total_Bill) {
		Total_Bill = total_Bill;
	}




	public double getDiscount() {
		return Discount;
	}




	public void setDiscount(double discount) {
		Discount = discount;
	}


	public int getBooking_id() {
		return booking_id;
	}




	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}




	@Override
	public String toString() {
		return "BillingLibs2 [Billing_ID=" + Billing_ID + ", Name=" + Name + ", Room_Price=" + Room_Price
				+ ", Food_Price=" + Food_Price + ", Bar_Price=" + Bar_Price + ", Service_Price=" + Service_Price
				+ ", Total_Bill=" + Total_Bill + ", Discount=" + Discount + ", booking_id=" + booking_id + "]";
	}



}
