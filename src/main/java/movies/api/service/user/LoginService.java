package movies.api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import movies.api.configurations.models.AuthenticationRequest;
import movies.api.domain.model.User;
import movies.api.dto.login.in.LoginDtoIn;
import movies.api.repository.user.IUserRepository;

@Service
public class LoginService {	
	@Autowired
	private IUserRepository userRepository;
	
	public Boolean login(AuthenticationRequest request){
		User user = userRepository.findByEmail(request.getUsername());
		
		return new BCryptPasswordEncoder().matches(request.getPassword(), user.getPassword());

	}
}
