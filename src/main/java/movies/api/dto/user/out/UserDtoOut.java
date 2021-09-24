package movies.api.dto.user.out;

import lombok.Data;
import movies.api.domain.model.User;

@Data
public class UserDtoOut {
	private Long id;
	private String name;
	private String email;
	private Boolean admin;
	private Boolean enabled;
	
	public UserDtoOut(User user) {
		setId(user.getId());
		setName(user.getName());
		setEmail(user.getEmail());
		setAdmin(user.getAdmin());
		setEnabled(user.getEnabled());
	}
}

	