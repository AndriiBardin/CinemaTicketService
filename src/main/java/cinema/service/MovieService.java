package cinema.service;

import cinema.model.movie.Movie;
import java.util.List;

public interface MovieService {

    Movie add(Movie movie);

    List<Movie> getAll();
}
