package movies.api.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Movie;
import movies.api.repository.movie.IMovieRepository;

@Service
public class MovieListService {
	
	@Autowired
	private IMovieRepository movieRepository;
	
	public Page<Movie> list(int take, int page){
		Pageable pageable = PageRequest.of(page, take);

		return movieRepository.findAll(pageable); 
	}
}
