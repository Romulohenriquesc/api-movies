package movies.api.repository.actor;

import java.util.List;

import movies.api.domain.model.Actor;

public interface IActorRepository {

	List<Actor> find();
	Actor getById(Long id);
	Actor save(Actor actor);
	void remove(Long id);
}
