package movies.api.dto.login.in;

import lombok.Data;

@Data
public class LoginDtoIn {
	private String email;
	private String password;
}
