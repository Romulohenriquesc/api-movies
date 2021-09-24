package movies.api.repository.evaluation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import movies.api.domain.model.Evaluation;

@Repository
public interface IEvaluationRepository extends JpaRepository<Evaluation, Long>, JpaSpecificationExecutor<Evaluation>{
	List<Evaluation> findByMovieId(Long id);
	
	@Query("SELECT AVG(grade) FROM Evaluation e WHERE movie_id = :id")
	Double findEvaluationAvg(Long id);
}
