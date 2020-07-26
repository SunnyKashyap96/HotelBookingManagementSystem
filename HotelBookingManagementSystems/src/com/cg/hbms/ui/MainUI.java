package com.cg.hbms.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cg.hbms.beans.Hotel;
import com.cg.hbms.beans.RoomDetails;
import com.cg.hbms.beans.Users;
import com.cg.hbms.service.HotelBookingSystemServiceImpl;
import com.cg.hbms.service.HotelBookingSystemUserServiceImpl;
import com.cg.hbms.util.Validations;

public class MainUI {
	static Scanner sc = new Scanner(System.in);
	static HotelBookingSystemServiceImpl hotelService = new HotelBookingSystemServiceImpl();
	static HotelBookingSystemUserServiceImpl userService = new HotelBookingSystemUserServiceImpl();
	static BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
	static int choice = 0;
	private static Hotel hotel = new Hotel();
	// private static Users users = new Users();

	public static void main(String args[]) throws IOException {
		String user, password;
		int loopEnd1 = 0, loopEnd2 = 0;
		System.out.println("################ WELCOME TO HOTEL BOOKING MANAGEMENT SYSTEM ################ ");
		System.out.println("1. Admin Access");
		System.out.println("2. Customer/Hotel-Employee Access");
		System.out.println("Enter Your Choice");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("----- Admin Access -----");
			System.out.println("Enter username");
			user = sc.next();
			System.out.println("Enter Password");
			password = sc.next();
			int result = hotelService.verifyLoginAdmin(user, password);
			if (result == 1) {
				System.out.println("YOU ARE WELCOME!");
				outer: do {
					System.out.println("1. Perform Hotel Management");
					System.out.println("2. Peform Room Management");
					System.out.println("3. Report Generation");
					System.out.println("4. Exit application");
					System.out.println("Enter your choice:");
					choice = sc.nextInt();
					do {
						switch (choice) {
						case 1:
							System.out.println("HOTEL MANAGEMENT---------");
							System.out.println("1.Add hotel");
							System.out.println("2.Delete hotel");
							System.out.println("3.Modify hotel");
							System.out.println("4.Go back to previous menu");
							System.out.println("5.Exit application");
							System.out.println("Enter your choice of operation");
							int select = sc.nextInt();
							switch (select) {
							case 1:
								System.out.println("Enter Hotel ID:");
								String hotelId = sc.next();
								hotel.setHotelId(hotelId);
								System.out.println("Enter city Name:");
								hotel.setCity(sc.next());
								System.out.println("Enter Hotel Name:");
								String hotelName;
								while ((hotelName = buffReader.readLine()).endsWith("\n")) {

								}
								hotel.setHotelName(hotelName);
								System.out.println("Enter address of Hotel:");
								String hotelAddress;
								while ((hotelAddress = buffReader.readLine()).endsWith("\n")) {

								}
								hotel.setAddress(hotelAddress);
								System.out.println("Enter description :");
								String hotelDescription;
								while ((hotelDescription = buffReader.readLine()).endsWith("\n")) {
								}
								hotel.setDescription(hotelDescription);
								System.out.println("Enter average rate per night:");
								hotel.setAvgRatePerNight(sc.nextDouble());
								System.out.println("Enter phone number:");
								hotel.setPhoneNo1(sc.next());
								System.out.println("Enter Alternative Phone number:");
								String phoneNo2 = sc.next();
								hotel.setPhoneNo2(phoneNo2);
								System.out.println("Enter rating:");
								String rating = sc.next();
								hotel.setRating(rating);
								System.out.println("Enter email:");
								hotel.setEmail(sc.next());
								System.out.println("Enter fax:");
								hotel.setFax(sc.next());
								int res = hotelService.addHotel(hotel);
								if (res == 1) {
									System.out.println("One Hotel added...");
								} else {
									System.out.println("Hotel not added...");
								}
								break;
							case 2:
								System.out.println("Enter Hotel Id");
								String hotelId1 = sc.next();
								int result1 = hotelService.removeHotelById(hotelId1);
								if (result1 == 1) {
									System.out.println("Hotel id " + hotelId1 + " has been deleted successfully");
								} else {
									System.out.println("No hotel_id found to delete..");
								}
								break;
							case 3:
								System.out.println("Enter Hotel Id:");
								String id = sc.next();
								System.out.println("Enter Hotel Description");
								String description;
								while ((description = buffReader.readLine()).endsWith("\n")) {
								}
								int result2 = hotelService.modifyHotelById(id, description);
								if (result2 == 1) {
									System.out.println("Hotel Modified...");
								} else {
									System.out.println("Modification not possible...");
								}
								break;
							case 4:
								continue outer;
							case 5:
								System.exit(0);
							default:
								System.out.println("Enter valid choice..");
							}

							break;
						case 2:
							System.out.println("ROOM MANAGEMENT--------");
							System.out.println("1. Add room");
							System.out.println("2. Delete room");
							System.out.println("3. Modify room");
							System.out.println("4. Go back to previous menu");
							System.out.println("5. Exit application");
							System.out.println("Enter choice:");
							int option = sc.nextInt();
							switch (option) {
							case 1:
								System.out.println("Enter hotel ID:");
								String hotelId = sc.next();
								System.out.println("Enter room ID:");
								String roomId = sc.next();
								System.out.println("Enter room no:");
								String roomNo = sc.next();
								System.out.println("Select room type");
								System.out.println("1. Standard non A/C room");
								System.out.println("2. Standard A/C room");
								System.out.println("3. Executive A/C room");
								System.out.println("4. Deluxe A/C room");
								System.out.println("Enter choice:");
								int option1 = sc.nextInt();
								String roomType = null;
								switch (option1) {
								case 1:
									roomType = "Standard non A/C room";
									break;
								case 2:
									roomType = "Standard A/C room";
									break;
								case 3:
									roomType = "Executive A/C room";
									break;
								case 4:
									roomType = "Deluxe A/C room";
									break;
								default:
									System.out.println("Enter valid room type");
								}
								System.out.println("Enter per_night_rate:");
								double perNightRate = sc.nextDouble();
								System.out.println("Enter availibility(T/F):");
								String avail = sc.next();
								RoomDetails roomDetails = new RoomDetails(hotelId, roomId, roomNo, roomType,
										perNightRate, avail);
								int res = hotelService.addRoomDetails(roomDetails);
								if (res == 1) {
									System.out.println("Room added successfully..");
								} else
									System.out.println("Room not added..");
								break;
							case 2:
								System.out.println("Enter Hotel ID:");
								String hotelId1 = sc.next();
								System.out.println("Enter Room ID:");
								String roomId1 = sc.next();
								int result1 = hotelService.removeRoom(hotelId1, roomId1);
								if (result1 == 1) {
									System.out.println("Room_id " + roomId1 + " has been deleted successfully");
								} else {
									System.out.println("No room_id found to delete..");
								}
								break;
							case 3:
								System.out.println("Enter Hotel ID:");
								String hotelId2 = sc.next();
								System.out.println("Enter Room ID:");
								String roomId2 = sc.next();
								System.out.println("Enter new Tariff:");
								double tariff = sc.nextDouble();
								int result2 = hotelService.modifyRoomTariff(hotelId2, roomId2, tariff);
								if (result2 == 1) {
									System.out.println("Room Tariff Modified...");
								} else {
									System.out.println("Modification not possible...");
								}

								break;
							case 4:
								continue outer;
							case 5:
								System.exit(0);
							default:
								System.out.println("Enter valid choice:");

							}
							break;
						case 3:
							System.out.println("1. View list of hotels");
							System.out.println("2. View bookings of specific hotel");
							System.out.println("3. View guest list of specific hotel");
							System.out.println("4. View bookings for specific date");
							System.out.println("5. Go back to previous menu");
							System.out.println("6. Exit application");
							System.out.println("Enter your choice:");
							int choice = sc.nextInt();
							switch (choice) {
							case 1:
								System.out.println("The list of hotels is as follows:");
								System.out.println();
								System.out.println(hotelService.viewAllHotels());
								break;
							case 2:
								System.out.println("Enter Hotel ID:");
								String hotelId1 = sc.next();
								System.out.println(hotelService.viewBookingsOfHotel(hotelId1));
								break;
							case 3:
								System.out.println("Enter Hotel ID:");
								String hotelId2 = sc.next();
								System.out.println(hotelService.viewGuestList(hotelId2));
								break;
							case 4:
								System.out
										.println("Enter the date for which you want to view the bookings:(DD/MM/YYYY)");
								String date1 = sc.next();
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

								LocalDate enterDate = LocalDate.parse(date1, formatter);

								System.out.println(hotelService.viewBookingsByDate(enterDate));
								break;
							case 5:
								continue outer;
							case 6:
								System.exit(0);
							default:
								System.out.println("Enter valid choice:");
							}
							break;
						case 4:
							System.exit(0);
						default:
							System.out.println("Enter valid choice..");
							loopEnd1 = 9;
							break;
						}
						loopEnd1++;
					} while (loopEnd1 < 10);
					loopEnd2++;
				} while (loopEnd2 < 5);
			}

			else {
				System.out.println("Sorry you have entered Invalid Username/Password");
				System.out.println("Please Try again!!");
			}
			break;
		case 2:
			int choice1;
			int loopEnd3 = 0;
			System.out.println("----- Employee/Customer Access -----");
			outer: do {
				System.out.println("1. Register new user");
				System.out.println("2. Login existing user");
				// System.out.println("3. Search for hotel");
				// System.out.println("4. Go back to previous menu");
				// System.out.println("5. Exit Application");
				System.out.println("Enter your choice:");
				choice1 = sc.nextInt();
				switch (choice1) {
				case 1:
					String role = null, phoneNo1 = null, mobileNo = null, email = null, custPass = null;
					int i = 0;
					System.out.println("Enter desired username:");
					String username = sc.next();
					while (i < 5) {
						System.out.println("Enter desired password(should contain: 8-40 characters,atleast 1 special character[@#$%!&],atleast 1 number,1 uppercase character)");
						custPass = sc.next();
						if (Validations.validatePassword(custPass)) {
							break;
						}
						System.out.println("Entered Password is not valid.");
						System.out.println("Please Enter valid password:");
						i++;
					}

					while (i < 5) {
						System.out.println("Enter role:(Employee/Customer):");
						role = sc.next();
						if (Validations.checkUserRole(role)) {
							break;
						}
						System.out.println("Entered role is not valid.");
						System.out.println("Please Enter valid role:");
						i++;
					}
					while (i < 5) {
						System.out.println("Enter your mobile no(should start with 5-9,total 10 digits):");
						mobileNo = sc.next();
						if (Validations.checkPhoneNumber(mobileNo)) {
							break;
						}
						System.out.println("Entered mobile no is not valid.");
						System.out.println("Please Enter valid Mobile no");
						i++;
					}
					while (i < 5) {
						System.out.println("Enter Phone no(should start with 5-9,total 10 digits):");
						phoneNo1 = sc.next();
						if (Validations.checkPhoneNumber(phoneNo1)) {
							break;
						}
						System.out.println("Entered phone no is not valid.");
						System.out.println("Please Enter valid phone no:");
						i++;
					}
					System.out.println("Enter Address:");
					String address;
					while ((address = buffReader.readLine()).endsWith("\n")) {
					}
					while (i < 5) {
						System.out.println("Enter email(contains:(1) A-Z characters allowed\r\n" + 
								"2) a-z characters allowed\r\n" + 
								"3) 0-9 numbers allowed\r\n" + 
								"4) Additionally email may contain only dot(.), dash(-) and underscore(_)\r\n" + 
								"5) Rest all characters are not allowed):");
						email = sc.next();
						if (Validations.validateEmail(email)) {
							break;
						}
						System.out.println("Entered email is not valid.");
						System.out.println("Please Enter valid email:");
						i++;
					}
					Users newUser = new Users(custPass, role, username, mobileNo, phoneNo1, address, email);
					int res = userService.addUser(newUser);
					if (res == 1) {
						System.out.println("New User added...");
						continue outer;
					} else {
						System.out.println("User not added...");
					}
					break;
				case 2:
					int loopEnd4 = 0;
					System.out.println("Enter username:");
					String custUser = sc.next();
					System.out.println("Enter Password");
					String pass = sc.next();
					int verifyResult = userService.verifyUser(custUser, pass);
					if (verifyResult == 1) {
						System.out.println("YOU ARE WELCOME!");
						outer1: do {
							System.out.println("SEARCH FOR HOTELS");
							System.out.println("1. Enter city where you wish to search for a hotel:");
							System.out.println("2. Enter name of hotel:");
							System.out.println("3. Exit Application");
							System.out.println("Enter your choice");
							int choice3 = sc.nextInt();
							switch (choice3) {
							case 1:
								System.out.println("Enter city name:");
								String hotelCity = sc.next();
								System.out.println(userService.viewHotelsByCity(hotelCity));
								System.out.println("Enter hotelId of hotel you want to book:");
								String hotelId = sc.next();
								System.out.println(userService.viewRoomsByHotelId(hotelId));
								System.out.println("Enter the room ID for your desired room type:");
								String roomId = sc.next();
								System.out.println("Enter your UserId");
								String userId = sc.next();
								System.out.println("Date from:");
								String bookedFrom = sc.next();
								DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								LocalDate entryDate = LocalDate.parse(bookedFrom, formatter1);
								System.out.println("Date to:");
								String bookedTo = sc.next();
								DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								LocalDate exitDate = LocalDate.parse(bookedTo, formatter2);
								System.out.println("Enter no of adults:(Maximum 2 adults in 1 room)");
								int noOfAdults = sc.nextInt();
								System.out.println("Enter no of children(0-5yrs):(Maximum 1 child in 1 room)");
								int noOfChildren = sc.nextInt();
								System.out.println("This will be the total amount of booking:");
								double amount = userService.showTotalAmount(roomId, entryDate, exitDate, noOfAdults);
								System.out.println(amount);
								System.out.println("Do you want to continue with the booking?(Y/N)");
								String option = sc.next();
								if (option.equalsIgnoreCase("y")) {
									int result1 = userService.addBookingDetails(roomId, userId, entryDate, exitDate,
											noOfAdults, noOfChildren, amount);
									if (result1 == 1) {
										System.out.println("Booking confirmed!!");
									} else {
										System.out.println("Booking could not be possible.");
									}
									System.out.println("Your final booking details are:");
									System.out.println(userService.showBookingDetailsByUserId(userId));
								} else {
									continue outer1;
								}
								break;
							case 2:
								System.out.println("Enter hotel name:");
								String hotelName = sc.next();
								userService.viewHotelsByName(hotelName);
								System.out.println("Enter hotelId of hotel you want to book:");
								String hotelId1 = sc.next();
								System.out.println(userService.viewRoomsByHotelId(hotelId1)); // from roomdetails table
								System.out.println("Enter the room ID for your desired room type:");
								String roomId1 = sc.next();
								System.out.println("Enter your UserId");
								String userId1 = sc.next();
								System.out.println("Date from:");
								String bookedFrom1 = sc.next();
								DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								LocalDate entryDate1 = LocalDate.parse(bookedFrom1, formatter3);
								System.out.println("Date to:");
								String bookedTo1 = sc.next();
								DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								LocalDate exitDate1 = LocalDate.parse(bookedTo1, formatter4);
								System.out.println("Enter no of adults:");
								int noOfAdults1 = sc.nextInt();
								System.out.println("Enter no of children:");
								int noOfChildren1 = sc.nextInt();
								System.out.println("This will be the total amount of booking:");
								double amount1 = userService.showTotalAmount(roomId1, entryDate1, exitDate1,
										noOfAdults1);
								System.out.println(amount1);
								System.out.println("Do you want to continue with the booking?(Y/N)");
								String option1 = sc.next();
								if (option1 == "y" || option1 == "Y") {
									int result1 = userService.addBookingDetails(roomId1, userId1, entryDate1, exitDate1,
											noOfAdults1, noOfChildren1, amount1);
									if (result1 == 1) {
										System.out.println("Booking confirmed!!");
									} else {
										System.out.println("Booking could not be possible.");
									}
									System.out.println("Your final booking details are:");
									System.out.println(userService.showBookingDetailsByUserId(userId1));
								} else {
									continue outer1;
								}

								break;
							case 3:
								System.exit(0);
							default:
								System.out.println("Enter valid choice");
							}
						} while (loopEnd4 < 1);

					} else {
						System.out.println("You have not registered; Please Register as a new user");
						continue outer;
					}
					break;
				default:
					System.out.println("Enter valid choice:");
				}

				break;
			} while (loopEnd3 < 1);
		default:
			System.out.println("Enter valid choice:");
		}
	}
}
