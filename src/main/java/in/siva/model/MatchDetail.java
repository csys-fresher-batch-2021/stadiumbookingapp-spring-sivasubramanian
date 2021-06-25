package in.siva.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Table(value="match_details")
@JsonInclude(Include.NON_NULL)
public class MatchDetail {

	public MatchDetail() {
		super();
	}

	@Column("id") @Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int matchId;
	@Column("stadium_name")
	private String stadiumName;
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column("match_date")
	private LocalDate matchDate;
	@Column("team1")
	private String teamOne;
	@Column("team2")
	private String teamTwo;
	@Column("total_seats")
	private int totalSeats;
	@Column("available_seats")
	private int availableSeats;
	@Column("booked_seats") @GeneratedValue(strategy = GenerationType.AUTO)
	private int bookedSeats;
	@Column("upper_seat_price")
	private int upperSeatPrice;
	@Column("lower_seat_price")
	private int lowerSeatPrice;
	private String image;
	//private boolean bookable;
	@Column("match_time")
	private LocalTime matchTime;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String reason;
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

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}

	public void setTeamOne(String team1) {
		this.teamOne = team1;
	}

	public void setTeamTwo(String team2) {
		this.teamTwo = team2;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public void setUpperSeatPrice(int upperseatPrice) {
		this.upperSeatPrice = upperseatPrice;
	}

	public void setLowerSeatPrice(int lowerSeatPrice) {
		this.lowerSeatPrice = lowerSeatPrice;
	}
//
//	public boolean isBookable() {
//		return bookable;
//	}
//
//	public void setBookable(LocalDate matchDate) {
//		this.bookable = matchDate.isAfter(LocalDate.now());
//	}
}
