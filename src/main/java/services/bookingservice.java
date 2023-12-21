package services;

import java.util.List;

import entities.bookingentities;

public interface bookingservice {
	
	bookingentities bookRoom(bookingentities bookingInfo);

	    List<bookingentities> getAllBookings();

	    bookingentities getBookingById(Long bookingId);

	    bookingentities updateBooking(Long bookingId, bookingentities bookingInfo);

	    void cancelBooking(Long bookingId);

	    List<bookingentities> getAllBookingsByUserId(Long userId);

}
