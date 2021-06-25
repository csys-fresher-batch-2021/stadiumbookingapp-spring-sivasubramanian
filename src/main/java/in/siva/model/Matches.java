package in.siva.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Matches {

	private int id;
	private String stadiumName;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate matchDate;
	private LocalTime matchTime;
	@Column("team1")
	private String teamOne;
	@Column("team2")
	private String teamTwo;
	private int upperSeatPrice;
	private int lowerSeatPrice;
	private String image;
	private int availableSeats;
	private int totalSeats;
}
