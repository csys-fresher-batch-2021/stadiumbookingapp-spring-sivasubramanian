package in.siva.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.siva.dto.MatchDetailsDTO;
import in.siva.service.AdminService;

@Controller
@RequestMapping
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/addMatches")
	public String addMatches(MatchDetailsDTO dto) {
		try {
			adminService.addMatchDetails(dto);
			return "redirect:addMatch.jsp?infoMessage=Successfully Added";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "redirect:addMatch.jsp?errorMessage=" + e.getMessage();
		}
	}

	@PostMapping("/adminLogin")
	public String adminLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {
		System.out.println("un" + username + "" + password);
		session.setAttribute("LOGGED_IN_USER", username);
		adminService.checkAdminLogin(username, password);
		return "addMatch.jsp";
	}
}
