package in.siva.validator;

import in.siva.exception.ValidationException;
import in.siva.model.User;

public class UserManagerValidator {

	private UserManagerValidator() {
		// Default constructor
	}

	public static void isValidLogin( String username, String password) {
		
		if (!UserValidator.isValidUserName(username) || !UserValidator.isValidPassword(password)) {
			throw new ValidationException("Invalid username or password");
		}
	}

	public static boolean isValidRegistration(User user1) {
		String username = user1.getUsername();
		String password = user1.getPassword();
		String mobileNo = user1.getMobileNo().toString();

		return UserValidator.isValidUserName(username) && UserValidator.isValidPassword(password)
				&& UserValidator.isValidMobileNumber(mobileNo);
	}
}
