package com.cg.hbms.service;
import java.time.LocalDate;

import java.util.List;

import com.cg.hbms.beans.BookingDetails;
import com.cg.hbms.beans.GuestDetails;
import com.cg.hbms.beans.Hotel;
import com.cg.hbms.beans.RoomDetails;
import com.cg.hbms.dao.HotelBookingSystemDAO;
import com.cg.hbms.dao.HotelBookingSystemDAOImpl;

public class HotelBookingSystemServiceImpl implements HotelBookingSystemService{

	HotelBookingSystemDAO dao = new HotelBookingSystemDAOImpl();
	
	@Override
	public int verifyLoginAdmin(String username, String password) {
		return dao.checkLoginAdmin(username, password);
	}
	
	@Override
	public int addHotel(Hotel hotel) {
		return dao.insertHotel(hotel);
	}
	
	@Override
	public int removeHotelById(String hotelId) {
		return dao.deleteHotelById(hotelId);
	}
	
	@Override
	public int modifyHotelById(String hotelId, String description) {
		return dao.updateHotelById(hotelId, description);
	}
	@Override
	public int addRoomDetails(RoomDetails roomDetails) {
		return dao.insertRoomDetails(roomDetails);
	}
	@Override
	public int removeRoom(String hotelId, String roomId) {
		return dao.deleteRoom(hotelId, roomId);
	}
	@Override
	public int modifyRoomTariff(String hotelId, String roomId, double tariff) {
		return dao.updateRoomTariff(hotelId, roomId, tariff);
	}

	@Override
	public List<Hotel> viewAllHotels(){
		return dao.selectAllHotels();
	}

	@Override
	public List<BookingDetails> viewBookingsOfHotel(String hotelId) {
		return dao.selectBookingsOfHotel(hotelId);
	}

	@Override
	public List<GuestDetails> viewGuestList(String hotelId) {
		return dao.selectGuestList(hotelId);
	}

	@Override
	public List<BookingDetails> viewBookingsByDate(LocalDate enterDate) {
		return dao.selectBookingsByDate(enterDate);
	}

}
