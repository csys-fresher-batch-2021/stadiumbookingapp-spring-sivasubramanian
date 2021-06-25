package in.siva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.siva.dto.SeatsDTO;
import in.siva.model.Seats;
import in.siva.service.SeatManager;

@RestController
@RequestMapping("api/v1/seats")
public class SeatController {

	@Autowired
	SeatManager seatManager;

	@PostMapping(path = "/getAvailability")
	public Iterable<Seats> getAvailability(@RequestBody SeatsDTO dto) {
		return seatManager.getAvailableSeats(dto.getMatchDate(), dto.getStadiumName());
	}

}
