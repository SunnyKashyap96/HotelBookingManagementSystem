package com.cg.hbms.dao;

import java.time.LocalDate;

import java.util.List;

import com.cg.hbms.beans.BookingDetails;
import com.cg.hbms.beans.GuestDetails;
import com.cg.hbms.beans.Hotel;
import com.cg.hbms.beans.RoomDetails;

public interface HotelBookingSystemDAO {

	public int checkLoginAdmin(String username, String password);
	public int insertHotel(Hotel hotel);
	public int deleteHotelById(String hotelId);
	public int updateHotelById(String hotelId, String description);
	public int insertRoomDetails(RoomDetails roomDetails);
	public int deleteRoom(String hotelId, String roomId);
	public int updateRoomTariff(String hotelId, String roomId, double tariff);
	public List<Hotel> selectAllHotels();
	public List<BookingDetails> selectBookingsOfHotel(String hotelId);
	public List<GuestDetails> selectGuestList(String hotelId);
	public List<BookingDetails> selectBookingsByDate(LocalDate date);
	
}
