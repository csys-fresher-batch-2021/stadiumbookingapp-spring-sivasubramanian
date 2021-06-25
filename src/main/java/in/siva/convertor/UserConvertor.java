package in.siva.convertor;

import in.siva.dto.UserDTO;
import in.siva.model.User;

public class UserConvertor {

	private UserConvertor() {

	}

	public static User toUser(UserDTO dto) {
		User user=new User();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setMobileNo(dto.getMobileNo());
		return user;
		
	}
}
