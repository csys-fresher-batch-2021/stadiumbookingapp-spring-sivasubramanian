package in.siva.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.siva.dto.LoginDTO;
import in.siva.dto.MessageDTO;
import in.siva.dto.UserDTO;
import in.siva.exception.ServiceException;
import in.siva.exception.ValidationException;
import in.siva.service.UserManager;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	@Autowired
	UserManager userManager;

	@PostMapping(path = "/register")
	public ResponseEntity<Object> register(@RequestBody UserDTO dto) {
		try {

			boolean result = userManager.register(dto);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (ServiceException e) {
			MessageDTO message = new MessageDTO();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping(path = "/Login")
	public ResponseEntity<Object> login(@RequestBody LoginDTO dto, HttpSession session) {
		int userId;
		try {
			userId = userManager.login(dto.getUsername(), dto.getPassword());
			session.setAttribute("LOGGED_IN_USER", dto.getUsername());
			session.setAttribute("LOGGED_IN_USER_ID", userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ValidationException | ServiceException e) {
			MessageDTO message = new MessageDTO();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

}
