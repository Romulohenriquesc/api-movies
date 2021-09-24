package movies.api.service.movie;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Movie;
import movies.api.repository.movie.IMovieRepository;

@Service
public class MovieUpdateService {

	@Autowired
	private IMovieRepository movieRepository;
	
	public Movie update(Movie movie, Long id){
		Optional<Movie> movieToUpdate = movieRepository.findById(id);
		if(movieToUpdate.isPresent()) {
			BeanUtils.copyProperties(movie, movieToUpdate.get(), "id");
			Movie movieUpdated = movieRepository.save(movieToUpdate.get());
			return movieUpdated;			
		}
		return null;
	}
}