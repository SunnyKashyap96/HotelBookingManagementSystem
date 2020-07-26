package com.cg.hbms.beans;

public class GuestDetails {

	private String userId;
	private String userName;
	private String mobileNo;
	private String address;
	private String email;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
		return "GuestDetails [userId=" + userId + ", userName=" + userName + ", mobileNo=" + mobileNo + ", address="
				+ address + ", email=" + email + "]";
	}
	
	
}
