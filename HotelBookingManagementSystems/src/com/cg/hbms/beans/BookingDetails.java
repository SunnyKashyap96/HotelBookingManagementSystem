package com.cg.hbms.beans;

import java.util.Date;

public class BookingDetails {

	/*booking_id varchar2(20) primary key, room_id varchar2(20), 
	foreign key(room_id) references room_details(room_id) ,  
	user_id varchar2(20), booked_from date, booked_to date,
	no_of_adults number, no_of_children number, amount number(6,2))*/
	
	private String bookingId;
	private String roomId;
	private String userId;
	//private String bookedFrom;
	private Date bookedFrom;
	private Date bookedTo;
	//private String bookedTo;
	private int noOfAdults;
	private int noOfChildren;
	private double amount;
	
	
	
	public BookingDetails() {
		super();
	}
	public BookingDetails(String roomId, String userId, Date bookedFrom, Date bookedTo, int noOfAdults,
			int noOfChildren, double amount) {
		super();
		this.roomId = roomId;
		this.userId = userId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getBookedFrom() {
		return bookedFrom;
	}
	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}
	public Date getBookedTo() {
		return bookedTo;
	}
	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}
	public int getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public int getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", roomId=" + roomId + ", userId=" + userId + ", bookedFrom="
				+ bookedFrom + ", bookedTo=" + bookedTo + ", noOfAdults=" + noOfAdults + ", noOfChildren="
				+ noOfChildren + ", amount=" + amount + "]";
	}

	
	
}
