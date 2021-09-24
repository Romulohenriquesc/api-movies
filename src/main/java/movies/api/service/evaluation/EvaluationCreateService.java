package movies.api.service.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Evaluation;
import movies.api.repository.evaluation.IEvaluationRepository;
import movies.api.service.movie.MovieGetService;

@Service
public class EvaluationCreateService {
	@Autowired
	private IEvaluationRepository evaluationRepository;
	
	public Evaluation create(Evaluation evaluation){
		System.out.println("aqui no service");
		return evaluationRepository.save(evaluation);
	}
}
