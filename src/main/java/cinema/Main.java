package cinema;

import cinema.lib.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance("cinema");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movie.setDescription("Vin Diesel teaches everyone how to live by "
                + "saying some bulls**t lines, + cars explode everywhere");
        MovieService movieService = (MovieService)
                injector.getInstance(MovieService.class);
        movieService.add(movie);
        movie.setTitle("Big Lebowski");
        movie.setDescription("Lebowski teaches everyone how to live without saying it"
                + " - not like Vin Diesel");
        movieService.add(movie);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(10);

        CinemaHallService cinemaHallService = (CinemaHallService)
                injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(cinemaHall);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setDate(LocalDateTime.of(2020,2,1, 20,00));
        MovieSessionService movieSessionService = (MovieSessionService)
                injector.getInstance(MovieSessionService.class);
        movieSessionService.add(movieSession);

        System.out.println(movieSessionService
                .findAvailableSessions(movie.getId(), LocalDate.now()));
    }
}
