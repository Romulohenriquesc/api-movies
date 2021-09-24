package movies.api.repository.movie;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import movies.api.domain.model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long>{
	List<Movie> findByNameContaining(String name);
	List<Movie> findByDirectorContaining(String name);
	List<Movie> findByGenreContaining(String name);
	List<Movie> findByActorsNameContaining(String name);
	
	//@Query("SELECT AVG(grade) FROM Evaluation e WHERE movie_id = :id")
	
	/*@Query("FROM Movie ORDER BY (SELECT AVG(grade) FROM Evaluation) DESC")
	List<Movie> finByBestRated();*/
		
	//@Query("Evaluation e WHERE movie_id = :id")
	//List<Movie> findEvaluationAvg(Long id);
}
