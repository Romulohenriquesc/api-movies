package movies.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movies.api.dto.evaluation.in.EvaluationCreateDtoIn;
import movies.api.dto.evaluation.out.EvaluationDtoOut;
import movies.api.service.evaluation.EvaluationCreateService;
import movies.api.service.evaluation.EvaluationListService;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {
	
	@Autowired
	private EvaluationCreateService evaluationCreateService;
	
	@Autowired
	private EvaluationListService evaluationListService;
	
	@PostMapping
	public ResponseEntity<EvaluationDtoOut> create(@RequestBody EvaluationCreateDtoIn evaluation) {
		EvaluationDtoOut evaluationOut = new EvaluationDtoOut(
					evaluationCreateService.create(evaluation.toEvaluation())
				);
		return ResponseEntity.ok(evaluationOut);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<EvaluationDtoOut>> getById(@PathVariable Long id){
		List<EvaluationDtoOut> evaluation = evaluationListService.getById(id)
				.stream()
				.map(EvaluationDtoOut::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(evaluation);
	}
}
