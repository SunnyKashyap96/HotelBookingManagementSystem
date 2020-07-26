package com.cg.hbms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.hbms.beans.BookingDetails;
import com.cg.hbms.beans.Hotel;
import com.cg.hbms.beans.RoomDetails;
import com.cg.hbms.beans.Users;

public interface HotelBookingSystemUserService {
	public int addUser(Users users);
	public int verifyUser(String username, String password);
	public List<Hotel> viewHotelsByCity(String hotelCity);
	public List<RoomDetails> viewRoomsByHotelId(String hotelId);
	public List<Hotel> viewHotelsByName(String hotelName);
	public double showTotalAmount(String roomId, LocalDate entryDate, LocalDate exitDate, int noOfAdults);
	public int addBookingDetails(String roomId, String userId, LocalDate entryDate, LocalDate exitDate, int noOfAdults, int noOfChildren, double amount);
	public List<BookingDetails> showBookingDetailsByUserId(String userId);

}
