package in.siva.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.siva.convertor.BookingConvertor;
import in.siva.dao.MatchRepository;
import in.siva.dto.BookingDTO;
import in.siva.exception.ServiceException;
import in.siva.model.Booking;
import in.siva.model.MyBookings;
import in.siva.validator.BookingValidator;

@Service
public class BookingManager {

	private BookingManager() {

	}

	@Autowired
	MatchRepository matchRepo;

	@Autowired
	BookingValidator validate;

	public void bookSeat1(BookingDTO dto) {
		Booking bookSeat = BookingConvertor.toBooking(dto);
		try {
			validate.isValidBooking(bookSeat);
			int userId = bookSeat.getUserId();
			int matchId = bookSeat.getMatchId();
			String seatType = bookSeat.getSeatType();
			int noOfSeats = bookSeat.getNoOfSeats();
			int totalAmount = bookSeat.getTotalAmount();
			matchRepo.bookSeat(userId, matchId, seatType, noOfSeats, totalAmount);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This method is used for get my bookings.
	 * 
	 * @param userId
	 * @return
	 */
	public Iterable<MyBookings> getMyBookings(int userId) {
		Iterable<MyBookings> myBookingList = new ArrayList<>();
		try {
			myBookingList = matchRepo.findMyBookings(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return myBookingList;
	}

}
