package com.cg.hbms.beans;

public class RoomDetails {
	private String hotelId;
	private String roomId;
	private String roomNo;
	private String roomType;
	private double perNightRate;
	private String availability;
	public RoomDetails() {
		super();
	}
	
	public RoomDetails(String hotelId, String roomId, String roomNo, String roomType, double perNightRate,
			String availability) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.perNightRate = perNightRate;
		this.availability = availability;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getPerNightRate() {
		return perNightRate;
	}
	public void setPerNightRate(double perNightRate) {
		this.perNightRate = perNightRate;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvaailability(String avaailability) {
		this.availability = avaailability;
	}
	@Override
	public String toString() {
		return "RoomDetail [hotelId=" + hotelId + ", roomId=" + roomId + ", roomNo=" + roomNo + ", roomType=" + roomType
				+ ", perNightRate=" + perNightRate + ", avaailability=" + availability + "]";
	}
	

}
