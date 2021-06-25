package in.siva.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.siva.model.AllBookings;
import in.siva.model.MatchDetail;
import in.siva.model.Matches;
import in.siva.model.MyBookings;
import in.siva.service.AdminService;
import in.siva.service.BookingManager;
import in.siva.service.MatchManager;

@RestController
@RequestMapping("api/v1/match")
public class MatchController {

	@Autowired
	MatchManager matchManager;

	@Autowired
	BookingManager booking;

	@Autowired
	AdminService adminService;

	@GetMapping("/DisplayMatches")
	public List<MatchDetail> getAllMatches() {
		return matchManager.getMatches();
	}

	@GetMapping("/DisplayMyBookings")
	public Iterable<MyBookings> getMyBookings(HttpSession session) {

		Integer userId = (Integer) session.getAttribute("LOGGED_IN_USER_ID");
		System.out.println("userId" + userId);
		return booking.getMyBookings(userId);
	}

	@GetMapping("/DisplayAllBookings")
	public Iterable<AllBookings> getAllBookings() {
		return adminService.getAllBookings();
	}

	@GetMapping("/ViewMatches")
	public List<Matches> viewMatches(HttpSession session) {
		List<Matches> viewMatches = matchManager.getNextMatches();
		session.setAttribute("MATCH_DETAIL", viewMatches);
		return viewMatches;
	}

}
