package com.cg.hbms.beans;

public class Users {
	private String userId;
	private String password;
	private String role;
	private String username;
	private String mobileNo;
	private String phone;
	private String address;
	private String email;

	public Users() {
		super();
	}

	public Users( String password, String role, String username, String mobileNo, String phone,
			String address, String email) {
		super();
		//this.userId = userId;
		this.password = password;
		this.role = role;
		this.username = username;
		this.mobileNo = mobileNo;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	 public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + ", role=" + role + ", username=" + username
				+ ", mobileNo=" + mobileNo + ", phone=" + phone + ", address=" + address + ", email=" + email + "]";
	}

}
