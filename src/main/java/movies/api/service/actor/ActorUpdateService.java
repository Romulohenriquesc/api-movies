package movies.api.service.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Actor;
import movies.api.repository.actor.IActorRepository;

@Service
public class ActorUpdateService {

	@Autowired
	private IActorRepository actorRepository;
	
	public Actor update(Actor actor){
		return actorRepository.save(actor);
	}
}
