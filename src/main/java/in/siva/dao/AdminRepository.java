package in.siva.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.siva.model.AllBookings;
import in.siva.model.MatchDetail;

@Repository
public interface AdminRepository extends CrudRepository<MatchDetail, Integer> {

	@Query("select u.user_name,m.stadium_name,m.match_date,m.match_time,m.team1,m.team2,b.match_id,b.seat_type, b.no_of_seats,b.status,b.id from users u,match_details m,booking_details b where m.id=b.match_id and u.id=b.user_id")
	Iterable<AllBookings> findAllBookings();

}
