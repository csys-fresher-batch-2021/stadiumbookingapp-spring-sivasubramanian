package in.siva.model;

import java.time.LocalDate;

import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MyBookings {

	private int bookingId;
	private int matchId;
	private String stadiumName;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate matchDate;
	@Column("team1")
	private String teamOne;
	@Column("team2")
	private String teamTwo;
	private String seatType;
	private int noOfSeats;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate bookingDate;
	private int totalAmount;
	private String status;

}
