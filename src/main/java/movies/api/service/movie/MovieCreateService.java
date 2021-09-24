package movies.api.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Movie;
import movies.api.repository.movie.IMovieRepository;

@Service
public class MovieCreateService {
	
	@Autowired
	private IMovieRepository movieRepository;
	
	public Movie create(Movie movie){
		return movieRepository.save(movie);
	}
}
