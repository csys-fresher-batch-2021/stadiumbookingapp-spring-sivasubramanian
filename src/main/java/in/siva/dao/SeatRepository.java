package in.siva.dao;

import java.time.LocalDate;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.siva.model.Seats;

@Repository
public interface SeatRepository extends CrudRepository<Seats, Integer> {

	@Query("select available_seats,booked_seats,(available_seats*100/total_seats) as percentage from match_details where stadium_name=:stadiumName and match_date=:matchDate")
	Iterable<Seats> findByMatchDateAndStadiumName(@Param("matchDate") LocalDate matchDate,
			@Param("stadiumName") String stadiumName);
}
