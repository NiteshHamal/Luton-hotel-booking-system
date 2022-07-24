package mylibs;

public class AvailableRoomLibs {
	
	int Room_No;
	String Room_Type;
	String Room_Status;
	
	
	public AvailableRoomLibs() {
		
		this.Room_No = 0;
		this.Room_Type = "";
		this.Room_Status = "";
	}
	
	
public AvailableRoomLibs(int room_No, String room_Type, String room_Status) {
		
		this.Room_No = room_No;
		this.Room_Type = room_Type;
		this.Room_Status = room_Status;
	}


public int getRoom_No() {
	return Room_No;
}


public void setRoom_No(int room_No) {
	Room_No = room_No;
}


public String getRoom_Type() {
	return Room_Type;
}


public void setRoom_Type(String room_Type) {
	Room_Type = room_Type;
}


public String getRoom_Status() {
	return Room_Status;
}


public void setRoom_Status(String room_Status) {
	Room_Status = room_Status;
}


@Override
public String toString() {
	return "AvailableRoomLibs [Room_No=" + Room_No + ", Room_Type=" + Room_Type + ", Room_Status=" + Room_Status + "]";
}
	
	

}
