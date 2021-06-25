package in.siva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.siva.dao.MatchRepository;
import in.siva.exception.ServiceException;
import in.siva.model.MatchDetail;
import in.siva.model.Matches;

@Service
public class MatchManager {

	private MatchManager() {
		// Default Constructor
	}

	@Autowired
	MatchRepository matchRepo;

	/**
	 * This method is used for get matches
	 * 
	 * @param dto
	 * @return
	 */

	public List<MatchDetail> getMatches() {

		try {
			return matchRepo.findAllByOrderByDateAsc();
		} catch (Exception e) {
			throw new ServiceException("Unable to get matches");
		}

	}

	/**
	 * This method is used for get matches after current date
	 * 
	 * @param dto
	 * @return
	 */
	public List<Matches> getNextMatches() {

		try {
			return matchRepo.findByAfterCurrentDate();
		} catch (Exception e) {
			throw new ServiceException("Unable to display");
		}

	}

}
