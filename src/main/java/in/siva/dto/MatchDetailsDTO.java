package in.siva.dto;

import java.time.LocalDate;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.ToString;

@ToString
public class MatchDetailsDTO {

	private String stadiumName;
	public String getStadiumName() {
		return stadiumName;
	}
	public LocalDate getMatchDate() {
		return matchDate;
	}
	public LocalTime getMatchTime() {
		return matchTime;
	}
	public String getTeam1() {
		return team1;
	}
	public String getTeam2() {
		return team2;
	}
	public String getImage() {
		return image;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public int getUpperSeatPrice() {
		return upperSeatPrice;
	}
	public int getLowerSeatPrice() {
		return lowerSeatPrice;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}
	@DateTimeFormat(pattern = "HH:mm")
	public void setMatchTime(LocalTime matchTime) {
		this.matchTime = matchTime;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public void setUpperSeatPrice(int upperSeatPrice) {
		this.upperSeatPrice = upperSeatPrice;
	}
	public void setLowerSeatPrice(int lowerSeatPrice) {
		this.lowerSeatPrice = lowerSeatPrice;
	}
	private LocalDate matchDate;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime matchTime;
	private String team1;
	private String team2;
	private String image;
	private int totalSeats;
	private int availableSeats;
	private int upperSeatPrice;
	private int lowerSeatPrice;
	private boolean bookable;
	public boolean isBookable() {
		return bookable;
	}
	public void setBookable(LocalDate matchDate ) {
		this.bookable = matchDate.isAfter(LocalDate.now());
	}
	
	
}
