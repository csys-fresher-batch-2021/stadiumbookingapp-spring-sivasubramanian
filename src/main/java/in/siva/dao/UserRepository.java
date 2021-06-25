package in.siva.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.siva.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select id from users where user_name =:username and password =:password")
	public int findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
