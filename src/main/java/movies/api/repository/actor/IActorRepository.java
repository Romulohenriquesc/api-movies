package movies.api.repository.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import movies.api.domain.model.Actor;
import movies.api.domain.model.Evaluation;

public interface IActorRepository extends JpaRepository<Actor, Long>, JpaSpecificationExecutor<Evaluation>{
}
