package mylibs;

public class Receptionist {
	int staff_no;
	String username;
	String password;
	String role;
	
	
	public Receptionist() {
		this.staff_no = 0;
		this.username = "";
		this.password = "";
		this.role = "";
	}
	
	public Receptionist(int staff_no, String username, String password, String role) {
		this.staff_no = staff_no;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getStaff_no() {
		return staff_no;
	}

	public void setStaff_no(int staff_no) {
		this.staff_no = staff_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Receptionist [staff_no=" + staff_no + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}
	

}
