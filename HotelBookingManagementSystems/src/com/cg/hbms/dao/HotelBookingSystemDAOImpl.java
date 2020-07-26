package com.cg.hbms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.hbms.beans.BookingDetails;
import com.cg.hbms.beans.GuestDetails;
import com.cg.hbms.beans.Hotel;
import com.cg.hbms.beans.RoomDetails;

public class HotelBookingSystemDAOImpl implements HotelBookingSystemDAO {
	Connection conn;

	@Override
	public int checkLoginAdmin(String username, String password) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

			Statement st = conn.createStatement();
			String query = "Select * From ADMIN";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String user = rs.getString("username");
				String pass = rs.getString("password");
				if (user.equals(username) && pass.equals(password)) {
					return 1;
				} else {
					return 0;
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int insertHotel(Hotel hotel) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "INSERT INTO HOTEL VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, hotel.getHotelId());
			pstat.setString(2, hotel.getCity());
			pstat.setString(3, hotel.getHotelName());
			pstat.setString(4, hotel.getAddress());
			pstat.setString(5, hotel.getDescription());
			pstat.setDouble(6, hotel.getAvgRatePerNight());
			pstat.setString(7, hotel.getPhoneNo1());
			pstat.setString(8, hotel.getPhoneNo2());
			pstat.setString(9, hotel.getRating());
			pstat.setString(10, hotel.getEmail());
			pstat.setString(11, hotel.getFax());
			int result = pstat.executeUpdate();
			return result;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteHotelById(String hotelId) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "DELETE FROM HOTEL WHERE HOTEL_ID=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, hotelId);
			int result = pstat.executeUpdate();
			return result;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateHotelById(String hotelId, String description) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "UPDATE HOTEL SET DESCRIPTION=? WHERE HOTEL_ID=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, description);
			pstat.setString(2, hotelId);
			int result = pstat.executeUpdate();
			return result;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertRoomDetails(RoomDetails roomDetails) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "INSERT INTO Room_Details VALUES(?,?,?,?,?,?)";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, roomDetails.getHotelId());
			pstat.setString(2, roomDetails.getRoomId());
			pstat.setString(3, roomDetails.getRoomNo());
			pstat.setString(4, roomDetails.getRoomType());
			pstat.setDouble(5, roomDetails.getPerNightRate());
			pstat.setString(6, roomDetails.getAvailability());

			int result = pstat.executeUpdate();
			return result;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int deleteRoom(String hotelId, String roomId) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "DELETE FROM Room_Details WHERE HOTEL_ID=? AND ROOM_ID=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, hotelId);
			pstat.setString(2, roomId);
			int result = pstat.executeUpdate();
			return result;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateRoomTariff(String hotelId, String roomId, double tariff) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "UPDATE ROOM_DETAILS SET PER_NIGHT_RATE=? WHERE HOTEL_ID=? AND ROOM_ID=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setDouble(1, tariff);
			pstat.setString(2, hotelId);
			pstat.setString(3, roomId);
			int result = pstat.executeUpdate();
			return result;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Hotel> selectAllHotels() {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

			Statement st = conn.createStatement();
			String query = "Select * From HOTEL";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setHotelId(rs.getString("Hotel_id"));
				hotel.setCity(rs.getString("City"));
				hotel.setHotelName(rs.getString("Hotel_Name"));
				hotel.setAddress(rs.getString("Address"));
				hotel.setDescription(rs.getString("Description"));
				hotel.setAvgRatePerNight(rs.getDouble("Avg_Rate_Per_Night"));
				hotel.setPhoneNo1(rs.getString("Phone_No1"));
				hotel.setPhoneNo2(rs.getString("Phone_No2"));
				hotel.setRating(rs.getString("Rating"));
				hotel.setEmail(rs.getString("Email"));
				hotel.setFax(rs.getString("Fax"));
				hotelList.add(hotel);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return hotelList;

	}

	@Override
	public List<BookingDetails> selectBookingsOfHotel(String hotelId) {
		List<BookingDetails> bookingList = new ArrayList<BookingDetails>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

			String query = "select Booking_id,room_id,user_id,booked_from,booked_to,no_of_adults,no_of_children,amount from room_details natural join bookingdetails where hotel_id=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, hotelId);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				BookingDetails bookingDetails = new BookingDetails();
				bookingDetails.setBookingId(rs.getString("booking_id"));
				bookingDetails.setRoomId(rs.getString("room_id"));
				bookingDetails.setUserId(rs.getString("user_id"));
				bookingDetails.setBookedFrom(rs.getDate("booked_from"));
				bookingDetails.setBookedTo(rs.getDate("booked_To"));
				bookingDetails.setNoOfAdults(rs.getInt("no_of_adults"));
				bookingDetails.setNoOfChildren(rs.getInt("no_of_children"));
				bookingDetails.setAmount(rs.getDouble("amount"));
				bookingList.add(bookingDetails);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return bookingList;
	}

	@Override
	public List<GuestDetails> selectGuestList(String hotelId) {
		List<GuestDetails> guestList = new ArrayList<GuestDetails>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

			String query = "select user_id,user_name,mobile_no,address,email from users natural join (select user_id from( (hotel natural join room_Details )  natural join bookingDetails) where hotel_id=?)";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, hotelId);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				GuestDetails guestDetails = new GuestDetails();
				guestDetails.setUserId(rs.getString("USER_ID"));
				guestDetails.setUserName(rs.getString("USER_NAME"));
				guestDetails.setMobileNo(rs.getString("MOBILE_NO"));
				guestDetails.setAddress(rs.getString("ADDRESS"));
				guestDetails.setEmail(rs.getString("EMAIL"));
				guestList.add(guestDetails);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return guestList;
	}

	@Override
	public List<BookingDetails> selectBookingsByDate(LocalDate date) {
	
		List<BookingDetails> bookingList = new ArrayList<BookingDetails>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

			String query = "select * from bookingDetails where ?<=booked_to and ?>=booked_from";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setDate(1,java.sql.Date.valueOf(date));
			pstat.setDate(2,java.sql.Date.valueOf(date));
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				BookingDetails bookingsDetails = new BookingDetails();
				bookingsDetails.setBookingId(rs.getString("booking_id"));
				bookingsDetails.setRoomId(rs.getString("room_id"));
				bookingsDetails.setUserId(rs.getString("user_id"));
				bookingsDetails.setBookedFrom(rs.getDate("booked_from"));
				bookingsDetails.setBookedTo(rs.getDate("booked_To"));
		
				bookingsDetails.setNoOfAdults(rs.getInt("no_of_adults"));
				bookingsDetails.setNoOfChildren(rs.getInt("no_of_children"));
				bookingsDetails.setAmount(rs.getDouble("amount"));
				bookingList.add(bookingsDetails);
	
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return bookingList;
	}

}
