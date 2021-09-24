package movies.api.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import movies.api.domain.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
	User findByEmail(String name);
	Page<User> findAllByAdminFalseAndEnabledTrue(Pageable pageable);
	Page<User> findAllByAdminFalseAndEnabledTrueOrderByName(Pageable pageable);
	Page<User> findAllByAdminFalseAndEnabledTrueOrderByNameDesc(Pageable pageable);
}
