package in.siva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.siva.dto.BookingDTO;
import in.siva.service.BookingManager;

@RestController
@RequestMapping("api/v1/booking")
public class BookingController {

	@Autowired
	BookingManager booking;

	@PostMapping(path = "/bookSeat")
	public ResponseEntity<?> bookSeat(@RequestBody BookingDTO dto) {

		try {
			booking.bookSeat1(dto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
