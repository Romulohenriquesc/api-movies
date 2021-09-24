package movies.api.service.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Actor;
import movies.api.repository.actor.IActorRepository;

@Service
public class ActorCreateService {
	@Autowired
	private IActorRepository actorRepository;
	
	public Actor create(Actor actor){
		return actorRepository.save(actor);
	}
}
