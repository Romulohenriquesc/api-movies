package movies.api.dto.user.in;

import lombok.Data;
import movies.api.domain.model.User;

@Data
public class UserUpdateDtoIn {
	private Long id;
	private String name;
	private String email;
	private Boolean admin;
	private Boolean enabled;
	
	public User toUser() {
		return new User(
				getId(),
				getName(),
				getEmail(),
				null,
				getAdmin(),
				getEnabled()
				);
	}
}
