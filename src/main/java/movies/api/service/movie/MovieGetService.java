package movies.api.service.movie;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Movie;
import movies.api.repository.evaluation.IEvaluationRepository;
import movies.api.repository.movie.IMovieRepository;

@Service
public class MovieGetService {
	@Autowired
	private IMovieRepository movieRepository;
	
	@Autowired
	private IEvaluationRepository evaluationRepository;
	
	public Movie getById(Long id){

		Optional<Movie> movie = movieRepository.findById(id);

		Double evaluation = evaluationRepository.findEvaluationAvg(id);

		if(movie.isPresent()) {
			movie.get().setEvaluation(evaluation);
			return movie.get();			
		}
		return null;
	}
}
