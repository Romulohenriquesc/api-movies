package movies.api.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.User;
import movies.api.repository.user.IUserRepository;

@Service
public class UserGetService {
	@Autowired
	private IUserRepository userRepository;

	public User getById(Long id){
		
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return user.get();			
		}
		return null;
	}
	public User getByUsername(String email){
		
		return userRepository.findByEmail(email);
	}
}
