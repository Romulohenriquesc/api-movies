package movies.api.service.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Movie;
import movies.api.repository.movie.IMovieRepository;

@Service
public class MovieListByRateService {
	
	@Autowired
	private IMovieRepository movieRepository;
	
	public List<Movie> listByRate(){
		//List<Movie> movies = movieRepository.finByBestRated();
		return null;
	}
}
