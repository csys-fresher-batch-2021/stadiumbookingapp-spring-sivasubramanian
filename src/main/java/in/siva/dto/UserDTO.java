package in.siva.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	@NotNull @NotEmpty @Min(value=3,message="Invalid user name or password")
	private String username;
	
	@NotNull @NotEmpty @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=\\\\S+$).{8,20}$")
	private String password;
	
	@NotNull @NotEmpty @Pattern(regexp = "[6-9][0-9]{9}")
	private Long mobileNo;


}
