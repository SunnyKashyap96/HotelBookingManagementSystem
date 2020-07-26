package com.cg.hbms.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.hbms.beans.BookingDetails;
import com.cg.hbms.beans.Hotel;
import com.cg.hbms.beans.RoomDetails;
import com.cg.hbms.beans.Users;

public interface HotelBookingSystemUserDAO {
	public int insertUsers(Users users);

	public int checkUser(String username, String password);

	public List<Hotel> selectHotelsByCity(String hotelCity);

	public List<RoomDetails> selectRoomsByHotelId(String hotelId);

	public List<Hotel> selectHotelsByName(String hotelName);

	public double viewTotalAmount(String roomId, LocalDate entryDate, LocalDate exitDate, int noOfAdults);

	public int insertBookingDetails(String roomId, String userId, LocalDate entryDate, LocalDate exitDate, int noOfAdults, int noOfChildren, double amount);

	public List<BookingDetails> selectBookingDetails(String userId);

}
