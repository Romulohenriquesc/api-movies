package movies.api.dto.user.in;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import movies.api.domain.model.User;

@Data
public class UserCreateDtoIn {
	
	@NotBlank
	@NotNull
	private String name;
	
	@NotBlank
	@NotNull
	private String email;
	
	@NotBlank
	@NotNull
	private String password;
	
	@NotBlank
	@NotNull
	private Boolean admin;
	
	public User toUser() {
		return new User(
				null,
				getName(),
				getEmail(),
				getPassword(),
				getAdmin(),
				null
				);
	}
}
