package movies.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movies.api.domain.model.Actor;
import movies.api.service.actor.ActorCreateService;
import movies.api.service.actor.ActorDeleteService;
import movies.api.service.actor.ActorGetService;
import movies.api.service.actor.ActorListService;
import movies.api.service.actor.ActorUpdateService;

@RestController
@RequestMapping("/actors")
public class ActorController {
	@Autowired
	private ActorListService actorListService;
	
	@Autowired
	private ActorGetService actorGetService;
	
	@Autowired
	private ActorCreateService actorCreateService;
	
	@Autowired
	private ActorDeleteService actorDeleteService;
	
	@Autowired
	private ActorUpdateService actorUpdateService;
	
	@GetMapping
	public ResponseEntity<List<Actor>> list(){
		List<Actor> actor = actorListService.list()
				.stream()
				.collect(Collectors.toList());
		return ResponseEntity.ok(actor);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Actor> getById(@PathVariable Long id){
		return ResponseEntity.ok(actorGetService.getById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		actorDeleteService.remove(id);
		return ResponseEntity.noContent().build();		
	}
	
	@PostMapping
	public ResponseEntity<Actor> create(@RequestBody Actor actor) {
		return ResponseEntity.ok(actorCreateService.create(actor));
	}
	
	@PatchMapping
	public ResponseEntity<Actor> update(@RequestBody Actor actor) {
		return ResponseEntity.ok(actorUpdateService.update(actor));
	}
}
