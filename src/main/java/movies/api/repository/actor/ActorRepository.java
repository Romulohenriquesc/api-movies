package movies.api.repository.actor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import movies.api.domain.model.Actor;

@Repository
public class ActorRepository implements IActorRepository {
	@PersistenceContext
	private EntityManager entity;
	
	@Override	
	public List<Actor> find() {
		return entity.createQuery("from Actor", Actor.class).getResultList();
	}
	
	@Transactional
	@Override
	public Actor save(Actor actor) {
		return entity.merge(actor);
	}
	
	@Override
	public Actor getById(Long id) {
		return entity.find(Actor.class, id);
	}
	
	@Transactional
	@Override
	public void remove(Long id) {
		Actor actor = getById(id);
		entity.remove(actor);
	}
}
