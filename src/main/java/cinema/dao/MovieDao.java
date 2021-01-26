package cinema.dao;

import cinema.exception.DataBaseException;
import cinema.model.movie.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie) throws DataBaseException;

    List<Movie> getAll();
}
