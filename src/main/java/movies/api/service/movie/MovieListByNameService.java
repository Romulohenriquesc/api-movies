package movies.api.service.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Movie;
import movies.api.repository.movie.IMovieRepository;

@Service
public class MovieListByNameService {
	
	@Autowired
	private IMovieRepository movieRepository;
	
	public List<Movie> listByName(String name){
		List<Movie> movies = movieRepository.findByNameContaining(name);
		if(!movies.isEmpty()) {
			return movies;
		}
		movies = movieRepository.findByActorsNameContaining(name);
		if(!movies.isEmpty()) {
			return movies;
		}
		movies = movieRepository.findByDirectorContaining(name);
		if(!movies.isEmpty()) {
			return movies;
		}
		movies = movieRepository.findByGenreContaining(name);
		
		return movies;
	}
}
