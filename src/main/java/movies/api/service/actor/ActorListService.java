package movies.api.service.actor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Actor;
import movies.api.repository.actor.IActorRepository;

@Service
public class ActorListService {
	@Autowired
	private IActorRepository actorRepository;
	
	public List<Actor> list(){
		return actorRepository.findAll(); 
	}
}
