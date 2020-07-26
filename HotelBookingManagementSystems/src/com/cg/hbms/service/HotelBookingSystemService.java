package com.cg.hbms.service;
import java.time.LocalDate;

import java.util.List;

import com.cg.hbms.beans.BookingDetails;
import com.cg.hbms.beans.GuestDetails;
import com.cg.hbms.beans.Hotel;
import com.cg.hbms.beans.RoomDetails;

public interface HotelBookingSystemService {

	public int verifyLoginAdmin(String username, String password);
	public int addHotel(Hotel hotel);
	public int removeHotelById(String hotelId);
	public int modifyHotelById(String hotelId, String description);
	public int addRoomDetails(RoomDetails roomDetails);
	public int removeRoom(String hotelId, String roomId);
	public int modifyRoomTariff(String hotelId, String roomId, double tariff);
	public List<Hotel> viewAllHotels();
	public List<BookingDetails> viewBookingsOfHotel(String hotelId);
	public List<GuestDetails> viewGuestList(String hotelId);
	public List<BookingDetails> viewBookingsByDate(LocalDate date);
}
