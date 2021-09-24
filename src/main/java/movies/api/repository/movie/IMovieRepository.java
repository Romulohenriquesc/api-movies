package movies.api.repository.movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import movies.api.domain.model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long>{
	List<Movie> findByNameContaining(String name);
	List<Movie> findByDirectorContaining(String name);
	List<Movie> findByGenreContaining(String name);
	List<Movie> findByActorsNameContaining(String name);
}
