package movies.api.service.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.api.domain.model.Evaluation;
import movies.api.repository.evaluation.IEvaluationRepository;

@Service
public class EvaluationCreateService {
	@Autowired
	private IEvaluationRepository evaluationRepository;
	
	public Evaluation create(Evaluation evaluation){
		return evaluationRepository.save(evaluation);
	}
}
