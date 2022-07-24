package mylibs;

public class Registration {
	
	int id;
	String fullName;
	String address;
	long phoneNo;
	String email;
	long creditCardNo;
	String username;
	String password;
	String regType;
	
	
	public Registration() {
		this.id = 0;
		this.fullName = "";
		this.address = "";
		this.phoneNo = 0;
		this.email = "";
		this.creditCardNo = 0;
		this.username = "";
		this.password = "";
		this.regType = "";
	}
	
	public Registration(int id, String fullName, String address, long phoneNo, String email, long creditCardNo,
			String username, String password, String regType) {
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.creditCardNo = creditCardNo;
		this.username = username;
		this.password = password;
		this.regType = regType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(long creditCardNo) {
		this.creditCardNo = creditCardNo;
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

	public String getRegType() {
		return regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", fullName=" + fullName + ", address=" + address
				+ ", phoneNo=" + phoneNo + ", email=" + email + ", creditCardNo=" + creditCardNo + ", username="
				+ username + ", password=" + password + ", regType=" + regType + "]";
	}
	

	
	

}
