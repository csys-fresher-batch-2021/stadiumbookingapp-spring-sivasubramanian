package in.siva.dto;

import lombok.Data;

@Data
public class BookingDTO {

	private int userId;
	private int matchId;
	private String seatType;
	private int tickets;
	private int totalAmount;

}
