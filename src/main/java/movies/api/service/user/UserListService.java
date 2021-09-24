package movies.api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import movies.api.domain.model.User;
import movies.api.repository.user.IUserRepository;

@Service
public class UserListService {
	@Autowired
	private IUserRepository userRepository;

	public Page<User> listOrderName(String order, int take, int page){
		Pageable pageable = PageRequest.of(page, take);
		
		if("ASC".equalsIgnoreCase(order)) {
			return userRepository.findAllByAdminFalseAndEnabledTrueOrderByName(pageable); 			
		}else if("DESC".equalsIgnoreCase(order)) {
			return userRepository.findAllByAdminFalseAndEnabledTrueOrderByNameDesc(pageable);
		}else {
			return userRepository.findAllByAdminFalseAndEnabledTrue(pageable);
		}
	}
}
