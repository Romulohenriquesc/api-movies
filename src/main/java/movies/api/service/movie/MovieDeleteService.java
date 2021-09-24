package movies.api.service.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.repository.movie.IMovieRepository;

@Service
public class MovieDeleteService {
	
	@Autowired
	private IMovieRepository movieRepository;
	
	public void remove(Long id){
		movieRepository.deleteById(id);
	}
}
