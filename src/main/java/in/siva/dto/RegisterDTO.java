package in.siva.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterDTO {

	private Long mobileNo;
	
	private String password;
}
