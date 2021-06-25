package in.siva.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.siva.dao.MatchRepository;
import in.siva.model.Seats;

@Service
public class SeatManager {

	@Autowired
	private MatchRepository seatRepo;

	public Iterable<Seats> getAvailableSeats(LocalDate matchDate, String stadiumName) {
		Iterable<Seats> seatsDetail = null;
		try {
			seatsDetail = seatRepo.findByMatchDateAndStadiumName(matchDate, stadiumName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return seatsDetail;
	}

}
