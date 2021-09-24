package movies.api.dto.evaluation.out;

import lombok.Data;
import movies.api.domain.model.Evaluation;
import movies.api.domain.model.Movie;
import movies.api.dto.user.out.UserDtoOut;

@Data
public class EvaluationDtoOut {
	private Movie movie;
	private UserDtoOut user;
	private Integer grade;
	
	public EvaluationDtoOut(Evaluation evaluation) {
		setMovie(evaluation.getMovie());
		UserDtoOut user = new UserDtoOut(evaluation.getUser());
		setUser(user);
		setGrade(evaluation.getGrade());
	}
}
