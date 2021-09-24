package movies.api.service.evaluation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Evaluation;
import movies.api.repository.evaluation.IEvaluationRepository;

@Service
public class EvaluationListService {
	@Autowired
	private IEvaluationRepository evaluationRepository;
	
	public List<Evaluation> getById(Long id){
		System.out.println(evaluationRepository.findEvaluationAvg(id));
		return evaluationRepository.findByMovieId(id); 
	}
}
