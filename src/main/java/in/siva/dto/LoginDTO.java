package in.siva.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginDTO {

	private String username;
	
	private String password;
}
