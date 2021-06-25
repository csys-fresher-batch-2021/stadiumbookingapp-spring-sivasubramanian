package in.siva.model;


import javax.persistence.GeneratedValue;


import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;


@Data
@Table(value="users")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column("user_name") 
	private String username;
	private String password;
	@Column("mobile_number")
	private Long mobileNo;

	

}
