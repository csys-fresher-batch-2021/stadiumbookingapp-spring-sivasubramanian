package in.siva.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.siva.model.MatchDetail;
import in.siva.model.Matches;
import in.siva.model.MyBookings;
import in.siva.model.Seats;

@Repository
public interface MatchRepository extends CrudRepository<MatchDetail, Integer> {

	@Query("select stadium_name,match_date,team1,team2,total_seats,upper_seat_price,lower_seat_price from match_details order by match_date asc")
	List<MatchDetail> findAllByOrderByDateAsc();

	@Query("select id,stadium_name,match_date,match_time,team1,team2,upper_seat_price,lower_seat_price,image,available_seats,total_seats from match_details where match_date >= CURRENT_DATE order by match_date asc")
	List<Matches> findByAfterCurrentDate();

	@Query("select m.stadium_name,m.match_date,m.team1,m.team2,b.seat_type, b.no_of_seats,b.booking_date,b.total_amount,b.status,b.id,b.match_id from match_details m,booking_details b where m.id=b.match_id and b.user_id=:userId")
	Iterable<MyBookings> findMyBookings(@Param("userId") int userId);

	@Query("select available_seats,booked_seats,(available_seats*100/total_seats) as percentage from match_details where stadium_name=:stadiumName and match_date=:matchDate")
	Iterable<Seats> findByMatchDateAndStadiumName(@Param("matchDate") LocalDate matchDate,
			@Param("stadiumName") String stadiumName);

	@Modifying
	@Query(value = "CALL BOOK_SEAT(:userId,:matchId,:seatType,:noOfSeats,:totalAmount)")
	void bookSeat(@Param("userId") int userId, @Param("matchId") int matchId, @Param("seatType") String seatType,
			@Param("noOfSeats") int noOfSeats, @Param("totalAmount") int amount);

	@Query("select available_seats from match_details where id=:matchId")
	int getAvailableSeats(@Param("matchId") int matchId);
}
