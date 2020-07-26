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
import java.time.temporal.ChronoUnit;

import com.cg.hbms.beans.BookingDetails;
import com.cg.hbms.beans.Hotel;
import com.cg.hbms.beans.RoomDetails;
import com.cg.hbms.beans.Users;

public class HotelBookingSystemUserDAOImpl implements HotelBookingSystemUserDAO {
	Connection conn;
	@Override
	public int insertUsers(Users users) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?)";
			String queryString = "SELECT user_Seq.NEXTVAL FROM DUAL";
			String seqId="1000"; 
			PreparedStatement pstat = conn.prepareStatement(query);
			PreparedStatement pstat1 = conn.prepareStatement(queryString);
			ResultSet rs = pstat1.executeQuery();
			while (rs.next()) {
				seqId = rs.getString(1);
				break;
			}
			rs.close();
			pstat.setString(1, seqId);
			pstat.setString(2, users.getPassword());
			pstat.setString(3, users.getRole());
			pstat.setString(4, users.getUsername());
			pstat.setString(5, users.getMobileNo());
			pstat.setString(6, users.getPhone());
			pstat.setString(7,users.getAddress());
			pstat.setString(8, users.getEmail());
			int result = pstat.executeUpdate();
			return result;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int checkUser(String username, String password) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

			Statement st = conn.createStatement();
			String query = "Select From USERS where";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String user = rs.getString("user_name");
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
	public List<Hotel> selectHotelsByCity(String hotelCity) {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

			String query = "select * from hotel where city=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, hotelCity);
			ResultSet rs = pstat.executeQuery();
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
	public List<RoomDetails> selectRoomsByHotelId(String hotelId) {
		List<RoomDetails> roomDetailsList = new ArrayList<RoomDetails>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

			String query = "select * from room_details where HOTEL_ID=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, hotelId);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				RoomDetails roomDetails = new RoomDetails();
				roomDetails.setHotelId(rs.getString("Hotel_id"));
				roomDetails.setRoomId(rs.getString("ROOM_ID"));
				roomDetails.setRoomNo(rs.getString("ROOM_NO"));
				roomDetails.setRoomType(rs.getString("ROOM_TYPE"));
				roomDetails.setPerNightRate(rs.getDouble("PER_NIGHT_RATE"));
				roomDetails.setAvaailability("AVAILABILITY");
				roomDetailsList.add(roomDetails);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return roomDetailsList;
	}
	@Override
	public List<Hotel> selectHotelsByName(String hotelName) {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

			String query = "select * from hotel where hotel_name=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, hotelName);
			ResultSet rs = pstat.executeQuery();
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
	public double viewTotalAmount(String roomId, LocalDate entryDate, LocalDate exitDate, int noOfAdults) {
		double amount = 0.0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			double perNightRate = 0.0;
			String query = "select per_night_rate from room_Details where room_Id=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, roomId);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				perNightRate = rs.getDouble("per_night_rate");
			}
			long daysBetween = ChronoUnit.DAYS.between(entryDate, exitDate);
			amount = perNightRate*noOfAdults*daysBetween;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return amount;
	}
	
	@Override
	public int insertBookingDetails(String roomId, String userId, LocalDate entryDate, LocalDate exitDate,
			int noOfAdults, int noOfChildren, double amount) {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "INSERT INTO BookingDetails VALUES(?,?,?,?,?,?,?,?)";
			String queryString = "SELECT booking_Seq.NEXTVAL FROM DUAL";
			String bookingId="100"; 
			PreparedStatement pstat = conn.prepareStatement(query);
			PreparedStatement pstat1 = conn.prepareStatement(queryString);
			ResultSet rs = pstat1.executeQuery();
			while (rs.next()) {
				bookingId = rs.getString(1);
				break;
			}
			pstat.setString(1, bookingId);
			pstat.setString(2, roomId);
			pstat.setString(3, userId);
			pstat.setDate(4,java.sql.Date.valueOf(entryDate));
			pstat.setDate(5,java.sql.Date.valueOf(exitDate));
			pstat.setInt(6, noOfAdults);
			pstat.setInt(7, noOfChildren);
			pstat.setDouble(8, amount);
			int result = pstat.executeUpdate();
			if(result==1) {
				setRoomAvailibilty(roomId);
			}
			return result;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int setRoomAvailibilty(String roomId) {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "UPDATE ROOM_DETAILS SET AVAILABILITY='F' WHERE ROOM_ID=?";
			PreparedStatement pstat = conn.prepareStatement(query);
		
			pstat.setString(1, roomId);
			int result = pstat.executeUpdate();
			return result;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<BookingDetails> selectBookingDetails(String userId) {
		List<BookingDetails> bookingList = new ArrayList<BookingDetails>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
			String query = "select * from bookingDetails where user_id=?";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, userId);
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

}
