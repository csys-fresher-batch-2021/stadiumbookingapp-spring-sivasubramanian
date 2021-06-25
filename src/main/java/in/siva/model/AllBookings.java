package in.siva.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AllBookings {

	@Column("user_name")
	private String username;
	private String seatType;
	private String stadiumName;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate matchDate;
	@Column("team1")
	private String teamOne;
	@Column("team2")
	private String teamTwo;
	@Column("no_of_seats")
	private int noOfTickets;
	private String status;
	@Column("match_id")
	private int matchId;
	@JsonFormat(pattern = "HH-mm")
	private LocalTime matchTime;
	@Column("id")
	private int bookingId;

	public LocalTime getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(LocalTime matchTime) {
		this.matchTime = matchTime;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getUsername() {
		return username;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public LocalDate getMatchDate() {
		return matchDate;
	}

	public String getTeamOne() {
		return teamOne;
	}

	public String getTeamTwo() {
		return teamTwo;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public String getStatus() {
		return status;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}

	public void setTeamOne(String team1) {
		this.teamOne = team1;
	}

	public void setTeamTwo(String team2) {
		this.teamTwo = team2;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

}
