package cinema;

import cinema.lib.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.User;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import cinema.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance("cinema");

    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.setTitle("Fast and Furious");
        movie1.setDescription("Vin Diesel teaches everyone how to live by "
                + "saying some bulls**t lines, + cars explode everywhere");
        MovieService movieService = (MovieService)
                injector.getInstance(MovieService.class);
        movieService.add(movie1);
        Movie movie2 = new Movie();
        movie2.setTitle("Big Lebowski");
        movie2.setDescription("Lebowski teaches everyone how to live without saying it"
                + " - not like Vin Diesel");
        movieService.add(movie2);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(10);

        CinemaHallService cinemaHallService = (CinemaHallService)
                injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(cinemaHall);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie2);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setDate(LocalDateTime.of(2020,2,1, 20,00));
        MovieSessionService movieSessionService = (MovieSessionService)
                injector.getInstance(MovieSessionService.class);
        movieSessionService.add(movieSession);

        System.out.println(movieSessionService
                .findAvailableSessions(movie2.getId(), LocalDate.now()));

        User user1 = new User();
        user1.setEmail("test@test.com");
        user1.setPassword("testPass");

        User user2 = new User();
        user2.setEmail("test1@test.com");
        user2.setPassword("testPass2");

        UserService userService = (UserService)
                injector.getInstance(UserService.class);
        userService.add(user1);
        userService.add(user2);
    }
}
