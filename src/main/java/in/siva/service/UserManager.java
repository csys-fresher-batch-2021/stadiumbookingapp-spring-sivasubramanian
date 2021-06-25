package in.siva.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.siva.convertor.UserConvertor;
import in.siva.dao.UserRepository;
import in.siva.dto.UserDTO;
import in.siva.exception.DbException;
import in.siva.exception.ServiceException;
import in.siva.exception.ValidationException;
import in.siva.model.User;
import in.siva.validator.UserManagerValidator;

@Service
public class UserManager {

	private UserManager() {
		// Default Constructor
	}

	@Autowired
	private UserRepository userRepo;

	/**
	 * This method is used for login.
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws DbException
	 */
	public int login(String username, String password) throws ValidationException {

		int userId;
		try {
//			UserDAO userDao=new UserDaoImpl();
			UserManagerValidator.isValidLogin(username, password);
//			userId= userDao.isExistsUsernameAndPassword(username, password);
			userId = userRepo.findByUsernameAndPassword(username, password);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return userId;

	}

	/**
	 * This method is used for register.
	 * 
	 * @param dto
	 * @return
	 * @throws DbException
	 * @throws SQLException
	 */
	public boolean register(UserDTO dto) throws ServiceException {
		boolean isRegistered = false;
		User user = UserConvertor.toUser(dto);
		try {
			if (UserManagerValidator.isValidRegistration(user)) {
				userRepo.save(user);
				isRegistered = true;
			} else {
				throw new ValidationException("Invalid Details!");
			}
		} catch (Exception e) {
			throw new ServiceException("Unable to register!");
		}
		return isRegistered;
	}

}
