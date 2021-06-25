package in.siva.service;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.siva.convertor.MatchDetailConvertor;
import in.siva.dao.AdminRepository;
import in.siva.dto.MatchDetailsDTO;
import in.siva.exception.ServiceException;
import in.siva.model.AllBookings;
import in.siva.model.MatchDetail;
import in.siva.validator.AdminValidator;

@Service
public class AdminService {

//	private AdminService() {
//
//	}

	@Autowired
	AdminRepository adminRepo;

	@Autowired
	AdminValidator validate;

	/**
	 * This method is used for admin login
	 * 
	 * @param username
	 * @param password
	 */
	public void checkAdminLogin(String username, String password) {

		try {
			validate.isValidAdmin(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Invalid Login Credentials");
		}
	}

	/**
	 * This method is used for match details by admin
	 * 
	 * @param dto
	 */
	public void addMatchDetails(MatchDetailsDTO dto) {

		MatchDetail matchDetail = MatchDetailConvertor.toMatchDetail(dto);
		adminRepo.save(matchDetail);

	}

	/**
	 * This method is used to get all booked user details.
	 * 
	 * @return
	 * @throws SerialException
	 */
	public Iterable<AllBookings> getAllBookings() throws ServiceException {

		try {
			return adminRepo.findAllBookings();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
