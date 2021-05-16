package models;

import java.sql.Date;

public class Cart {
	private int cartId;
	private int userId;
	private int bookId;
	private String userName;
	private Date date;
	private String name;
	private String address;
	private String phone;
	private int amount;
	private float total;
	
	public Cart(int bookId, String userName, int amount) {
		this.bookId = bookId;
		this.userName = userName;
		this.amount = amount;
	}

	public Cart(int cartId, int userId, int bookId, String userName, Date date, String name, String address,
			String phone, int amount, float total) {
		this.cartId = cartId;
		this.userId = userId;
		this.bookId = bookId;
		this.userName = userName;
		this.date = date;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.amount = amount;
		this.total = total;
	}

	public Cart(int userId,String userName, String name, String address, String phone) {
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}



	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", bookId=" + bookId + ", userName=" + userName
				+ ", date=" + date + ", name=" + name + ", address=" + address + ", phone=" + phone + ", amount="
				+ amount + ", total=" + total + "]";
	}
	
	
	
}
