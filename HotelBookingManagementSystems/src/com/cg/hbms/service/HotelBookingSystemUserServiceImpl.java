package com.cg.hbms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.hbms.beans.BookingDetails;
import com.cg.hbms.beans.Hotel;
import com.cg.hbms.beans.RoomDetails;
import com.cg.hbms.beans.Users;
import com.cg.hbms.dao.HotelBookingSystemUserDAO;
import com.cg.hbms.dao.HotelBookingSystemUserDAOImpl;

public class HotelBookingSystemUserServiceImpl implements HotelBookingSystemUserService{
	HotelBookingSystemUserDAO dao = new HotelBookingSystemUserDAOImpl();
	@Override
	public int addUser(Users users) {
		return dao.insertUsers(users);
	}
	@Override
	public int verifyUser(String username, String password) {
		return dao.checkUser(username, password);
	}
	@Override
	public List<Hotel> viewHotelsByCity(String hotelCity) {
		return dao.selectHotelsByCity(hotelCity);
	}
	@Override
	public List<RoomDetails> viewRoomsByHotelId(String hotelId) {
		return dao.selectRoomsByHotelId(hotelId);
	}
	@Override
	public List<Hotel> viewHotelsByName(String hotelName) {
		return dao.selectHotelsByName(hotelName);
	}
	@Override
	public double showTotalAmount(String roomId, LocalDate entryDate, LocalDate exitDate, int noOfAdults) {
		return dao.viewTotalAmount(roomId, entryDate, exitDate, noOfAdults);
	}
	@Override
	public int addBookingDetails(String roomId, String userId, LocalDate entryDate, LocalDate exitDate, int noOfAdults, int noOfChildren, double amount) {
		return dao.insertBookingDetails(roomId, userId, entryDate, exitDate, noOfAdults, noOfChildren, amount);
	}

	@Override
	public List<BookingDetails> showBookingDetailsByUserId(String userId) {
		return dao.selectBookingDetails(userId);
	}

}
