package in.siva.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.siva.model.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

//	@Query(value = "CALL BOOK_SEAT(:userId,:matchId,:seatType,:noOfSeats,:totalAmount)")
//	void bookSeat(@Param("userId") int userId, @Param("matchId") int matchId, @Param("seatType") String seatType,
//			@Param("noOfSeats") int noOfSeats, @Param("totalAmount") int amount);
}
