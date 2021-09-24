package movies.api.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.User;
import movies.api.repository.user.IUserRepository;

@Service
public class UserDeleteService {
	@Autowired
	private IUserRepository userRepository;
	
	public void remove(Long id){
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			user.get().setEnabled(false);;
			userRepository.save(user.get());
		}
	}
}
