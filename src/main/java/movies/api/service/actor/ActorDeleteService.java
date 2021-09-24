package movies.api.service.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.repository.actor.IActorRepository;

@Service
public class ActorDeleteService {
	@Autowired
	private IActorRepository actorRepository;
	
	public void remove(Long id){
		actorRepository.remove(id);
	}
}
