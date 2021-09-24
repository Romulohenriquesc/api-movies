package movies.api.dto.evaluation.in;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import movies.api.domain.model.Evaluation;
import movies.api.domain.model.Movie;
import movies.api.domain.model.User;

@Data
public class EvaluationCreateDtoIn {
	
	@NotBlank
	@NotNull
	private Movie movie;
	
	@NotBlank
	@NotNull
	private User user;
	
	@NotBlank
	@NotNull
	@Min(0)
	@Max(4)
	private Integer grade;
	
	public Evaluation toEvaluation() {
		return new Evaluation(
				null,
				getUser(),
				getMovie(),
				getGrade()
				);
	}
}
