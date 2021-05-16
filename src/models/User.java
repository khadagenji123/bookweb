package models;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String address;
	private int checkUser;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	
	
	public User(int userId, int checkUser) {
		this.userId = userId;
		this.checkUser = checkUser;
	}


	public User(String userName, String password, String name, String phone, String email, String address,
			int checkUser) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.checkUser = checkUser;
	}



	public User(int userId, String userName, String password, String name, String phone, String email, String address) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	

	public User(int userId, String userName, String password, String name, String phone, String email, String address,
			int checkUser) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.checkUser = checkUser;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public int getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(int checkUser) {
		this.checkUser = checkUser;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + "]";
	}
	
	
	
	
	
}
