package in.siva.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.siva.dao.MatchRepository;
import in.siva.exception.ValidationException;
import in.siva.model.Booking;

@Component
public class BookingValidator {

	private BookingValidator() {

		// Default constructor
	}

	@Autowired
	MatchRepository matchRepo;

	public void isValidBooking(Booking book) {

		// MatchDAO matchDao = new MatchDaoImpl();
		int matchId = book.getMatchId();
		int noOfSeats = book.getNoOfSeats();
		int availableSeats = 0;
		availableSeats = matchRepo.getAvailableSeats(matchId);
		int totalAmount = book.getTotalAmount();
		String seatType = book.getSeatType();
		if (!InputValidator.isValidString(seatType)) {
			throw new ValidationException("Choose seat type");
		}
		if (!InputValidator.isValidNumber(noOfSeats) || !InputValidator.isValidNumber(totalAmount)) {
			throw new ValidationException("Invalid input");
		}
		if (noOfSeats > availableSeats) {
			throw new ValidationException("Only " + availableSeats + " seats are available");
		}

	}

	public static void isvalidcancelling(int matchId, int bookingId, int noOfTickets) {

		if (!InputValidator.isValidNumber(noOfTickets) && !InputValidator.isValidNumber(bookingId)
				&& InputValidator.isValidNumber(matchId)) {
			throw new ValidationException("Invalid input");
		}
	}

}
