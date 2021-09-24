package movies.api.service.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Actor;
import movies.api.repository.actor.IActorRepository;

@Service
public class ActorGetService {
	@Autowired
	private IActorRepository actorRepository;
	
	public Actor getById(Long id){
		return actorRepository.getById(id); 
	}
}
