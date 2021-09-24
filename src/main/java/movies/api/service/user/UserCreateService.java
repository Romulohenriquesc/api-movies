package movies.api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import movies.api.domain.model.User;
import movies.api.repository.user.IUserRepository;

@Service
public class UserCreateService {
	@Autowired
	private IUserRepository userRepository;
	
	public User create(User user){
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userRepository.save(user);
	}
	
}
