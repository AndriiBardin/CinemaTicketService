package cinema.dao;

import cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao {
    MovieSession add(MovieSession session);

    List<MovieSession> getAvailable(Long movieId, LocalDate date);
}
