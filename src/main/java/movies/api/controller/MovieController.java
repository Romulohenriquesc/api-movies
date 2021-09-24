package movies.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import movies.api.domain.model.Movie;
import movies.api.service.movie.MovieCreateService;
import movies.api.service.movie.MovieDeleteService;
import movies.api.service.movie.MovieGetService;
import movies.api.service.movie.MovieListByNameService;
import movies.api.service.movie.MovieListByRateService;
import movies.api.service.movie.MovieListService;
import movies.api.service.movie.MovieUpdateService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieListService movieListService;
	
	@Autowired
	private MovieListByNameService movieListByNameService;
	
	@Autowired
	private MovieGetService movieGetService;
	
	@Autowired
	private MovieCreateService movieCreateService;
	
	@Autowired
	private MovieDeleteService movieDeleteService;
	
	@Autowired
	private MovieUpdateService movieUpdateService;
	
	@Autowired
	private MovieListByRateService movieListByRateService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> list(@RequestParam(required = false) Integer take, Integer page){
		if(take == null) {
			take = 20;
		}
		if(page == null) {
			page = 0;
		}
		List<Movie> movie = movieListService.list(take, page)
				.stream()
				.collect(Collectors.toList());
		return ResponseEntity.ok(movie);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Movie>> listByName(@RequestParam String search){
		List<Movie> movie = movieListByNameService.listByName(search)
				.stream()
				.collect(Collectors.toList());
		return ResponseEntity.ok(movie);
	}
	
	@GetMapping("/rate")
	public ResponseEntity<List<Movie>> listByRate(){
		List<Movie> movie = movieListByRateService.listByRate()
				.stream()
				.collect(Collectors.toList());
		return ResponseEntity.ok(movie);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getById(@PathVariable Long id){
		return ResponseEntity.ok(movieGetService.getById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		movieDeleteService.remove(id);
		return ResponseEntity.noContent().build();		
	}
	
	@PostMapping
	public ResponseEntity<Movie> create(@RequestBody Movie movie) {
		return ResponseEntity.ok(movieCreateService.create(movie));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie) {
		return ResponseEntity.ok(movieUpdateService.update(movie, id));
	}
}