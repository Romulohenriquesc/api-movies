package movies.api.service.user;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.User;
import movies.api.repository.user.IUserRepository;

@Service
public class UserUpdateService {
	@Autowired
	private IUserRepository userRepository;
	
	public User update(User user, Long id){
		Optional<User> userToUpdate = userRepository.findById(id);
		user.setPassword(userToUpdate.get().getPassword());
		if(userToUpdate.isPresent()) {
			BeanUtils.copyProperties(user, userToUpdate.get(), "id");
			
			User userUpdated = userRepository.save(userToUpdate.get());
			return userUpdated;			
		}
		return null;
	}
}
